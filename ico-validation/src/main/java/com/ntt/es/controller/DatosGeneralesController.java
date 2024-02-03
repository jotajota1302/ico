package com.ntt.es.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntt.es.model.SolicitudFinanciacionDTO;
import com.ntt.es.service.SolicitudService;

@RestController
@RequestMapping("/solicitud")
@CrossOrigin
public class DatosGeneralesController {

	private static Logger log = LoggerFactory.getLogger(DatosGeneralesController.class);

	@Autowired
	private SolicitudService service;
	
	@PostMapping
	public ResponseEntity<String> crearSolicitud(@Valid @RequestBody SolicitudFinanciacionDTO solicitud,
			BindingResult bindingResult) {
		
		log.debug("creando solicitud despues de las validaciones");
		
		List<String> errores = new ArrayList<>();
				
		if (bindingResult.hasErrors()) {
						
			log.debug("existen errores de validacion : " + bindingResult.getErrorCount());
			
			bindingResult.getAllErrors().forEach(e->{
				errores.add(e.getDefaultMessage());
			});
			
			return new ResponseEntity<>(errores.toString(), HttpStatus.BAD_REQUEST);
		}

		
		
		service.guardarSolicitud(solicitud);

		return ResponseEntity.ok("Solicitud creada exitosamente.");
	}
	
	@PostMapping("/guardarBorrador")
	public ResponseEntity<String> guardarBorrador(@RequestBody SolicitudFinanciacionDTO solicitud,
			BindingResult bindingResult) {
				
		log.debug("guardando borrador");
		
		service.guardarSolicitudParcial(solicitud);

		return ResponseEntity.ok("borrador guardado");
	}


	@SuppressWarnings("unused")
	private void validate() {
		
		log.debug("validando");
		
		service.validate();
		
	}

}
