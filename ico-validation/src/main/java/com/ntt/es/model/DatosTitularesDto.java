package com.ntt.es.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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

//    @Pattern(regexp = "[a-zA-Z0-9]+", message = "El DNI/NIE titular real solo puede contener letras y dígitos")
    private String dniNieTitularReal;

//    @Pattern(regexp = "[a-zA-Z0-9.,;ñáéíóúüÑÁÉÍÓÚÜàèìòùÀÈÌÒÙ]+", message = "El Primer apellido titular real solo puede contener letras, dígitos y los caracteres .,;ñáéíóúüÑÁÉÍÓÚÜàèìòùÀÈÌÒÙ")
    private String primerApellidoTitularReal;
	
    //Campos Autonomo
	private String dniNieTitular;

    private String nombreTitular; 
    
    private String primerApellidoTitular;

    private String segundoApellidoTitular;

    private LocalDate fechaNacimiento;


    

	

}
