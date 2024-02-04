package com.ntt.es.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ntt.es.model.xmlbean.Solicitudes;
import com.ntt.es.service.XmlService;



@Service
public class XmlServiceImpl implements XmlService{

	public Solicitudes getSolicitudes(String filePath) {
        try {
        	File xmlFile = new File(filePath);
            // Crear el contexto JAXB y el unmarshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(Solicitudes.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            //StringReader reader = new StringReader(xmlFile);
            return (Solicitudes) unmarshaller.unmarshal(xmlFile);

        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
	
	public Solicitudes getSolicitudesMF(MultipartFile filePath) {
        try {
        	InputStream xmlFile = filePath.getInputStream();
            // Crear el contexto JAXB y el unmarshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(Solicitudes.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            //StringReader reader = new StringReader(xmlFile);
            return (Solicitudes) unmarshaller.unmarshal(xmlFile);

        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
			e.printStackTrace();
			  return null;
		}
    }
}
