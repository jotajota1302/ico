package com.ntt.es.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ntt.es.model.SolicitudFinanciacionDTO;
import com.ntt.es.service.SolicitudService;

@Service
public class SolicitudServiceImpl implements SolicitudService {

	private static Logger log = LoggerFactory.getLogger(SolicitudServiceImpl.class);

	@Override
	public int guardarSolicitud(SolicitudFinanciacionDTO solicitud) {

		log.debug("guardando solicitud");

		// TODO llamar al repository y guardado

		log.debug("solicituda guardada");

		return 0;

	}

	@Override
	public int guardarSolicitudParcial(SolicitudFinanciacionDTO solicitud) {

		log.debug("guardando borrador");

		// TODO llamar al repository y guardado

		log.debug("borrador guardado");

		return 0;
	}

	public List<String> validate() {

		List<String> errores = new ArrayList<>();
		
		// Obtén el validador
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		// Crea tu objeto a validar o lo que conviertes del xml
		SolicitudFinanciacionDTO solicitud = new SolicitudFinanciacionDTO();
		solicitud.setLinea("ICO MRR Promoción Vivienda Social");

		// Realiza la validación
		Set<ConstraintViolation<SolicitudFinanciacionDTO>> violations = validator.validate(solicitud);

		violations.forEach(v -> {
			errores.add(v.getMessage());
		});

		return errores;

	}
}
