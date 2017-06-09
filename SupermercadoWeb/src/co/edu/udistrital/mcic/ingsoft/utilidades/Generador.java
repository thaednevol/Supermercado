package co.edu.udistrital.mcic.ingsoft.utilidades;

import org.fluttercode.datafactory.impl.DataFactory;

import co.edu.udistrital.mcic.ingsoft.entidad.AdministradorSupermercado;
import co.edu.udistrital.mcic.ingsoft.entidad.Beneficiario;
import co.edu.udistrital.mcic.ingsoft.entidad.Supermercado;
import co.edu.udistrital.mcic.ingsoft.entidad.Usuario;
import co.edu.udistrital.mcic.ingsoft.servicios.UsuarioServicios;

public class Generador {
	
	private UsuarioServicios servicio = new UsuarioServicios();
	
	private static final int NUMERO_ADMINISTRADORES=0;
	private static final int NUMERO_BENEFICIARIOS=25;
	
	public static void main(String ... args){
		Generador generador = new Generador();
		generador.generar();
	}

	public void generar() {
		generarRoles();
		generarAdministradores();
		generarBeneficiarios();
	}

	private void generarBeneficiarios() {
		for (int i=0;i<NUMERO_BENEFICIARIOS;i++){
			Beneficiario beneficiario=(Beneficiario) generarUsuario();
			DataFactory df = new DataFactory();
			beneficiario.setCupo(df.getNumberBetween(10000, 50000));
			String [] dias = {"Lu","Ma","Mi","Ju","Vi","Sa","Do"};
			String dia = df.getItem(dias);
			beneficiario.setDia(dia);
			String [] horasI = {"08:00","09:00","10:00","11:00","12:00","13:00"};
			beneficiario.setHoraInicio(df.getItem(horasI));
			String [] horasF = {"14:00","15:00","16:00","17:00","18:00","19:00"};
			beneficiario.setHoraFin(df.getItem(horasF));
			beneficiario.setCodigo(df.getRandomChars(10));
			Supermercado s = new Supermercado();
			s.setId(1);
			beneficiario.setSupermercado(s);
			servicio.guardarBeneficiario(beneficiario);
			
		}
	}

	private void generarAdministradores() {
		for (int i=0;i<NUMERO_ADMINISTRADORES;i++){
			AdministradorSupermercado administrador = (AdministradorSupermercado) generarUsuario();
			System.out.println(administrador);
		}
		
	}

	private Usuario generarUsuario() {
		Usuario u = new Beneficiario();
		DataFactory df = new DataFactory();
		u.setNombre(df.getFirstName());
		u.setApellido(df.getLastName());
		u.setIdentificacion(df.getNumberText(10));
		u.setFechaNacimiento(new java.sql.Date(df.getBirthDate().getTime()));
		String [] generos = {"Masculino","Femenino"};
		String genero=df.getItem(generos);
		u.setGenero(genero);
		u.setCelular(df.getNumberText(10));
		u.setDireccion(df.getAddress());
		u.setCorreo(df.getEmailAddress());
		u.setClave(df.getRandomChars(10));
		return u;
	}

	private void generarRoles() {
		//Rol rol = new Rol();
		//rol.setId(1);
		//rol.setNombre("admin");
		
		
	}

	public UsuarioServicios getServicio() {
		return servicio;
	}

	public void setServicio(UsuarioServicios servicio) {
		this.servicio = servicio;
	}

}

