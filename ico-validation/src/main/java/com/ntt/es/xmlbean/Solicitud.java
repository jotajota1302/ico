package com.ntt.es.xmlbean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.FIELD)
public class Solicitud {

	@XmlElement(name = "codigo-entidad")
	private String codigoEntidad;

	@XmlElement(name = "codigo-linea")
	private String codigoLinea;

	@XmlElement(name = "empresa-digital")
	private String empresaDigital;

	@XmlElement(name = "id-cat-digitalizacion")
	private Integer idCatDigitalizacion;

	@XmlElement(name = "modalidad")
	private Integer modalidad;

	@XmlElement(name = "importe-total-financiacion-cliente")
	private BigDecimal importeTotalFinanciacionCliente;

	@XmlElement(name = "importe-solicitado-financiacion-ico")
	private BigDecimal importeSolicitadoFinanciacionIco;

	@XmlElement(name = "importe-inversion-activos-fijos")
	private BigDecimal importeInversionActivosFijos;

	@XmlElement(name = "importe-inversion-circulante")
	private BigDecimal importeInversionCirculante;

	@XmlElement(name = "importe-total-inversion")
	private BigDecimal importeTotalInversion;

	@XmlElement(name = "pais-destino-inversion")
	private String paisDestinoInversion;

	@XmlElement(name = "cp-inversion")
	private String cpInversion;

	@XmlElement(name = "fecha-pago-primera-factura")
	private Date fechaPagoPrimeraFactura;

	@XmlElement(name = "cnae-inversion")
	private String cnaeInversion;

	@XmlElement(name = "interes-esp")
	private Integer interesEsp;

	@XmlElement(name = "justificacion-interes-esp")
	private String justificacionInteresEsp;

	@XmlElement(name = "id-anexo-vi")
	private Integer idAnexoVi;

	@XmlElement(name = "id-anexo-vii")
	private Integer idAnexoVii;

	@XmlElement(name = "id-tipo-via")
	private String idTipoVia;

	@XmlElement(name = "nombre-via")
	private String nombreVia;

	@XmlElement(name = "numero-via")
	private String numeroVia;

	@XmlElement(name = "poblacion")
	private String poblacion;

	@XmlElement(name = "cp-social")
	private String cpSocial;

	@XmlElement(name = "pagina-web")
	private String paginaWeb;

	@XmlElement(name = "correo-electronico")
	private String correoElectronico;

	@XmlElement(name = "cnae-cliente")
	private String cnaeCliente;

	@XmlElementWrapper(name = "titulares")
	@XmlElement(name = "titular")
	private List<Titular> titulares;

	@XmlElement(name = "datos-economicos")
	private DatoEconomico datosEconomicos;

	@XmlElementWrapper(name = "datos-economicos-autonomo")
	@XmlElement(name = "dato-economico-autonomo")
	private List<DatoEconomicoAutonomo> datosEconomicosAutonomo;

	public String getCodigoEntidad() {
		return codigoEntidad;
	}

	public void setCodigoEntidad(String codigoEntidad) {
		this.codigoEntidad = codigoEntidad;
	}

	public String getCodigoLinea() {
		return codigoLinea;
	}

	public void setCodigoLinea(String codigoLinea) {
		this.codigoLinea = codigoLinea;
	}

	public String getEmpresaDigital() {
		return empresaDigital;
	}

	public void setEmpresaDigital(String empresaDigital) {
		this.empresaDigital = empresaDigital;
	}

	public Integer getIdCatDigitalizacion() {
		return idCatDigitalizacion;
	}

	public void setIdCatDigitalizacion(Integer idCatDigitalizacion) {
		this.idCatDigitalizacion = idCatDigitalizacion;
	}

	public Integer getModalidad() {
		return modalidad;
	}

	public void setModalidad(Integer modalidad) {
		this.modalidad = modalidad;
	}

	public BigDecimal getImporteTotalFinanciacionCliente() {
		return importeTotalFinanciacionCliente;
	}

	public void setImporteTotalFinanciacionCliente(BigDecimal importeTotalFinanciacionCliente) {
		this.importeTotalFinanciacionCliente = importeTotalFinanciacionCliente;
	}

	public BigDecimal getImporteSolicitadoFinanciacionIco() {
		return importeSolicitadoFinanciacionIco;
	}

	public void setImporteSolicitadoFinanciacionIco(BigDecimal importeSolicitadoFinanciacionIco) {
		this.importeSolicitadoFinanciacionIco = importeSolicitadoFinanciacionIco;
	}

	public BigDecimal getImporteInversionActivosFijos() {
		return importeInversionActivosFijos;
	}

	public void setImporteInversionActivosFijos(BigDecimal importeInversionActivosFijos) {
		this.importeInversionActivosFijos = importeInversionActivosFijos;
	}

	public BigDecimal getImporteInversionCirculante() {
		return importeInversionCirculante;
	}

	public void setImporteInversionCirculante(BigDecimal importeInversionCirculante) {
		this.importeInversionCirculante = importeInversionCirculante;
	}

	public BigDecimal getImporteTotalInversion() {
		return importeTotalInversion;
	}

	public void setImporteTotalInversion(BigDecimal importeTotalInversion) {
		this.importeTotalInversion = importeTotalInversion;
	}

	public String getPaisDestinoInversion() {
		return paisDestinoInversion;
	}

	public void setPaisDestinoInversion(String paisDestinoInversion) {
		this.paisDestinoInversion = paisDestinoInversion;
	}

