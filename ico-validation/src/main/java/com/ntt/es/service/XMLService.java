package com.ntt.es.service;

import org.springframework.web.multipart.MultipartFile;

import com.ntt.es.xmlbean.Solicitudes;

public interface XMLService {

	public Solicitudes getSolicitudes(String filePath);
	
	public Solicitudes getSolicitudesMF(MultipartFile filePath);
}
