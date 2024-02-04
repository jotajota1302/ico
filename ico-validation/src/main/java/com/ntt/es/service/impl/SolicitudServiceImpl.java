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

import com.ntt.es.model.dto.DatosAdicionalesDto;
import com.ntt.es.model.dto.DatosTitularesDto;
import com.ntt.es.model.dto.SolicitudFinanciacionDto;
import com.ntt.es.service.SolicitudService;

@Service
public class SolicitudServiceImpl implements SolicitudService {

	private static Logger log = LoggerFactory.getLogger(SolicitudServiceImpl.class);

	@Override
	public int guardarSolicitud(SolicitudFinanciacionDto solicitud) {

		log.debug("guardando solicitud");

		// TODO llamar al repository y guardado

		log.debug("solicituda guardada");

		return 0;

	}
	
	
	@Override
	public void guardarDatosTitulares(DatosTitularesDto titulares) {
				
		log.debug("guardando titulares");
		
		// TODO  logica de guardar los titulares en bbdd
		
		log.debug("datos titulares guardados");
		
	}
	
	@Override
	public void guardarDatosAdicionales(DatosAdicionalesDto adicionales) {
		
		log.debug("guardando adicionales");
		
		// TODO  logica de guardar los titulares en bbdd
		
		log.debug("datos adicionales guardados");
		
	}

	public List<String> validate() {

		List<String> errores = new ArrayList<>();
		
		// Obtén el validador
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		// Crea tu objeto a validar o lo que conviertes del xml
		SolicitudFinanciacionDto solicitud = new SolicitudFinanciacionDto();
		solicitud.setLinea("ICO MRR Promoción Vivienda Social");

		// Realiza la validación
		Set<ConstraintViolation<SolicitudFinanciacionDto>> violations = validator.validate(solicitud);

		violations.forEach(v -> {
			errores.add(v.getMessage());
		});

		return errores;

	}


	

	
}
