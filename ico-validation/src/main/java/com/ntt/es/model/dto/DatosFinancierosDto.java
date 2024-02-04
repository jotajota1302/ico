package com.ntt.es.model.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.ntt.es.validation.annotations.ValidarDatosFinancieros;

import lombok.Data;



@Data
@ValidarDatosFinancieros
public class DatosFinancierosDto {
	
	@NotEmpty
	private String tipoCliente;
	
	private Boolean perteneceGrupo;
	
	private Boolean cuentasConsolidadas;			
	
    @Size(min = 9, max = 9, message = "El NIF de la empresa matriz debe contener exactamente 9 caracteres alfanuméricos.")
    @Pattern(regexp = "[A-Za-z0-9]+", message = "El NIF de la empresa matriz debe contener solo letras y dígitos.")
    private String nifMatrizGrupo;
   
    private String paisDomicilioMatrizGrupo;

    private String numEmpleadosFechaUltimoCierre;

    private String fondosPropiosGrupo;

    private String facturacionAnioAnteriorGrupo;
    
    private String cifraActivoTotalFechaUltimoCierre;

    private String fechaConstitucionEmpresaMatriz;	
   
    private List<DatosEmpresaGrupoDto> datosEmpresasGrupo;
    
    private List<DatosEmpresaNoGrupoDto> datosEmpresasNoGrupo;
    
    private List<DatosFinancierosAutonomoDto> datosFinancierosAutonomo;
    
}
