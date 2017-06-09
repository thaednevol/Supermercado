package co.edu.udistrital.mcic.ingsoft.negocioimpl;

import java.util.List;
import co.edu.udistrital.mcic.ingsoft.entidad.Compra;
import co.edu.udistrital.mcic.ingsoft.entidad.Permiso;
import co.edu.udistrital.mcic.ingsoft.entidad.Rol;
import co.edu.udistrital.mcic.ingsoft.entidad.Supermercado;
import co.edu.udistrital.mcic.ingsoft.negocio.IGestorMaestro;

public class GestorMaestro extends Gestor implements IGestorMaestro{

	@Override
	public Rol obtenerRol(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rol> listarRol() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crearRol(Rol Rol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarRol(Rol Rol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarRol(Rol Rol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Permiso obtenerPermiso(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Permiso> listarPermiso() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crearPermiso(Permiso permiso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarPermiso(Permiso permiso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarPermiso(Permiso permiso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Supermercado obtenerSupermercado(int id) {
		Supermercado s=entityManager.find(Supermercado.class, id);
		System.out.println("SUPERMERCADO->"+id+":"+s.getNombre());
		return s;
	}

	@Override
	public List<Supermercado> listarSupermercado() {
		try{
			return entityManager.createQuery("SELECT s FROM Supermercado s",Supermercado.class).getResultList();
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void crearSupermercado(Supermercado Supermercado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarSupermercado(Supermercado Supermercado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarSupermercado(Supermercado Supermercado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Compra obtenerCompra(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compra> listarCompra() {
		try{
			return entityManager.createQuery("SELECT c FROM Compra c",Compra.class).getResultList();
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void crearCompra(Compra compra) {
		entityManager.getTransaction().begin();
		entityManager.persist(compra);
		entityManager.getTransaction().commit();
	}

	@Override
	public boolean actualizarCompra(Compra compra) {
		try {
			Compra c=entityManager.find(Compra.class, compra.getId());
			entityManager.getTransaction().begin();
			c.setBeneficiario(compra.getBeneficiario());
			c.setFecha(compra.getFecha());
			c.setHora(compra.getHora());
			c.setProductos(compra.getProductos());
			c.setTotal(compra.getTotal());
			entityManager.getTransaction().commit();
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
		
		
		
	}

	@Override
	public void eliminarCompra(Compra Compra) {
		// TODO Auto-generated method stub
		
	}
	
}
