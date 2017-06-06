package co.edu.udistrital.mcic.ingsoft;


import javax.persistence.*;

@Entity
@Table
public class Beneficiario extends Usuario {
	
	private int cupo;

	public int getCupo() {
	return cupo;
	}

	public void setCupo(int cupo) {
	this.cupo = cupo;
	}



}
