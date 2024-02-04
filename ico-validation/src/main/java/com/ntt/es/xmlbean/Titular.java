package com.ntt.es.xmlbean;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.FIELD)
public class Titular {
    @XmlElement(name = "tipo-cliente")
    private Integer tipoCliente;

    @XmlElement(name = "nif-titular")
    private String nifTitular;

    @XmlElement(name = "nombre-titular")
    private String nombreTitular;

    @XmlElement(name = "primer-apellido-titular")
    private String primerApellidoTitular;

    @XmlElement(name = "segundo-apellido-titular")
    private String segundoApellidoTitular;

    @XmlElement(name = "fecha-nacimiento-titular")
    private Date fechaNacimientoTitular;
    
    @XmlElement(name = "razon-social-titular")
    private String razonSocialTitular;
    
    @XmlElement(name = "poder-adjudicador")
    private String poderAdjudicador;

    @XmlElement(name = "NIF-contratista")
    private String NIFContratista;
    
    @XmlElement(name = "NIF-subcontratista")
    private String NIFSubcontratista;
    
    @XmlElementWrapper(name = "titulares-reales")
    @XmlElement(name = "titular-real")
    private List<TitularReal> titularesReales;


	public Integer getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(Integer tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getNifTitular() {
		return nifTitular;
	}

	public void setNifTitular(String dniTitular) {
		this.nifTitular = dniTitular;
	}

	public String getNombreTitular() {
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public String getPrimerApellidoTitular() {
		return primerApellidoTitular;
	}

	public void setPrimerApellidoTitular(String primerApellidoTitular) {
		this.primerApellidoTitular = primerApellidoTitular;
	}

	public String getSegundoApellidoTitular() {
		return segundoApellidoTitular;
	}

	public void setSegundoApellidoTitular(String segundoApellidoTitular) {
		this.segundoApellidoTitular = segundoApellidoTitular;
	}

	public Date getFechaNacimientoTitular() {
		return fechaNacimientoTitular;
	}

	public void setFechaNacimientoTitular(Date fechaNacimientoTitular) {
		this.fechaNacimientoTitular = fechaNacimientoTitular;
	}

	public String getRazonSocialTitular() {
		return razonSocialTitular;
	}
	
	public void setRazonSocialTitular(String razonSocialTitular) {
		this.razonSocialTitular = razonSocialTitular;
	}
	
	public String getPoderAdjudicador() {
		return poderAdjudicador;
	}
	
	public void setPoderAdjudicador(String poderAdjudicador) {
		this.poderAdjudicador = poderAdjudicador;
	}
	
	public String getNIFContratista() {
		return NIFContratista;
	}
	
	public void setNIFContratista(String nIFContratista) {
		NIFContratista = nIFContratista;
	}
	
	public String getNIFSubcontratista() {
		return NIFSubcontratista;
	}
	
	public void setNIFSubcontratista(String nIFSubcontratista) {
		NIFSubcontratista = nIFSubcontratista;
	}
	
	public List<TitularReal> getTitularesReales() {
		return titularesReales;
	}
	
	public void setTitularesReales(List<TitularReal> titularesReales) {
		this.titularesReales = titularesReales;
	}

	@Override
	public String toString() {
		return "\n\t\t\tTitular ["
				+ "\n\t\t\t\ttipoCliente=" + tipoCliente + ", "
				+ "\n\t\t\t\tdniTitular=" + nifTitular + ", "
				+ "\n\t\t\t\tnombreTitular=" + nombreTitular + ", "
				+ "\n\t\t\t\tprimerApellidoTitular=" + primerApellidoTitular + ", "
				+ "\n\t\t\t\tsegundoApellidoTitular=" + segundoApellidoTitular + ", "
				+ "\n\t\t\t\tfechaNacimientoTitular=" + fechaNacimientoTitular + ", "
				+ "\n\t\t\t\trazonSocialTitular=" + razonSocialTitular + ", "
				+ "\n\t\t\t\tpoderAdjudicador=" + poderAdjudicador + ", "
				+ "\n\t\t\t\tNIFContratista=" + NIFContratista + ", "
				+ "\n\t\t\t\tNIFSubcontratista=" + NIFSubcontratista + ", "
				+ "\n\t\t\t\ttitularesReales=" + titularesReales + "]";
	}
	
	

}
