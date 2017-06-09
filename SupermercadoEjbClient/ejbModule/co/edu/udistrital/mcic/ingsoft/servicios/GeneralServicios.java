package co.edu.udistrital.mcic.ingsoft.servicios;

import java.util.ArrayList;
import java.util.List;

import co.edu.udistrital.mcic.ingsoft.entidad.Compra;
import co.edu.udistrital.mcic.ingsoft.entidad.Producto;
import co.edu.udistrital.mcic.ingsoft.entidad.Supermercado;
import co.edu.udistrital.mcic.ingsoft.negocio.IGestorMaestro;
import co.edu.udistrital.mcic.ingsoft.negocioimpl.GestorMaestro;

public class GeneralServicios {

	public List<Supermercado> consultarSupermercados(){
		IGestorMaestro gestor = new GestorMaestro();	
		return gestor.listarSupermercado();
	}

	public Supermercado consultarSupermercado(int id) {
		IGestorMaestro gestor = new GestorMaestro();	
		return gestor.obtenerSupermercado(id);		
	}

	public List<Compra> consultarCompras() {
		IGestorMaestro gestor = new GestorMaestro();
		return gestor.listarCompra();
	}

	public void registrarCompra(Compra c) {
		IGestorMaestro gestor = new GestorMaestro();
		gestor.crearCompra(c);
	}
	
	public List<Producto> consultarProductos(){
		List<Producto> productos=new ArrayList<Producto>();
		productos.add(new Producto(1, "Atun", "Atun en lata", 4800));
		productos.add(new Producto(2, "Sardinas", "Sardinas en lata", 6100));
		productos.add(new Producto(3, "Pasta", "Pasta La Suprema", 2900));
		productos.add(new Producto(4, "Sopas instantaneas", "Sopa de la abuela", 3250));
		productos.add(new Producto(5, "Papel higienico", "Papel comun", 18400));
		return productos;
	}

	public boolean actualizarCompra(Compra compra) {
		IGestorMaestro gestor = new GestorMaestro();
		return gestor.actualizarCompra(compra);
	}
	
}
