package com.ntt.es.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.ntt.es.config.Constantes;
import com.ntt.es.model.dto.DatosTitularesDto;
import com.ntt.es.validation.annotations.ValidarTipoCliente;

public class TipoClienteValidator implements ConstraintValidator<ValidarTipoCliente, DatosTitularesDto> {

	
	@Autowired
	EmpresaPrivadaValidator empresaPrivadaValidator;

	@Autowired
	EmpresaPublicaValidator empresaPublicaValidator;
	
	@Autowired
	UniversidadValidator universidadValidator;
	
	@Autowired
	PersonaValidator autonomoValidator;
	
	@Autowired
	HogarValidator hogarValidator;

	@Override
	public boolean isValid(DatosTitularesDto dto, ConstraintValidatorContext context) {

		boolean isValid = true;

		// Verificar el tipo de línea seleccionada
		isValid = validaLineaTipoCliente(dto, dto.getLinea());

		if (!isValid) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("La linea no coincide con el tipo de cliente.")
					.addPropertyNode("razonSocialTitular").addConstraintViolation();
		}

		if (Constantes.EMPRESA_PRIVADA.equals(dto.getTipoCliente())) {
			if (!empresaPrivadaValidator.isValid(dto, context)) {
				isValid = false;
			}
		}
		if (Constantes.UNIVERSIDAD_ESPANOLA.equals(dto.getTipoCliente())) {
			if (!universidadValidator.isValid(dto, context)) {
				isValid = false;
			}
		}
		if (Constantes.AUTONOMO.equals(dto.getTipoCliente())) {
			if (!autonomoValidator.isValid(dto, context)) {
				isValid = false;
			}
		}
		if (Constantes.HOGAR.equals(dto.getTipoCliente())) {
			if (!hogarValidator.isValid(dto, context)) {
				isValid = false;
			}
		}

		return isValid;
	}

	private boolean validaLineaTipoCliente(DatosTitularesDto dto, String lineaSeleccionada) {

		if (Constantes.LINEA_ICO_MRR_VERDE.equals(lineaSeleccionada)
				|| Constantes.LINEA_ICO_MRR_VERDE_PERTE_ERHA.equals(lineaSeleccionada)) {
			return esTipoClienteValido(dto.getTipoCliente(), new String[] { Constantes.EMPRESA_PRIVADA, Constantes.AUTONOMO, Constantes.HOGAR });
		} else if (Constantes.LINEA_ICO_MRR_EMPRESAS_Y_EMPRENDEDORES.equals(lineaSeleccionada)
				|| Constantes.LINEA_ICO_MRR_EMPRESAS_Y_EMPRENDEDORES_SECTOR_TURISTICO.equals(lineaSeleccionada)) {
			return esTipoClienteValido(dto.getTipoCliente(), new String[] { Constantes.EMPRESA_PRIVADA, Constantes.AUTONOMO });
		} else if (Constantes.LINEA_ICO_MRR_EMPRESAS_Y_EMPRENDEDORES_PERTE_NEL.equals(lineaSeleccionada)) {
			return esTipoClienteValido(dto.getTipoCliente(), new String[] { Constantes.UNIVERSIDAD_ESPANOLA });
		} else if (Constantes.LINEA_ICO_MRR_AUDIOVISUAL.equals(lineaSeleccionada)
				|| Constantes.LINEA_ICO_MRR_AUDIOVISUAL_PERTE_NEL.equals(lineaSeleccionada)) {
			return esTipoClienteValido(dto.getTipoCliente(),
					new String[] { Constantes.EMPRESA_PRIVADA, Constantes.EMPRESA_PUBLICA, Constantes.AUTONOMO });
		} else if (Constantes.LINEA_ICO_MRR_PROMOCION_DE_VIVIENDA_SOCIAL.equals(lineaSeleccionada)) {
			return esTipoClienteValido(dto.getTipoCliente(), new String[] { Constantes.EMPRESA_PRIVADA, Constantes.EMPRESA_PUBLICA });
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
