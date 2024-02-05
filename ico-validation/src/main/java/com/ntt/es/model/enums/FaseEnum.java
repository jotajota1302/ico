package com.ntt.es.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FaseEnum {

	FASE_1	("1", "F_CODE_1", "Fase 1", "Comentario Fase 1"),
	FASE_2 	("2", "F_CODE_2", "Fase 2", "Comentario Fase 2");

	private final String code;
	private final String key;
	private final String name;
	private final String description;
	
	public static FaseEnum getByCode(String code) {
        for (FaseEnum fase : values()) {
            if (fase.getCode().equals(code)) {
                return fase;
            }
        }
        throw new IllegalArgumentException("Fase no encontrada para el código: " + code);
    }
	
	public static FaseEnum getByClave(String clave) {
        for (FaseEnum fase : values()) {
            if (fase.getKey().equals(clave)) {
                return fase;
            }
        }
        throw new IllegalArgumentException("Fase no encontrada para la clave: " + clave);
    }
	
	
}
