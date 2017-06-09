package co.edu.udistrital.mcic.ingsoft.negocio;

import java.util.List;

import javax.ejb.Remote;

import co.edu.udistrital.mcic.ingsoft.entidad.Compra;
import co.edu.udistrital.mcic.ingsoft.entidad.Permiso;
import co.edu.udistrital.mcic.ingsoft.entidad.Rol;
import co.edu.udistrital.mcic.ingsoft.entidad.Supermercado;

@Remote
public interface IGestorMaestro {
	public Rol obtenerRol (int id);
	public List<Rol> listarRol();
	public void crearRol (Rol Rol);	
	public void actualizarRol (Rol Rol);
	public void eliminarRol (Rol Rol);
	public Permiso obtenerPermiso (int id);
	public List<Permiso> listarPermiso();
	public void crearPermiso (Permiso permiso);
	public void actualizarPermiso (Permiso permiso);
	public void eliminarPermiso (Permiso permiso);
	public Supermercado obtenerSupermercado (int id);
	public List<Supermercado> listarSupermercado();
	public void crearSupermercado (Supermercado Supermercado);
	public void actualizarSupermercado (Supermercado Supermercado);
	public void eliminarSupermercado (Supermercado Supermercado);
	public Compra obtenerCompra (int id);	
	public List<Compra> listarCompra();
	public void crearCompra (Compra Compra);
	public boolean actualizarCompra (Compra Compra);
	public void eliminarCompra (Compra Compra);
}
