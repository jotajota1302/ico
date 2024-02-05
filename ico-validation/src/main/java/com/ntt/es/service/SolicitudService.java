package com.ntt.es.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ntt.es.model.dto.DatosAdicionalesDto;
import com.ntt.es.model.dto.DatosTitularesDto;
import com.ntt.es.model.dto.SolicitudFinanciacionDto;
import com.ntt.es.model.xmlbean.Solicitud;

public interface SolicitudService {
	
	public int guardarSolicitud(SolicitudFinanciacionDto solicitud);
	
	public void guardarDatosTitulares(DatosTitularesDto titulares);
	
	public void guardarDatosAdicionales(DatosAdicionalesDto adicionales);
	
	public List<?> validate(SolicitudFinanciacionDto solicitudDto, boolean modoCarga);

	public List<String> cargarSolicitudes(List<Solicitud> solicitudesList);

	//Documentación
	public List<String> cargarDocumentosSolicitud(MultipartFile file, Integer idSolicitud, Integer idTitular, Integer idTipoDoc);

	//Control de Fases
	public boolean cambiarFase(Integer idSolicitud, Integer idFase);
	
}
