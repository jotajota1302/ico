package com.ntt.es.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ntt.es.model.dto.DatosFinancierosDto;
import com.ntt.es.validation.annotations.ValidarDatosFinancieros;
import com.ntt.es.validation.utils.ValidationUtils;

public class DatosFinancierosValidator implements ConstraintValidator<ValidarDatosFinancieros, DatosFinancierosDto> {

	private static Logger log = LoggerFactory.getLogger(DatosFinancierosValidator.class);

	@Override
	public void initialize(ValidarDatosFinancieros constraintAnnotation) {
	}

	@Override
	public boolean isValid(DatosFinancierosDto dto, ConstraintValidatorContext context) {

		log.debug("validando datos financieros");

		boolean isValid = true;

		if (dto.getPerteneceGrupo() && dto.getCuentasConsolidadas()) {

			isValid = ValidationUtils.isValidNifFormat(dto.getNifMatrizGrupo(),
					"El valor del NIF de la Matriz Grupo es obligatorio", "nifMatrizGrupo", context);
			isValid = ValidationUtils.isValidString(dto.getPaisDomicilioMatrizGrupo(),
					"El país del domicilio de la Matriz Grupo es obligatorio.", "paisDomicilioMatrizGrupo", context);
			isValid = ValidationUtils.isValidDigitsCommas(dto.getNumEmpleadosFechaUltimoCierre(),
					"El número de empleados a fecha de último cierre es obligatorio.", "numEmpleadosFechaUltimoCierre",
					context);
			isValid = ValidationUtils.isValidDigitsCommas(dto.getFondosPropiosGrupo(),
					"Los fondos propios del grupo son obligatorios.", "fondosPropiosGrupo", context);
			isValid = ValidationUtils.isValidDigitsCommas(dto.getFacturacionAnioAnteriorGrupo(),
					"La facturación del año anterior del grupo es obligatoria.", "facturacionAnioAnteriorGrupo",
					context);
			isValid = ValidationUtils.isValidDigitsCommas(dto.getCifraActivoTotalFechaUltimoCierre(),
					"La cifra de activo total a fecha de último cierre es obligatoria.",
					"cifraActivoTotalFechaUltimoCierre", context);
			isValid = ValidationUtils.isValidDate(dto.getFechaConstitucionEmpresaMatriz(),
					"La fecha de constitución de la empresa matriz es incorrecta.", "fechaConstitucionEmpresaMatriz",
					context);

		}

		return isValid;

	}

}
