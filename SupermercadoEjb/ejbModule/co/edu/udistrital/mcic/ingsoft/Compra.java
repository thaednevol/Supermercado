package co.edu.udistrital.mcic.ingsoft;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity@Table
public class Compra {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date fecha;
	private Date hora;
	private Beneficiario beneficiario;
	private List<Producto> productos=new ArrayList<Producto>();
	public void registrarCompra (){
		//Realizar persistencia a la BD (fecha, hora, beneficiario, supermercado, productos)
	}
	
	public void agregarProducto (Producto producto){
		productos.add(producto);
	}

}
