package com.ntt.es.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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

	@NotNull(message = "El código postal no puede ser nulo.")
	@Digits(integer = 5, fraction = 0, message = "El código postal debe contener como máximo 5 dígitos.")
	@Min(value = 10000, message = "El código postal debe tener al menos 5 dígitos.")
	@Max(value = 99999, message = "El código postal debe tener como máximo 5 dígitos.")
	private Integer codigoPostal;

	

}
