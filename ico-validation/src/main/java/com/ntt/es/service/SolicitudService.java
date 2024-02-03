package com.ntt.es.service;

import java.util.List;

import com.ntt.es.model.SolicitudFinanciacionDTO;

public interface SolicitudService {
	
	public int guardarSolicitud(SolicitudFinanciacionDTO solicitud);
	
	public int guardarSolicitudParcial(SolicitudFinanciacionDTO solicitud);
	
	public List<?> validate();

}
