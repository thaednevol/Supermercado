package co.edu.udistrital.mcic.ingsoft.entidad;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table


public class AdministradorSupermercado extends Usuario {

	private String dia;
	private String horaInicio;
	private String horaFin;
	private String correoEmpresarial;
	
	
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	
	
	
public String getCorreoEmpresarial() {
		return correoEmpresarial;
	}
	public void setCorreoEmpresarial(String correoEmpresarial) {
		this.correoEmpresarial = correoEmpresarial;
	}
public void autorizarSobrecupo (Afiliado afiliado) {
		
	}
	
}
