package com.ntt.es.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.ntt.es.validation.annotations.ValidarTipoCliente;

import lombok.Data;

@Data
@ValidarTipoCliente
public class DatosTitularesDto {
	
	@NotNull
	private Integer idSolicitud;
	
	@NotBlank
	private String linea;
	
	@NotBlank(message = "El campo tipo cliente es obligatorio.")
	private String tipoCliente;
	
	

}
