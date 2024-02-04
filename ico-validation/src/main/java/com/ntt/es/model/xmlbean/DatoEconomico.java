package com.ntt.es.model.xmlbean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.FIELD)
public class DatoEconomico {
    
	@XmlElement(name = "grupo")
    private String grupo;

    @XmlElement(name = "consolidado")
    private String consolidado;
    
    @XmlElement(name = "nif-matriz")
    private String nifMatriz;
    
    @XmlElement(name = "pais-matriz")
    private String paisMatriz;
    
    @XmlElement(name = "empleados-grupo")
    private Integer empleadosGrupo;
    
    @XmlElement(name = "fondos-propios-grupo")
    private BigDecimal fondosPropiosGrupo;
    
    @XmlElement(name = "facturacion-grupo")
    private BigDecimal facturacionGrupo;
    
    @XmlElement(name = "activo-total-grupo")
    private BigDecimal activoTotalGrupo;
    
    @XmlElement(name = "fecha-constitucion-matriz")
    private Date fechaConstitucionMatriz;
    
    @XmlElementWrapper(name = "entidades")
    @XmlElement(name = "entidad")
    private List<Entidad> entidades;

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getConsolidado() {
		return consolidado;
	}

	public void setConsolidado(String consolidado) {
		this.consolidado = consolidado;
	}

	public String getNifMatriz() {
		return nifMatriz;
	}

	public void setNifMatriz(String nifMatriz) {
		this.nifMatriz = nifMatriz;
	}

	public String getPaisMatriz() {
		return paisMatriz;
	}

	public void setPaisMatriz(String paisMatriz) {
		this.paisMatriz = paisMatriz;
	}

	public Integer getEmpleadosGrupo() {
		return empleadosGrupo;
	}

	public void setEmpleadosGrupo(Integer empleadosGrupo) {
		this.empleadosGrupo = empleadosGrupo;
	}

	public BigDecimal getFondosPropiosGrupo() {
		return fondosPropiosGrupo;
	}

	public void setFondosPropiosGrupo(BigDecimal fondosPropiosGrupo) {
		this.fondosPropiosGrupo = fondosPropiosGrupo;
	}

	public BigDecimal getFacturacionGrupo() {
		return facturacionGrupo;
	}

	public void setFacturacionGrupo(BigDecimal facturacionGrupo) {
		this.facturacionGrupo = facturacionGrupo;
	}

	public BigDecimal getActivoTotalGrupo() {
		return activoTotalGrupo;
	}

	public void setActivoTotalGrupo(BigDecimal activoTotalGrupo) {
		this.activoTotalGrupo = activoTotalGrupo;
	}

	public Date getFechaConstitucionMatriz() {
		return fechaConstitucionMatriz;
	}

	public void setFechaConstitucionMatriz(Date fechaConstitucionMatriz) {
		this.fechaConstitucionMatriz = fechaConstitucionMatriz;
	}

	public List<Entidad> getEntidades() {
		return entidades;
	}

	public void setEntidades(List<Entidad> entidades) {
		this.entidades = entidades;
	}

	@Override
	public String toString() {
		return  "\n\t\t\tDatoEconomico [grupo=" + grupo + ", consolidado=" + consolidado + ", nifMatriz=" + nifMatriz
				+ ", paisMatriz=" + paisMatriz + ", empleadosGrupo=" + empleadosGrupo + ", fondosPropiosGrupo="
				+ fondosPropiosGrupo + ", facturacionGrupo=" + facturacionGrupo + ", activoTotalGrupo="
				+ activoTotalGrupo + ", fechaConstitucionMatriz=" + fechaConstitucionMatriz + ", entidades=" + entidades
				+ "]";
	}

}
