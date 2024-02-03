package com.ntt.es.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class DatosAdicionalesDto {
	
	@NotNull
	private Integer idSolicitud;
	
	private DatosDomicilioSocialDto domicilioSocial;
	
	private DatosFinancierosDto datosFinancieros;
	
	

    

	

}
