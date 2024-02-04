package com.ntt.es.model.xmlbean;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import lombok.Data;
import lombok.ToString;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
@ToString
public class Entidad {
    
	@XmlElement(name = "nif-entidad")
    private String nifEntidad;

    @XmlElement(name = "empleados-entidad")
    private String empleadosEntidad;
    
	@XmlElement(name = "fondos-propios-entidad")
    private BigDecimal fondosPropiosEntidad;

    @XmlElement(name = "facturacion-entidad")
    private BigDecimal facturacionEntidad;

    @XmlElement(name = "activo-total-entidad")
    private BigDecimal activoTotalEntidad;
    
    @XmlElement(name = "fecha-constitucion-entidad")
    private Date fechaConstitucionEntidad;
        
  
}
