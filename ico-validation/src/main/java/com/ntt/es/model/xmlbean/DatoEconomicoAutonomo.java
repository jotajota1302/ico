package com.ntt.es.model.xmlbean;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class DatoEconomicoAutonomo {
    @XmlElement(name = "nif-autonomo")
    private String nifAutonomo;

    @XmlElement(name = "empleados-total-cierre-autonomo")
    private Integer empleadosTotalCierreAutonomo;

    @XmlElement(name = "facturacion-periodo-anterior-autonomo")
    private BigDecimal facturacionPeriodoAnteriorAutonomo;

    @XmlElement(name = "fecha-alta-iae")
    private Date fechaAltaIae;

	public String getNifAutonomo() {
		return nifAutonomo;
	}

	public void setNifAutonomo(String nifAutonomo) {
		this.nifAutonomo = nifAutonomo;
	}

	public Integer getEmpleadosTotalCierreAutonomo() {
		return empleadosTotalCierreAutonomo;
	}

	public void setEmpleadosTotalCierreAutonomo(Integer empleadosTotalCierreAutonomo) {
		this.empleadosTotalCierreAutonomo = empleadosTotalCierreAutonomo;
	}

	public BigDecimal getFacturacionPeriodoAnteriorAutonomo() {
		return facturacionPeriodoAnteriorAutonomo;
	}

	public void setFacturacionPeriodoAnteriorAutonomo(BigDecimal facturacionPeriodoAnteriorAutonomo) {
		this.facturacionPeriodoAnteriorAutonomo = facturacionPeriodoAnteriorAutonomo;
	}

	public Date getFechaAltaIae() {
		return fechaAltaIae;
	}

	public void setFechaAltaIae(Date fechaAltaIae) {
		this.fechaAltaIae = fechaAltaIae;
	}

	@Override
	public String toString() {
		return "\n\t\t\tDatoEconomicoAutonomo [nifAutonomo=" + nifAutonomo + ", empleadosTotalCierreAutonomo="
				+ empleadosTotalCierreAutonomo + ", facturacionPeriodoAnteriorAutonomo="
				+ facturacionPeriodoAnteriorAutonomo + ", fechaAltaIae=" + fechaAltaIae + "]";
	}
	
	

}
