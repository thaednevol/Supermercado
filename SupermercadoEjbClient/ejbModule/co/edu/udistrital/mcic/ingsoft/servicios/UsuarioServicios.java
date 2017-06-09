package co.edu.udistrital.mcic.ingsoft.servicios;

import java.util.List;

import co.edu.udistrital.mcic.ingsoft.entidad.Beneficiario;
import co.edu.udistrital.mcic.ingsoft.entidad.Usuario;
import co.edu.udistrital.mcic.ingsoft.negocio.IGestorUsuario;
import co.edu.udistrital.mcic.ingsoft.negocioimpl.GestorUsuario;

public class UsuarioServicios {

	public Usuario find(String nombreUsuario, String clave) {
		IGestorUsuario gestor = new GestorUsuario();
		return gestor.obtenerUsuario(nombreUsuario, clave);
	}

	public List<Beneficiario> findAll() {
		IGestorUsuario gestor = new GestorUsuario();
		return gestor.listarBeneficiario();
	}

	public void guardarBeneficiario(Beneficiario b) {
		System.out.println("GUARDO->"+b.getNombre());
		IGestorUsuario gestor = new GestorUsuario();
		gestor.crearBeneficiario(b);
		
	}

	public Beneficiario consultarBeneficiario(String identificacion) {
		IGestorUsuario gestor = new GestorUsuario();
		return gestor.obtenerBeneficiario(Integer.parseInt(identificacion));
	}

	public void modificarBeneficiario(Beneficiario modificadoBeneficiario) {
		IGestorUsuario gestor = new GestorUsuario();
		gestor.actualizarBeneficiario(modificadoBeneficiario);
		
	}
}
