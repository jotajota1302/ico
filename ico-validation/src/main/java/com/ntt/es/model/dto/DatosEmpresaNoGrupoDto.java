package com.ntt.es.model.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class DatosEmpresaNoGrupoDto {
	
	 @NotBlank(message = "El NIF de la empresa del grupo es obligatorio.")
	    @Size(min = 9, max = 9, message = "El NIF debe contener exactamente 9 caracteres alfanuméricos.")
	    @Pattern(regexp = "[A-Za-z0-9]+", message = "El NIF debe contener solo letras y dígitos.")
	    private String nifEmpresa;

	    @NotNull(message = "El número de empleados de la empresa del grupo a fecha del último cierre es obligatorio.")
	    @Pattern(regexp = "[0-9,]+", message = "El número de empleados debe contener solo dígitos y comas.")
	    private String numEmpleadosEmpresa;

	    @NotNull(message = "Los fondos propios de la empresa del grupo a fecha del último cierre son obligatorios.")
	    @Pattern(regexp = "[0-9,]+", message = "Los fondos propios deben contener solo dígitos y comas.")
	    private String fondosPropiosEmpresa;

	    @NotNull(message = "La facturación del año anterior de la empresa del grupo es obligatoria.")
	    @Pattern(regexp = "[0-9,]+", message = "La facturación debe contener solo dígitos y comas.")
	    private String facturacionAnioAnteriorEmpresa;

	    @NotNull(message = "La cifra de activo total de la empresa del grupo a fecha del último cierre es obligatoria.")
	    @Pattern(regexp = "[0-9,]+", message = "La cifra de activo total debe contener solo dígitos y comas.")
	    private String cifraActivoTotalEmpresa;

	    @NotNull(message = "La fecha de constitución de la empresa del grupo es obligatoria.")
	    private Date fechaConstitucionEmpresa;

}
