package com.ntt.es.validation.groups;

import javax.validation.GroupSequence;

public interface TipoCliente {
	
    interface EmpresaPrivada {}
    interface EmpresaPublica {}
    interface Autonomo {}
    interface Hogar {}
    interface UniversidadEspanola {}
    
   
    @GroupSequence({EmpresaPrivada.class, EmpresaPublica.class, Autonomo.class, Hogar.class, UniversidadEspanola.class})
    interface All {}
}
