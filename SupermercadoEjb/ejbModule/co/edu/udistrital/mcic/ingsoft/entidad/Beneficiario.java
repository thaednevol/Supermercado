package co.edu.udistrital.mcic.ingsoft.entidad;



import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table


public class Beneficiario extends Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -390599931174298793L;
	private double cupo;
	private String dia;
	private String horaInicio;
	private String horaFin;
	private String codigo;
	private Supermercado supermercado;
	
	
	
	
	public Supermercado getSupermercado() {
		return supermercado;
	}

	public void setSupermercado(Supermercado supermercado) {
		this.supermercado = supermercado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	

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

	public double getCupo() {
	return cupo;
	}

	public void setCupo(double cupo) {
	this.cupo = cupo;
	}


	


	public void generarCodigo () {
		
	}

	public void asignarHorario(Afiliado Afiliado) {
	
	}
}
