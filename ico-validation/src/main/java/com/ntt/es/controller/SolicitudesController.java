package com.ntt.es.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ntt.es.service.XMLService;
import com.ntt.es.xmlbean.Solicitudes;

@RestController
@RequestMapping("/solicitudes")
@CrossOrigin
public class SolicitudesController {
	
	private static Logger log = LoggerFactory.getLogger(SolicitudesController.class);
	
	@Autowired
	private XMLService service;
	
	@PostMapping(path = "/carga", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Solicitudes> carga(@RequestParam("xmlFile") MultipartFile file) {

		Solicitudes solicitudes = service.getSolicitudesMF(file);

		return ResponseEntity.ok(solicitudes);
	}
}
