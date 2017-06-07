package co.edu.udistrital.mcic.ingsoft.entidad;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.eclipse.persistence.annotations.ClassExtractor;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
@ClassExtractor(UsuarioExtractor.class)
//@DiscriminatorColumn(name="ROL", discriminatorType=DiscriminatorType.INTEGER, length=5) 
//@DiscriminatorFormula("case when age is null then 0 else age end")
public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 413850548545052814L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
//	@Column(insertable = false, updatable = false) 
//	private String dtype;
	//@Column(name = "DTYPE",insertable=false,updatable=false)
	//private String dtype;
	private String nombre;
	private String apellido;
	private String identificacion;
	private Date fechaNacimiento;
	private String genero;
	private String celular;
	private String direccion;
	private String correo;
	private String clave;
	private Rol rol;

	public Usuario(){}
	
	public int getId() {
		return id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public boolean validarUsuario() {
		return false;
	}

	public List<Rol> listarRol() {

		return new ArrayList<Rol>();

	}

	public Usuario buscarUsuario(String identificacion) {
		return null;//new Usuario();
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
//	public String getDtype() {
//		return dtype;
//	}
//
//	public void setDtype(String dtype) {
//		this.dtype = dtype;
//	}



}
