package com.ntt.es;

import com.ntt.es.service.XMLService;
import com.ntt.es.service.impl.XMLServiceImpl;
import com.ntt.es.xmlbean.Solicitud;
import com.ntt.es.xmlbean.Solicitudes;

public class LaunchXML {

	public static String[] XML_FILES = {
			"./src/main/resources/ejemplo Autonomo/Carga XML Solicitud MED v2_1.xml",
			"./src/main/resources/ejemplo Empresa Privada/20240118_Carga XML Solicitud MED v1_1.xml",
			"./src/main/resources/ejemplo Empresa Privada/20240118_Carga XML Solicitud MED v1_2.xml",
			"./src/main/resources/ejemplo Empresa Privada/20240118_Carga XML Solicitud MED v1_3.xml",
			"./src/main/resources/ejemplo Empresa Privada y Autonomo/20240118_Carga XML Solicitud MED v3_1.xml",
			"./src/main/resources/ejemplo Empresa Privada y Autonomo/20240118_Carga XML Solicitud MED v3_2.xml",
			"./src/main/resources/ejemplo Empresa Privada y Autonomo/20240118_Carga XML Solicitud MED v3_3.xml",
	};
	
	
	public static void main(String[] args) {
		XMLService service = new XMLServiceImpl();
		for(String path : XML_FILES) {
			Solicitudes solicitudes = service.getSolicitudes(path);
			System.out.println();
			System.out.println("FICHERO: " + path);
			// Acceder a los objetos Java
	        if (solicitudes != null) {
	        	for (Solicitud solicitud : solicitudes.getSolicitudes()) {
	                System.out.println("\t" + solicitud.toString());
	        	}
	           
	        }
		}
	}
}
