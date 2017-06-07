package co.edu.udistrital.mcic.ingsoft.negocioimpl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import co.edu.udistrital.mcic.ingsoft.entidad.AdministradorSupermercado;
import co.edu.udistrital.mcic.ingsoft.entidad.Afiliado;
import co.edu.udistrital.mcic.ingsoft.entidad.Beneficiario;
import co.edu.udistrital.mcic.ingsoft.entidad.Cajero;
import co.edu.udistrital.mcic.ingsoft.entidad.Usuario;
import co.edu.udistrital.mcic.ingsoft.negocio.IGestorUsuario;

@Stateless
public class GestorUsuario extends Gestor implements IGestorUsuario{
	
	public Usuario obtenerUsuario(String nombre, String clave) {
		try {
//			return (Usuario) entityManager.createQuery("SELECT u FROM Usuario u WHERE u.nombre=:nombre AND u.clave=:clave",Usuario.class)
//					.setParameter("nombre", nombre)
//					.setParameter("clave", clave)
					//.setParameter("dtype", Usuario.class)  //AND TYPE(u)=:dtype AND u.clave=:clave
			//		.getSingleResult();
			return (Usuario) entityManager.createNativeQuery("SELECT * FROM USUARIO WHERE nombre = ?1 AND clave = ?2",Usuario.class)
					.setParameter(1, nombre).setParameter(2, clave).getSingleResult();
		}
		catch (NoResultException nre){
			System.out.println("No se encontró usuario: "+nombre+" "+clave);
			return null;
		}
	}
	
	
	public Usuario obtenerUsuario (int id){
		return null;
	}

	
	public List<Usuario> listarUsuario(){
		return null;
	}
	
	
	public void crearUsuario (Usuario usuario){
		
	}
	
	
	public void actualizarUsuario (Usuario usuario){
		
	}
	
	public void eliminarUsuario (Usuario usuario){
		
	}
	
	
	
	public Beneficiario obtenerBeneficiario (int id){
		return null;
	}

	
	public List<Beneficiario> listarBeneficiario(){
		return null;
	}
	
	
	public void crearBeneficiario (Beneficiario Beneficiario){
		
	}
	
	
	public void actualizarBeneficiario (Beneficiario Beneficiario){
		
	}
	
	public void eliminarBeneficiario (Beneficiario Beneficiario){
		
	}

	
	
	
	public Afiliado obtenerAfiliado (int id){
		return null;
	}

	
	public List<Afiliado> listarAfiliado(){
		return null;
	}
	
	
	public void crearAfiliado (Afiliado Afiliado){
		
	}
	
	
	public void actualizarAfiliado (Afiliado Afiliado){
		
	}
	
	public void eliminarAfiliado (Afiliado Afiliado){
		
	}
	
	
	public Cajero obtenerCajero (int id){
		return null;
	}

	
	public List<Cajero> listarCajero(){
		return null;
	}
	
	
	public void crearCajero (Cajero Cajero){
		
	}
	
	
	public void actualizarCajero (Cajero Cajero){
		
	}
	
	public void eliminarCajero (Cajero Cajero){
		
	}

	
	
	public AdministradorSupermercado obtenerAdministradorSupermercado (int id){
		return null;
	}

	
	public List<AdministradorSupermercado> listarAdministradorSupermercado(){
		return null;
	}
	
	
	public void crearAdministradorSupermercado (AdministradorSupermercado AdministradorSupermercado){
		
	}
	
	
	public void actualizarAdministradorSupermercado (AdministradorSupermercado AdministradorSupermercado){
		
	}
	
	public void eliminarAdministradorSupermercado (AdministradorSupermercado AdministradorSupermercado){
		
	}
}
