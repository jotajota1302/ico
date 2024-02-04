package com.ntt.es.model.xmlbean;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "solicitudes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Solicitudes {
    @XmlElement(name = "solicitud")
    private List<Solicitud> solicitudes;

	public List<Solicitud> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(List<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}

	@Override
	public String toString() {
		return "Solicitudes [solicitudes=" + solicitudes + "]";
	}
    
    

}
