package com.ntt.es.model.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
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
   
    private List<DatosFinancierosEmpresaGrupoDto> datosEmpresasGrupo;
    
    private List<DatosFinancierosNoGrupoDto> datosEmpresasNoGrupo;
    
    private List<DatosFinancierosAutonomoDto> datosFinancierosAutonomo;    

    @NotBlank(message = "La página web es obligatoria. En caso de no tener página web, utilizar 'NA'.")
    private String paginaWeb;

    @NotBlank(message = "El correo electrónico de la persona de contacto es obligatorio. En caso de no tener correo electrónico, utilizar 'NA'.")
    @Pattern(regexp = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b|NA", message = "Ingrese una dirección de correo electrónico válida o utilice 'NA'.")
    private String correoPersonaContacto;

    @NotBlank(message = "El código CNAE cliente es obligatorio.")
    private String codigoCNAECliente;
    
}
