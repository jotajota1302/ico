package com.ntt.es.validation.validator;

import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ntt.es.config.Constantes;
import com.ntt.es.model.dto.DatosFinancierosEmpresaGrupoDto;
import com.ntt.es.model.dto.DatosFinancierosNoGrupoDto;
import com.ntt.es.model.dto.DatosFinancierosAutonomoDto;
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

		if (TipoClienteValidator
				.esTipoClienteValido(dto.getTipoCliente(),
						new String[] { Constantes.EMPRESA_PRIVADA, Constantes.EMPRESA_PUBLICA,
								Constantes.UNIVERSIDAD_ESPANOLA })
				&& dto.getPerteneceGrupo() && dto.getCuentasConsolidadas()) {

			isValid = ValidationUtils.isValidNifFormat(dto.getNifMatrizGrupo(),
					"El valor del NIF de la Matriz Grupo es obligatorio", "nifMatrizGrupo", context)&&isValid;
			isValid = ValidationUtils.isValidString(dto.getPaisDomicilioMatrizGrupo(),
					"El país del domicilio de la Matriz Grupo es obligatorio.", "paisDomicilioMatrizGrupo", context)&&isValid;
			isValid = ValidationUtils.isValidDigitsCommas(dto.getNumEmpleadosFechaUltimoCierre(),
					"El número de empleados a fecha de último cierre es obligatorio.", "numEmpleadosFechaUltimoCierre",
					context)&&isValid;
			isValid = ValidationUtils.isValidDigitsCommas(dto.getFondosPropiosGrupo(),
					"Los fondos propios del grupo son obligatorios.", "fondosPropiosGrupo", context)&&isValid;
			isValid = ValidationUtils.isValidDigitsCommas(dto.getFacturacionAnioAnteriorGrupo(),
					"La facturación del año anterior del grupo es obligatoria.", "facturacionAnioAnteriorGrupo",
					context)&&isValid;
			isValid = ValidationUtils.isValidDigitsCommas(dto.getCifraActivoTotalFechaUltimoCierre(),
					"La cifra de activo total a fecha de último cierre es obligatoria.",
					"cifraActivoTotalFechaUltimoCierre", context)&&isValid;
			isValid = ValidationUtils.isValidDate(dto.getFechaConstitucionEmpresaMatriz(),
					"La fecha de constitución de la empresa matriz es incorrecta.", "fechaConstitucionEmpresaMatriz",
					context)&&isValid;

		}

		else if (TipoClienteValidator.esTipoClienteValido(dto.getTipoCliente(),
				new String[] { Constantes.EMPRESA_PRIVADA, Constantes.EMPRESA_PUBLICA,
						Constantes.UNIVERSIDAD_ESPANOLA })
				&& dto.getPerteneceGrupo() && !dto.getCuentasConsolidadas()) {

			isValid = ValidationUtils.isValidNifFormat(dto.getNifMatrizGrupo(),
					"El valor del NIF de la Matriz Grupo es obligatorio", "nifMatrizGrupo", context)&&isValid;
			isValid = ValidationUtils.isValidString(dto.getPaisDomicilioMatrizGrupo(),
					"El país del domicilio de la Matriz Grupo es obligatorio.", "paisDomicilioMatrizGrupo", context)&&isValid;

			for (int i = 0; i < dto.getDatosEmpresasGrupo().size(); i++) {
				DatosFinancierosEmpresaGrupoDto empresaDto = dto.getDatosEmpresasGrupo().get(i);

				Set<ConstraintViolation<DatosFinancierosEmpresaGrupoDto>> violations = Validation.buildDefaultValidatorFactory()
						.getValidator().validate(empresaDto);

				if (!violations.isEmpty()) {
					isValid = false;
					for (ConstraintViolation<DatosFinancierosEmpresaGrupoDto> violation : violations) {
						context.disableDefaultConstraintViolation();
						context.buildConstraintViolationWithTemplate(violation.getMessage())
								.addPropertyNode(
										"datosEmpresasGrupo[" + i + "]." + violation.getPropertyPath().toString())
								.addConstraintViolation();
					}
				}
			}
		}

		else if (TipoClienteValidator.esTipoClienteValido(dto.getTipoCliente(), new String[] {
				Constantes.EMPRESA_PRIVADA, Constantes.EMPRESA_PUBLICA, Constantes.UNIVERSIDAD_ESPANOLA })
				&& !dto.getPerteneceGrupo()) {

			dto.setCuentasConsolidadas(false);
			dto.setDatosEmpresasGrupo(null);

			for (int i = 0; i < dto.getDatosEmpresasNoGrupo().size(); i++) {
				DatosFinancierosNoGrupoDto empresaDto = dto.getDatosEmpresasNoGrupo().get(i);

				Set<ConstraintViolation<DatosFinancierosNoGrupoDto>> violations = Validation.buildDefaultValidatorFactory()
						.getValidator().validate(empresaDto);

				if (!violations.isEmpty()) {
					isValid = false;
					for (ConstraintViolation<DatosFinancierosNoGrupoDto> violation : violations) {
						context.disableDefaultConstraintViolation();
						context.buildConstraintViolationWithTemplate(violation.getMessage())
								.addPropertyNode(
										"datosEmpresasNoGrupo[" + i + "]." + violation.getPropertyPath().toString())
								.addConstraintViolation();
					}
				}
			}

		}

		else if (TipoClienteValidator.esTipoClienteValido(dto.getTipoCliente(), new String[] { Constantes.AUTONOMO })
				&& !dto.getPerteneceGrupo()) {

			dto.setCuentasConsolidadas(false);
			dto.setDatosEmpresasGrupo(null);
			dto.setDatosEmpresasNoGrupo(null);

			for (int i = 0; i < dto.getDatosFinancierosAutonomo().size(); i++) {
				DatosFinancierosAutonomoDto autonomoDto = dto.getDatosFinancierosAutonomo().get(i);

				Set<ConstraintViolation<DatosFinancierosAutonomoDto>> violations = Validation
						.buildDefaultValidatorFactory().getValidator().validate(autonomoDto);

				if (!violations.isEmpty()) {
					isValid = false;
					for (ConstraintViolation<DatosFinancierosAutonomoDto> violation : violations) {
						context.disableDefaultConstraintViolation();
						context.buildConstraintViolationWithTemplate(violation.getMessage())
								.addPropertyNode(
										"datosFinancierosAutonomo[" + i + "]." + violation.getPropertyPath().toString())
								.addConstraintViolation();
					}
				}
			}

		}

		// validacion pagina web
		isValid = ValidationUtils.isValidString(dto.getPaginaWeb(),
				"La página web es obligatoria. En caso de no tener página web, utilizar 'NA'.", "paginaWeb", context)&&isValid;

		// validacion persona contacto web
		isValid = ValidationUtils.isValidStringRegex(dto.getCorreoPersonaContacto(),
				"El correo electrónico de la persona de contacto es obligatorio. En caso de no tener correo electrónico, utilizar 'NA'.",
				"correoPersonaContacto", context, "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b|NA")&&isValid;

		// validacion pagina web
		isValid = ValidationUtils.isNotNullOrEmpty(dto.getCodigoCNAECliente(), "El código CNAE cliente es obligatorio.",
				"codigoCNAECliente", context)&&isValid;

		return isValid;

	}

}
