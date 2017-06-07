package co.edu.udistrital.mcic.ingsoft.entidad;




import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table

public class Afiliado extends Usuario{
	
	private int cupo;
private List<Beneficiario> beneficiarios ;
public int getCupo() {
	return cupo;
}
public void setCupo(int cupo) {
	this.cupo = cupo;
}
public List<Beneficiario> getBeneficiarios() {
	return beneficiarios;
}
public void setBeneficiarios(List<Beneficiario> beneficiarios) {
	this.beneficiarios = beneficiarios;
}

	

public void afiliarBeneficiario(Afiliado Afiliado) {
	
}


public void borrarBeneficiario(Afiliado Afiliado) {
	
}


public void calcularPorcentajeCredito() {
	
}


public boolean validarCantidadAfiliados() {
	return false;
}


public boolean validarCantidadBeneficiarios() {
	return false;
}


}

