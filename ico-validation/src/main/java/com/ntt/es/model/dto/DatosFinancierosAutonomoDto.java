package com.ntt.es.model.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class DatosFinancierosAutonomoDto {
	
	@Size(min = 9, max = 9, message = "El DNI/NIE debe contener exactamente 9 caracteres alfanuméricos.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "El DNI/NIE debe contener solo letras y dígitos.")
    private String dniNie;

    @Positive(message = "El número de empleados debe ser 1 o superior.")
    private int numEmpleados;

    @Pattern(regexp = "^[0-9,]+$", message = "La facturación debe contener solo dígitos y comas.")
    private String facturacionAnioAnterior;

    @NotNull
    private Date fechaAltaIAE;

}
