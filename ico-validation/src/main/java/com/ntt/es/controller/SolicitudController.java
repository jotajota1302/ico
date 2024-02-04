package com.ntt.es.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ntt.es.model.dto.DatosAdicionalesDto;
import com.ntt.es.model.dto.DatosTitularesDto;
import com.ntt.es.model.dto.SolicitudFinanciacionDto;
import com.ntt.es.model.xmlbean.Solicitudes;
import com.ntt.es.service.SolicitudService;
import com.ntt.es.service.XmlService;

@RestController
@RequestMapping("/solicitud")
@CrossOrigin
public class SolicitudController {

	private static Logger log = LoggerFactory.getLogger(SolicitudController.class);

	@Autowired
	private SolicitudService solicitudService;
	
	@Autowired
	private XmlService loadService;

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

		solicitudService.guardarSolicitud(solicitud);

		return ResponseEntity.ok("Solicitud creada exitosamente.");
	}

	@PostMapping("/titulares")
	public ResponseEntity<String> guardarTitulares(@Valid @RequestBody DatosTitularesDto titulares, BindingResult bindingResult) {

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

		solicitudService.guardarDatosTitulares(titulares);

		return ResponseEntity.ok("Titulares guardados exitosamente.");
	}
	
	@PostMapping("/adicionales")
	public ResponseEntity<String> guardarAdicionales(@Valid @RequestBody DatosAdicionalesDto adicionales, BindingResult bindingResult) {

		log.debug("actualizando titulares");
		
		if(adicionales.getIdSolicitud()==null) {
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

		solicitudService.guardarDatosAdicionales(adicionales);

		return ResponseEntity.ok("Titulares guardados exitosamente.");
	}
	

	
	@PostMapping(path = "/load", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> carga(@RequestParam("xmlFile") MultipartFile file) {

		Solicitudes solicitudes = loadService.getSolicitudesMF(file);

		//TODO convertir a los DTO y validar las solicitudes
		
		solicitudService.guardarSolicitud(null);
		
		return ResponseEntity.ok(solicitudes);
	}
	
	

}
