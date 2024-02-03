package com.ntt.es.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class DatosAdicionalesDto {
	
	@NotNull
	private Integer idSolicitud;
	
	@NotBlank
	private String linea;
	
	

    

	

}
