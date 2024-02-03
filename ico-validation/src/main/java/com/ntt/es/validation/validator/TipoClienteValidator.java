package com.ntt.es.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ntt.es.model.DatosTitularesDto;
import com.ntt.es.validation.annotations.ValidarTipoCliente;

public class TipoClienteValidator implements ConstraintValidator<ValidarTipoCliente, DatosTitularesDto> {

	@Override
	public void initialize(ValidarTipoCliente constraintAnnotation) {
	}
	
	@Override
	public boolean isValid(DatosTitularesDto dto, ConstraintValidatorContext context) {

		// Verificar el tipo de línea seleccionada
		String lineaSeleccionada = dto.getLinea();

		// Validar el tipo de cliente según la línea seleccionada
		if ("ICO MRR Verde".equals(lineaSeleccionada)
				|| "ICO MRR Verde – PERTE Energía Renovable, Hidrógeno y Almacenamiento".equals(lineaSeleccionada)) {
			return esTipoClienteValido(dto.getTipoCliente(),
					new String[] { "Empresa privada", "Autónomo", "Hogar" });
		} else if ("ICO MRR Empresas y Emprendedores".equals(lineaSeleccionada)
				|| "ICO MRR Empresas y Emprendedores – Sector turístico".equals(lineaSeleccionada)) {
			return esTipoClienteValido(dto.getTipoCliente(), new String[] { "Empresa privada", "Autónomo" });
		} else if ("ICO MRR Empresas y Emprendedores – PERTE Nueva Economía de la Lengua".equals(lineaSeleccionada)) {
			return esTipoClienteValido(dto.getTipoCliente(), new String[] { "Universidad española" });
		} else if ("ICO MRR Audiovisual".equals(lineaSeleccionada)
				|| "ICO MRR Audiovisual – PERTE Nueva Economía de la Lengua".equals(lineaSeleccionada)) {
			return esTipoClienteValido(dto.getTipoCliente(),
					new String[] { "Empresa privada", "Empresa pública", "Autónomo" });
		} else if ("ICO MRR Promoción de vivienda social".equals(lineaSeleccionada)) {
			return esTipoClienteValido(dto.getTipoCliente(),
					new String[] { "Empresa privada", "Empresa pública" });
		}

		// En caso de no cumplir con ninguna condición específica, se considera válido
		return true;
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
