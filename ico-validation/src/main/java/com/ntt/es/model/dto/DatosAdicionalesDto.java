package com.ntt.es.model.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class DatosAdicionalesDto {
	
	@NotNull
	private Integer idSolicitud;
	
	@Valid
	private DatosDomicilioSocialDto domicilioSocial;
	
	@Valid
	private DatosFinancierosDto datosFinancieros;
		

}
