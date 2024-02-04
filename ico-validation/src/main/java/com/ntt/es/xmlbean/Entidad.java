package com.ntt.es.xmlbean;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
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
    
    public BigDecimal getActivoTotalEntidad() {
		return activoTotalEntidad;
	}
    
    public void setActivoTotalEntidad(BigDecimal activoTotalEntidad) {
		this.activoTotalEntidad = activoTotalEntidad;
	}
    
    public String getEmpleadosEntidad() {
		return empleadosEntidad;
	}
    
    public void setEmpleadosEntidad(String empleadosEntidad) {
		this.empleadosEntidad = empleadosEntidad;
	}
    
    public BigDecimal getFacturacionEntidad() {
		return facturacionEntidad;
	}
    public void setFacturacionEntidad(BigDecimal facturacionEntidad) {
		this.facturacionEntidad = facturacionEntidad;
	}
    
    public Date getFechaConstitucionEntidad() {
		return fechaConstitucionEntidad;
	}
    public void setFechaConstitucionEntidad(Date fechaConstitucionEntidad) {
		this.fechaConstitucionEntidad = fechaConstitucionEntidad;
	}
    
    public BigDecimal getFondosPropiosEntidad() {
		return fondosPropiosEntidad;
	}
    
    public void setFondosPropiosEntidad(BigDecimal fondosPropiosEntidad) {
		this.fondosPropiosEntidad = fondosPropiosEntidad;
	}
    
    public String getNifEntidad() {
		return nifEntidad;
	}
    
    public void setNifEntidad(String nifEntidad) {
		this.nifEntidad = nifEntidad;
	}

	@Override
	public String toString() {
		return "\n\t\t\t\tEntidad [nifEntidad=" + nifEntidad + ", empleadosEntidad=" + empleadosEntidad
				+ ", fondosPropiosEntidad=" + fondosPropiosEntidad + ", facturacionEntidad=" + facturacionEntidad
				+ ", activoTotalEntidad=" + activoTotalEntidad + ", fechaConstitucionEntidad="
				+ fechaConstitucionEntidad + "]";
	}
    
    
  
}
