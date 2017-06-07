package co.edu.udistrital.mcic.ingsoft.negocio;

import java.util.List;

import javax.ejb.Remote;

import co.edu.udistrital.mcic.ingsoft.entidad.AdministradorSupermercado;
import co.edu.udistrital.mcic.ingsoft.entidad.Afiliado;
import co.edu.udistrital.mcic.ingsoft.entidad.Beneficiario;
import co.edu.udistrital.mcic.ingsoft.entidad.Cajero;
import co.edu.udistrital.mcic.ingsoft.entidad.Usuario;

@Remote
public interface IGestorUsuario {
	public Usuario obtenerUsuario (int id);
	public Usuario obtenerUsuario (String usuario, String clave);
	public List<Usuario> listarUsuario();
	public void crearUsuario (Usuario usuario);
	public void actualizarUsuario (Usuario usuario);
	public void eliminarUsuario (Usuario usuario);
	public Beneficiario obtenerBeneficiario (int id);
	public List<Beneficiario> listarBeneficiario();
	public void crearBeneficiario (Beneficiario Beneficiario);
	public void actualizarBeneficiario (Beneficiario Beneficiario);
	public void eliminarBeneficiario (Beneficiario Beneficiario);
	public Afiliado obtenerAfiliado (int id);
	public List<Afiliado> listarAfiliado();
	public void crearAfiliado (Afiliado Afiliado);
	public void actualizarAfiliado (Afiliado Afiliado);
	public void eliminarAfiliado (Afiliado Afiliado);
	public Cajero obtenerCajero (int id);
	public List<Cajero> listarCajero();
	public void crearCajero (Cajero Cajero);
	public void actualizarCajero (Cajero Cajero);
	public void eliminarCajero (Cajero Cajero);	
	public AdministradorSupermercado obtenerAdministradorSupermercado (int id);
	public List<AdministradorSupermercado> listarAdministradorSupermercado();
	public void crearAdministradorSupermercado (AdministradorSupermercado AdministradorSupermercado);
	public void actualizarAdministradorSupermercado (AdministradorSupermercado AdministradorSupermercado);
	public void eliminarAdministradorSupermercado (AdministradorSupermercado AdministradorSupermercado);
}
