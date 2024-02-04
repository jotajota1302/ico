package com.ntt.es.xmlbean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class TitularReal {

    @XmlElement(name = "dni-titular-real")
    private String dniTitularReal;

    
    @XmlElement(name = "primer-apellido-titular-real")
    private String primerApellidoTitularReal;
    
    public String getDniTitularReal() {
		return dniTitularReal;
	}
    
    public void setDniTitularReal(String dniTitularReal) {
		this.dniTitularReal = dniTitularReal;
	}
    
    public String getPrimerApellidoTitularReal() {
		return primerApellidoTitularReal;
	}
    
    public void setPrimerApellidoTitularReal(String primerApellidoTitularReal) {
		this.primerApellidoTitularReal = primerApellidoTitularReal;
	}

	@Override
	public String toString() {
		return "\n\t\t\t\t\tTitularReal [dniTitularReal=" + dniTitularReal + ", primerApellidoTitularReal="
				+ primerApellidoTitularReal + "]";
	}
	
}
