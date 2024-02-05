package com.ntt.es.model.xmlbean;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Solicitud {

	@XmlElement(name = "codigo-entidad")
	private String entidad;

	@XmlElement(name = "codigo-linea")
	private String linea;

	@XmlElement(name = "empresa-digital")
	private String empresaDigital;

	@XmlElement(name = "id-cat-digitalizacion")
	private String categoriaDigitalizacion;

	@XmlElement(name = "modalidad")
	private String modalidad;

	@XmlElement(name = "importe-total-financiacion-cliente")
	private double importeTotalSolicitado;

	@XmlElement(name = "importe-solicitado-financiacion-ico")
	private double importeSolicitadoICO;

	@XmlElement(name = "importe-inversion-activos-fijos")
	private double importeInversionActivosFijos;

	@XmlElement(name = "importe-inversion-circulante")
	private double importeInversionCirculante;

	@XmlElement(name = "importe-total-inversion")
	private double importeTotalInversion;

	@XmlElement(name = "pais-destino-inversion")
	private String paisDestinoInversion;

	@XmlElement(name = "cp-inversion")
	private String codigoPostalInversion;

	@XmlElement(name = "fecha-pago-primera-factura")
	private Date fechaPagoPrimeraFactura;

	@XmlElement(name = "cnae-inversion")
	private String codigoCNAEInversion;

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
}
