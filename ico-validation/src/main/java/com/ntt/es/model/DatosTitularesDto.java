package com.ntt.es.model;

import java.time.LocalDate;

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

	private String nifTitular;

	private String razonSocialTitular;

	private Boolean esPoderAdjudicador;

	private String nifContratistaTitular;

	private String nifSubcontratistaTitular;

	private String dniNieTitularReal;

	private String primerApellidoTitularReal;

	private String dniNieTitular;

	private String nombreTitular;

	private String primerApellidoTitular;

	private String segundoApellidoTitular;

	private LocalDate fechaNacimiento;

}
