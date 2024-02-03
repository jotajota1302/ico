package com.ntt.es.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.ntt.es.validation.annotations.ValidarTipoCliente;
import com.ntt.es.validation.groups.TipoCliente;

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
	
	@NotNull(message = "El NIF titular no puede ser nulo")
    @Pattern(regexp = "[a-zA-Z0-9]+", message = "El NIF titular solo puede contener letras y dígitos")
    private String nifTitular;

    @NotNull(message = "La Razón Social titular no puede ser nula")
    @Pattern(regexp = "[a-zA-Z0-9.,;ñáéíóúüÑÁÉÍÓÚÜàèìòùÀÈÌÒÙ]+", message = "La Razón Social titular solo puede contener letras, dígitos y los caracteres .,;ñáéíóúüÑÁÉÍÓÚÜàèìòùÀÈÌÒÙ")
    private String razonSocialTitular;

    @NotNull(message = "El campo '¿Es la empresa un poder adjudicador?' no puede ser nulo")
    private Boolean esPoderAdjudicador;

    @Pattern(regexp = "[a-zA-Z0-9]+", message = "El NIF Contratista titular solo puede contener letras y dígitos")
    private String nifContratistaTitular;

    @Pattern(regexp = "[a-zA-Z0-9]+", message = "El NIF Subcontratista titular solo puede contener letras y dígitos")
    private String nifSubcontratistaTitular;

    @Pattern(regexp = "[a-zA-Z0-9]+", message = "El DNI/NIE titular real solo puede contener letras y dígitos")
    private String dniNieTitularReal;

    @Pattern(regexp = "[a-zA-Z0-9.,;ñáéíóúüÑÁÉÍÓÚÜàèìòùÀÈÌÒÙ]+", message = "El Primer apellido titular real solo puede contener letras, dígitos y los caracteres .,;ñáéíóúüÑÁÉÍÓÚÜàèìòùÀÈÌÒÙ")
    private String primerApellidoTitularReal;
	
	//Validaciones solo para autonomos y Hogar
	
	@NotBlank(message = "El campo 'DNI no puede estar vacío'", groups = {TipoCliente.Autonomo.class, TipoCliente.Hogar.class})
	@Pattern(regexp = "^[0-9A-Za-z]{9}$", message = "El NIF/NIE titular no es válido", groups = {TipoCliente.Autonomo.class, TipoCliente.Hogar.class})
	private String dniNieTitular;
	
    @NotBlank(message = "El campo 'Nombre titular' no puede estar vacio", groups = {TipoCliente.Autonomo.class,TipoCliente.Hogar.class})
    @Pattern(regexp = "[a-zA-Z0-9.,;ñáéíóúüÑÁÉÍÓÚÜàèìòùÀÈÌÒÙ]+", message = "El Nombre titular solo puede contener letras, dígitos y los caracteres .,;ñáéíóúüÑÁÉÍÓÚÜàèìòùÀÈÌÒÙ",groups = {TipoCliente.Autonomo.class,TipoCliente.Hogar.class})
    private String nombreTitular;
    
    @NotNull(message = "El campo 'Fecha de nacimiento' no puede ser nulo", groups = {TipoCliente.Autonomo.class,TipoCliente.Hogar.class})
    private LocalDate fechaNacimiento;

    @NotNull(message = "El campo 'Primer apellido titular' no puede ser nulo", groups = {TipoCliente.Autonomo.class, TipoCliente.Hogar.class})
    @Pattern(regexp = "[a-zA-Z0-9.,;ñáéíóúüÑÁÉÍÓÚÜàèìòùÀÈÌÒÙ]+", message = "El Primer apellido titular solo puede contener letras, dígitos y los caracteres .,;ñáéíóúüÑÁÉÍÓÚÜàèìòùÀÈÌÒÙ", groups = {TipoCliente.Autonomo.class, TipoCliente.Hogar.class})
    private String primerApellidoTitular;

    @Pattern(regexp = "[a-zA-Z0-9.,;ñáéíóúüÑÁÉÍÓÚÜàèìòùÀÈÌÒÙ]+", message = "El Segundo apellido solo puede contener letras, dígitos y los caracteres .,;ñáéíóúüÑÁÉÍÓÚÜàèìòùÀÈÌÒÙ", groups = {TipoCliente.Autonomo.class, TipoCliente.Hogar.class})
    private String segundoApellidoTitular;



    

	

}
