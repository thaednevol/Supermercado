package co.edu.udistrital.mcic.ingsoft.servicios;

import java.util.List;

import co.edu.udistrital.mcic.ingsoft.entidad.Compra;
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
	
}
