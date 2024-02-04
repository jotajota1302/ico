package com.ntt.es.service;

import java.util.List;

import com.ntt.es.model.dto.DatosAdicionalesDto;
import com.ntt.es.model.dto.DatosTitularesDto;
import com.ntt.es.model.dto.SolicitudFinanciacionDto;

public interface SolicitudService {
	
	public int guardarSolicitud(SolicitudFinanciacionDto solicitud);
	
	public void guardarDatosTitulares(DatosTitularesDto titulares);
	
	public void guardarDatosAdicionales(DatosAdicionalesDto adicionales);
	
	public List<?> validate();

}
