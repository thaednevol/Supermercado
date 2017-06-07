package co.edu.udistrital.mcic.ingsoft.servicios;

import co.edu.udistrital.mcic.ingsoft.entidad.Usuario;
import co.edu.udistrital.mcic.ingsoft.negocio.IGestorUsuario;
import co.edu.udistrital.mcic.ingsoft.negocioimpl.GestorUsuario;

public class UsuarioServicios {

	public Usuario find(String nombreUsuario, String clave) {
		IGestorUsuario gestor = new GestorUsuario();
		return gestor.obtenerUsuario(nombreUsuario, clave);
	}

}
