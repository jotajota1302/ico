package com.ntt.es.service;

import java.util.List;

import com.ntt.es.model.DatosAdicionalesDto;
import com.ntt.es.model.DatosTitularesDto;
import com.ntt.es.model.SolicitudFinanciacionDto;

public interface SolicitudService {
	
	public int guardarSolicitud(SolicitudFinanciacionDto solicitud);
	
	public void guardarDatosTitulares(DatosTitularesDto titulares);
	
	public void guardarDatosAdicionales(DatosAdicionalesDto adicionales);
	
	public List<?> validate();

}
