package com.ntt.es.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ntt.es.model.xmlbean.Solicitud;
import com.ntt.es.model.xmlbean.Solicitudes;
import com.ntt.es.service.XmlService;

@SpringBootTest
class XmlLoadTest {

	@Autowired
	XmlService service;

	public static String[] XML_FILES = { "./src/test/resources/ejemplo Autonomo/Carga XML Solicitud MED v2_1.xml",
			"./src/test/resources/ejemplo Empresa Privada/20240118_Carga XML Solicitud MED v1_1.xml",
			"./src/test/resources/ejemplo Empresa Privada/20240118_Carga XML Solicitud MED v1_2.xml",
			"./src/test/resources/ejemplo Empresa Privada/20240118_Carga XML Solicitud MED v1_3.xml",
			"./src/test/resources/ejemplo Empresa Privada y Autonomo/20240118_Carga XML Solicitud MED v3_1.xml",
			"./src/test/resources/ejemplo Empresa Privada y Autonomo/20240118_Carga XML Solicitud MED v3_2.xml",
			"./src/test/resources/ejemplo Empresa Privada y Autonomo/20240118_Carga XML Solicitud MED v3_3.xml", };

	@Test
	void test() {

		for (String path : XML_FILES) {
			Solicitudes solicitudes = service.getSolicitudes(path);
			System.out.println();
			System.out.println("FICHERO: " + path);
			if (solicitudes != null) {
				for (Solicitud solicitud : solicitudes.getSolicitudes()) {
					System.out.println("\t" + solicitud.toString());
				}
			}
		}

	}

}
