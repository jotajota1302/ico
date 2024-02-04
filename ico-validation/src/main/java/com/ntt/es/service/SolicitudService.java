package com.ntt.es.service;

import java.util.List;

import com.ntt.es.model.dto.DatosAdicionalesDto;
import com.ntt.es.model.dto.DatosTitularesDto;
import com.ntt.es.model.dto.SolicitudFinanciacionDto;
import com.ntt.es.model.xmlbean.Solicitud;
import com.ntt.es.model.xmlbean.Solicitudes;

public interface SolicitudService {
	
	public int guardarSolicitud(SolicitudFinanciacionDto solicitud);
	
	public void guardarDatosTitulares(DatosTitularesDto titulares);
	
	public void guardarDatosAdicionales(DatosAdicionalesDto adicionales);
	
	public List<?> validate(SolicitudFinanciacionDto solicitudDto, boolean modoCarga);

	public List<String> cargarSolicitudes(List<Solicitud> solicitudesList);

}
