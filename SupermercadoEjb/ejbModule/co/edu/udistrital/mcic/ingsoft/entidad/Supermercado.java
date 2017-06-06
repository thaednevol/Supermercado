package co.edu.udistrital.mcic.ingsoft;

import javax.persistence.*;

@Entity@Table
public class Supermercado {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private String direccion;
	private String telefono;
	private String ciudad;
}
