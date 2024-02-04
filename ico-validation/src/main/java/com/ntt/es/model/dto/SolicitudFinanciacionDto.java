package com.ntt.es.model.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import com.ntt.es.validation.annotations.ValidarCategoriaDigitalizacion;
import com.ntt.es.validation.annotations.ValidarCodigoCampoIntervencionAnexoVII;
import com.ntt.es.validation.annotations.ValidarCodigoPostal;
import com.ntt.es.validation.annotations.ValidarFechaPagoPrimeraFactura;
import com.ntt.es.validation.annotations.ValidarImporteInversionCirculante;
import com.ntt.es.validation.annotations.ValidarIntervencionAnexoVI;
import com.ntt.es.validation.annotations.ValidarModalidad;
import com.ntt.es.validation.annotations.ValidarPaisDestinoInversion;

import lombok.Data;

@Data
@ValidarCategoriaDigitalizacion
@ValidarModalidad
@ValidarImporteInversionCirculante
@ValidarPaisDestinoInversion
@ValidarCodigoPostal
@ValidarFechaPagoPrimeraFactura
@ValidarIntervencionAnexoVI
@ValidarCodigoCampoIntervencionAnexoVII
public class SolicitudFinanciacionDto {
		
	private String entidad;
	
	@NotBlank(message = "El campo Línea es obligatorio.")
	private String linea;

	@NotNull(message = "El campo ¿La empresa es digital? es obligatorio.")
	private Boolean empresaDigital;

	private String categoriaDigitalizacion;

	private String modalidad;

	private Double importeTotalSolicitado;

	private Double importeSolicitadoICO;

	@Positive(message = "El Importe de inversión en activos fijos debe ser superior a 0.")
	private double importeInversionActivosFijos;

	private double importeInversionCirculante;

	private double importeTotalInversion;

	//(Identificador - pais)
	private String paisDestinoInversion;

	private String codigoPostalInversion;

	@NotBlank(message = "El campo interes españoles obligatorio.")
	private String interesEspanol;

	@Pattern(regexp = "[a-zA-Z0-9 .,;ñáéíóúüÑÁÉÍÓÚÜàèìòùÀÈÌÒÙ]{0,1000}", message = "La justificación debe contener máximo 1000 caracteres alfanuméricos.")
	private String justificacionInteresEspanol;

	@NotNull(message = "La Fecha de pago 1ª factura de la inversión es obligatoria.")
	private Date fechaPagoPrimeraFactura;

	@NotBlank(message = "El campo Código CNAE de la inversión es obligatorio.")
	private String codigoCNAEInversion;

	@NotBlank
	private String codigoIntervencionAnexoVI;

	@NotBlank
	private String nombreIntervencionAnexoVI;
	
	@NotBlank
	private String porcentajeIntervencionAnexoVI;

	@NotBlank
	private String codigoCampoIntervencionAnexoVII;
	
	@NotBlank
	private String nombreIntervencionAnexoVII;

	@NotBlank
	private String porcentajeIntervencionAnexoVII;

}
