package co.edu.udistrital.mcic.ingsoft.entidad;

import javax.persistence.Column;

public class Cajero extends Usuario {
	/**
	 * 
	 */
	@Column(name = "CAJERO")
	private static final long serialVersionUID = -4033703192476972801L;
	private String dia;
	private String horaInicio;
	private String horaFin;
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
	
	
	
	
	
}
