package com.ntt.es.model.xmlbean;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name = "solicitudes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Solicitudes {
    @XmlElement(name = "solicitud")
    private List<Solicitud> solicitudes;

}
