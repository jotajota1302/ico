package com.ntt.es.model.dto;

import com.ntt.es.validation.annotations.ValidarDatosFinancieros;

import lombok.Data;



@Data
@ValidarDatosFinancieros
public class DatosFinancierosDto {
	
	private Boolean perteneceGrupo;
	
	private Boolean cuentasConsolidadas;		
	
    private String nifMatrizGrupo;
   
    private String paisDomicilioMatrizGrupo;

    private String numEmpleadosFechaUltimoCierre;

    private String fondosPropiosGrupo;

    private String facturacionAnioAnteriorGrupo;
    
    private String cifraActivoTotalFechaUltimoCierre;

    private String fechaConstitucionEmpresaMatriz;
	

}
