package com.ntt.es.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntt.es.model.SolicitudFinanciacionDTO;

@RestController
@RequestMapping("/datosgenerales")
@CrossOrigin
public class DatosGeneralesController {

	private static Logger log = LoggerFactory.getLogger(DatosGeneralesController.class);

	@PostMapping("/crear")
	public ResponseEntity<String> crearSolicitud(@Valid @RequestBody SolicitudFinanciacionDTO solicitudDTO,
			BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			List<String> errores = new ArrayList<>();
			for (FieldError error : bindingResult.getFieldErrors()) {
				String mensajeError = error.getField() + ": " + error.getDefaultMessage();
				errores.add(mensajeError);
			}
			return new ResponseEntity<>(errores.toString(), HttpStatus.BAD_REQUEST);
		}

		log.debug("creando solicitud despues de las validaciones");

		return ResponseEntity.ok("Solicitud creada exitosamente.");
	}

	//TO DO este metodo es para ver como lanzar las validaciones a mano y se podra usar en la carga masiva que no lo parsea Spring
	@SuppressWarnings("unused")
	private void validate() {
		
		  // Obtén el validador
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // Crea tu objeto a validar
        SolicitudFinanciacionDTO solicitud = new SolicitudFinanciacionDTO();
        solicitud.setLinea("ICO MRR Promoción Vivienda Social");
       
        // Realiza la validación
        Set<ConstraintViolation<SolicitudFinanciacionDTO>> violations = validator.validate(solicitud);
		
	}

}
