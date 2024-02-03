package com.ntt.es.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.ntt.es.model.DatosTitularesDto;
import com.ntt.es.validation.annotations.ValidarTipoCliente;

public class TipoClienteValidator implements ConstraintValidator<ValidarTipoCliente, DatosTitularesDto> {

	private static final String EMPRESA_PUBLICA = "Empresa pública";
	private static final String UNIVERSIDAD_ESPANOLA = "Universidad española";
	private static final String HOGAR = "Hogar";
	private static final String AUTONOMO = "Autónomo";
	private static final String EMPRESA_PRIVADA = "Empresa privada";

	@Autowired
	EmpresaPrivadaValidator empresaPrivadaValidator;
	
	@Autowired
	EmpresaPublicaValidator empresaPublicaValidator;
	
	@Override
	public boolean isValid(DatosTitularesDto dto, ConstraintValidatorContext context) {

		boolean isValid=true;
		
		// Verificar el tipo de línea seleccionada
		isValid=validaLineaTipoCliente(dto, dto.getLinea());

		if(!isValid) {
			context.disableDefaultConstraintViolation();
			 context.buildConstraintViolationWithTemplate("La linea no coincide con el tipo de cliente.")
             .addPropertyNode("razonSocialTitular")
             .addConstraintViolation();
		}	       
		
		if (EMPRESA_PRIVADA.equals( dto.getTipoCliente())) {			
	            if (!empresaPrivadaValidator.isValid(dto, context)) {
	                isValid=false;
	            }
		}		
		if (EMPRESA_PUBLICA.equals( dto.getTipoCliente())) {		
	            if (!empresaPublicaValidator.isValid(dto, context)) {
	            	isValid=false;
	            }
		}
		
		return isValid;
	}

	private boolean validaLineaTipoCliente(DatosTitularesDto dto, String lineaSeleccionada) {

		// Validar el tipo de cliente según la línea seleccionada
		
		if ("ICO MRR Verde".equals(lineaSeleccionada)
				|| "ICO MRR Verde – PERTE Energía Renovable, Hidrógeno y Almacenamiento".equals(lineaSeleccionada)) {
			return esTipoClienteValido(dto.getTipoCliente(), new String[] { EMPRESA_PRIVADA, AUTONOMO, HOGAR });
		} else if ("ICO MRR Empresas y Emprendedores".equals(lineaSeleccionada)
				|| "ICO MRR Empresas y Emprendedores – Sector turístico".equals(lineaSeleccionada)) {
			return esTipoClienteValido(dto.getTipoCliente(), new String[] { EMPRESA_PRIVADA, AUTONOMO });
		} else if ("ICO MRR Empresas y Emprendedores – PERTE Nueva Economía de la Lengua".equals(lineaSeleccionada)) {
			return esTipoClienteValido(dto.getTipoCliente(), new String[] { UNIVERSIDAD_ESPANOLA });
		} else if ("ICO MRR Audiovisual".equals(lineaSeleccionada)
				|| "ICO MRR Audiovisual – PERTE Nueva Economía de la Lengua".equals(lineaSeleccionada)) {
			return esTipoClienteValido(dto.getTipoCliente(),
					new String[] { EMPRESA_PRIVADA, EMPRESA_PUBLICA, AUTONOMO });
		} else if ("ICO MRR Promoción de vivienda social".equals(lineaSeleccionada)) {
			return esTipoClienteValido(dto.getTipoCliente(), new String[] { EMPRESA_PRIVADA, EMPRESA_PUBLICA });
		}

		return false;
	}

	private boolean esTipoClienteValido(String tipoCliente, String[] tiposValidos) {
		for (String tipoValido : tiposValidos) {
			if (tipoValido.equals(tipoCliente)) {
				return true;
			}
		}
				
		return false;
	}

}
