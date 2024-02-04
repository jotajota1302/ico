package com.ntt.es.model.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class DatosDomicilioSocialDto {

	@NotBlank(message = "El tipo de vía no puede estar vacío.")
	@Pattern(regexp = "[a-zA-Z0-9.,;ñáéíóúüÑÁÉÍÓÚÜàèìòùÀÈÌÒÙ]+", message = "El tipo de vía solo puede contener letras, dígitos y los caracteres .,;ñáéíóúüÑÁÉÍÓÚÜàèìòùÀÈÌÒÙ")
	private String tipoVia;

	@NotBlank(message = "El nombre de vía no puede estar vacío.")
	@Pattern(regexp = "[a-zA-Z0-9.,;ñáéíóúüÑÁÉÍÓÚÜàèìòùÀÈÌÒÙ]+", message = "El nombre de vía solo puede contener letras, dígitos y los caracteres .,;ñáéíóúüÑÁÉÍÓÚÜàèìòùÀÈÌÒÙ")
	private String nombreVia;

	@NotNull(message = "El número de vía no puede ser nulo.")
	@Digits(integer = 5, fraction = 0, message = "El número de vía debe contener como máximo 5 dígitos.")
	private Integer numeroVia;

	@NotBlank(message = "La población no puede estar vacía.")
	@Pattern(regexp = "[a-zA-Z0-9.,;ñáéíóúüÑÁÉÍÓÚÜàèìòùÀÈÌÒÙ]+", message = "La población solo puede contener letras, dígitos y los caracteres .,;ñáéíóúüÑÁÉÍÓÚÜàèìòùÀÈÌÒÙ")
	private String poblacion;

	@Size(min = 5, max = 5, message = "El código postal debe tener exactamente 5 caracteres.")
	@Pattern(regexp = "[0-9]+", message = "El código postal debe contener solo números.")
	private String codigoPostal;

}
