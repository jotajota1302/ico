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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntt.es.model.DatosTitularesDto;
import com.ntt.es.model.SolicitudFinanciacionDto;
import com.ntt.es.service.SolicitudService;
import com.ntt.es.validation.groups.TipoCliente;

@RestController
@RequestMapping("/solicitud")
@CrossOrigin
public class SolicitudController {

	private static Logger log = LoggerFactory.getLogger(SolicitudController.class);

	@Autowired
	private SolicitudService service;

	@PostMapping
	public ResponseEntity<String> crearSolicitud(@Valid @RequestBody SolicitudFinanciacionDto solicitud,
			BindingResult bindingResult) {

		log.debug("creando solicitud despues de las validaciones");

		List<String> errores = new ArrayList<>();

		if (bindingResult.hasErrors()) {

			log.debug("existen errores de validacion : " + bindingResult.getErrorCount());

			bindingResult.getAllErrors().forEach(e -> {
				errores.add(e.getDefaultMessage());
			});

			return new ResponseEntity<>(errores.toString(), HttpStatus.BAD_REQUEST);
		}

		service.guardarSolicitud(solicitud);

		return ResponseEntity.ok("Solicitud creada exitosamente.");
	}

	@PostMapping("/titulares")
	public ResponseEntity<String> guardarTitulares(@Validated(TipoCliente.All.class) @RequestBody DatosTitularesDto titulares, BindingResult bindingResult) {

		log.debug("actualizando titulares");
		
		if(titulares.getIdSolicitud()==null) {
			return new ResponseEntity<>("el id de la solicitud es obligatorio", HttpStatus.BAD_REQUEST);
		}
		
		List<String> errores = new ArrayList<>();

		if (bindingResult.hasErrors()) {

			log.debug("existen errores de validacion : " + bindingResult.getErrorCount());

			bindingResult.getAllErrors().forEach(e -> {
				errores.add(e.getDefaultMessage());
			});

			return new ResponseEntity<>(errores.toString(), HttpStatus.BAD_REQUEST);
		}

		service.guardarTitulares(titulares);

		return ResponseEntity.ok("Titulares guardados exitosamente.");
	}
	
	


	@SuppressWarnings("unused")
	private void validate() {

		log.debug("validando");

		service.validate();

	}

}
