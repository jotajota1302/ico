package com.ntt.es.service;

import org.springframework.web.multipart.MultipartFile;

import com.ntt.es.model.xmlbean.Solicitudes;

public interface XmlService {

	public Solicitudes getSolicitudes(String filePath);
	
	public Solicitudes getSolicitudesMF(MultipartFile filePath);
}