	public String getCpInversion() {
		return cpInversion;
	}

	public void setCpInversion(String cpInversion) {
		this.cpInversion = cpInversion;
	}

	public Date getFechaPagoPrimeraFactura() {
		return fechaPagoPrimeraFactura;
	}

	public void setFechaPagoPrimeraFactura(Date fechaPagoPrimeraFactura) {
		this.fechaPagoPrimeraFactura = fechaPagoPrimeraFactura;
	}

	public String getCnaeInversion() {
		return cnaeInversion;
	}

	public void setCnaeInversion(String cnaeInversion) {
		this.cnaeInversion = cnaeInversion;
	}

	public Integer getInteresEsp() {
		return interesEsp;
	}

	public void setInteresEsp(Integer interesEsp) {
		this.interesEsp = interesEsp;
	}

	public String getJustificacionInteresEsp() {
		return justificacionInteresEsp;
	}

	public void setJustificacionInteresEsp(String justificacionInteresEsp) {
		this.justificacionInteresEsp = justificacionInteresEsp;
	}

	public Integer getIdAnexoVi() {
		return idAnexoVi;
	}

	public void setIdAnexoVi(Integer idAnexoVi) {
		this.idAnexoVi = idAnexoVi;
	}

	public Integer getIdAnexoVii() {
		return idAnexoVii;
	}

	public void setIdAnexoVii(Integer idAnexoVii) {
		this.idAnexoVii = idAnexoVii;
	}

	public String getIdTipoVia() {
		return idTipoVia;
	}

	public void setIdTipoVia(String idTipoVia) {
		this.idTipoVia = idTipoVia;
	}

	public String getNombreVia() {
		return nombreVia;
	}

	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}

	public String getNumeroVia() {
		return numeroVia;
	}

	public void setNumeroVia(String numeroVia) {
		this.numeroVia = numeroVia;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getCpSocial() {
		return cpSocial;
	}

	public void setCpSocial(String cpSocial) {
		this.cpSocial = cpSocial;
	}

	public String getPaginaWeb() {
		return paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getCnaeCliente() {
		return cnaeCliente;
	}

	public void setCnaeCliente(String cnaeCliente) {
		this.cnaeCliente = cnaeCliente;
	}

	public List<Titular> getTitulares() {
		return titulares;
	}

	public void setTitulares(List<Titular> titulares) {
		this.titulares = titulares;
	}

	public List<DatoEconomicoAutonomo> getDatosEconomicosAutonomo() {
		return datosEconomicosAutonomo;
	}

	public void setDatosEconomicosAutonomo(List<DatoEconomicoAutonomo> datosEconomicosAutonomo) {
		this.datosEconomicosAutonomo = datosEconomicosAutonomo;
	}

	public DatoEconomico getDatosEconomicos() {
		return datosEconomicos;
	}

	public void setDatosEconomicos(DatoEconomico datosEconomicos) {
		this.datosEconomicos = datosEconomicos;
	}

	@Override
	public String toString() {
		return "Solicitud ["
				+ "\n\t\tcodigoEntidad=" + codigoEntidad + ", "
				+ "\n\t\tcodigoLinea=" + codigoLinea + ", "
				+ "\n\t\tempresaDigital=" + empresaDigital +  ", "
				+ "\n\t\tidCatDigitalizacion=" + idCatDigitalizacion + ", "
				+ "\n\t\tmodalidad=" + modalidad + ", "
				+ "\n\t\timporteTotalFinanciacionCliente=" + importeTotalFinanciacionCliente + ", "
				+ "\n\t\timporteSolicitadoFinanciacionIco=" + importeSolicitadoFinanciacionIco+ ", "
				+ "\n\t\timporteInversionActivosFijos=" + importeInversionActivosFijos + ", "
				+ "\n\t\timporteInversionCirculante=" + importeInversionCirculante + ", "
				+ "\n\t\timporteTotalInversion=" + importeTotalInversion + ", "
				+ "\n\t\tpaisDestinoInversion=" + paisDestinoInversion + ", "
				+ "\n\t\tcpInversion=" + cpInversion + ", "
				+ "\n\t\tfechaPagoPrimeraFactura=" + fechaPagoPrimeraFactura + ", "
				+ "\n\t\tcnaeInversion=" + cnaeInversion + ", "
				+ "\n\t\tinteresEsp=" + interesEsp + ", "
				+ "\n\t\tjustificacionInteresEsp=" + justificacionInteresEsp + ", "
				+ "\n\t\tidAnexoVi=" + idAnexoVi + ", "
				+ "\n\t\tidAnexoVii=" + idAnexoVii + ", "
				+ "\n\t\tidTipoVia=" + idTipoVia + ", "
				+ "\n\t\tnombreVia=" + nombreVia + ", "
				+ "\n\t\tnumeroVia=" + numeroVia + ", "
				+ "\n\t\tpoblacion=" + poblacion + ", "
				+ "\n\t\tcpSocial=" + cpSocial + ", "
				+ "\n\t\tpaginaWeb=" + paginaWeb + ", "
				+ "\n\t\tcorreoElectronico=" + correoElectronico + ", "
				+ "\n\t\tcnaeCliente=" + cnaeCliente + ", "
				+ "\n\t\ttitulares=" + titulares + ", "
				+ "\n\t\tdatosEconomicos=" + datosEconomicos + ", "
				+ "\n\t\tdatosEconomicosAutonomo="+ datosEconomicosAutonomo + "]";
	}

}
