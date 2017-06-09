package co.edu.udistrital.mcic.ingsoft.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import co.edu.udistrital.mcic.ingsoft.entidad.Beneficiario;
import co.edu.udistrital.mcic.ingsoft.entidad.Supermercado;
import co.edu.udistrital.mcic.ingsoft.servicios.GeneralServicios;
import co.edu.udistrital.mcic.ingsoft.servicios.UsuarioServicios;

@ManagedBean(name="beneficiarioController")
@ViewScoped
public class BeneficiarioController implements Serializable{
	private static final long serialVersionUID = -3895020601436413454L;
	private UsuarioServicios servicio = new UsuarioServicios();
	private GeneralServicios gservicio = new GeneralServicios();
	private List<Beneficiario> beneficiarios = new ArrayList<Beneficiario>();
	private List<Beneficiario> filtered;
	private Beneficiario nuevoBeneficiario = new Beneficiario();
	private Beneficiario modificadoBeneficiario= new Beneficiario();
	private Beneficiario eliminadoBeneficiario = new Beneficiario();
	
	private Date fechaTemp=new Date();
	private Map<String,String> supermercados = new HashMap<String, String>();
	
	private String supermercadoTemp=new String();
	
	
	
	public void consultar(ActionEvent actionEvent){
		this.beneficiarios=servicio.findAll();
	}
	
//	Iniciar app
//	Iniciar sesion
//	xCerrar sesion
//	Gestionar cliente b
//	Listar cliente b
//	Crear cliente b
//	Editar c b
//	
//	xBorrar c b
//	xAfiliar
//	xRegistrar compras
//	xAgregar producto
//	xRestar producto
//	xTotalizar compra
//	
	
	public String guardar(){
		if(servicio.consultarBeneficiario(nuevoBeneficiario.getIdentificacion())==null){
			nuevoBeneficiario.setFechaNacimiento(new java.sql.Date(fechaTemp.getTime()));
			nuevoBeneficiario.setSupermercado(gservicio.consultarSupermercado(Integer.parseInt(supermercadoTemp)));
			servicio.guardarBeneficiario(nuevoBeneficiario);
			FacesMessage fM = new FacesMessage("");
			FacesContext.getCurrentInstance().addMessage( null,fM);
		}
		else {
			FacesMessage fM = new FacesMessage("Error al consultar");
			FacesContext.getCurrentInstance().addMessage( null,fM);
		}
		return "";
	}
	
	
	public String actualizar(){
		if(servicio.consultarBeneficiario(modificadoBeneficiario.getIdentificacion())!=null){	
			modificadoBeneficiario.setFechaNacimiento(new java.sql.Date(fechaTemp.getTime()));
			servicio.modificarBeneficiario(modificadoBeneficiario);
		}
		else {
			FacesContext.getCurrentInstance().addMessage( null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Nombre de usuario o clave incorrecta",
							"Verifique nombre de usuario y clave"));
		}
		return "";
	}
	
	public UsuarioServicios getServicio() {
		return servicio;
	}

	
	public void setServicio(UsuarioServicios servicio) {
		this.servicio = servicio;
	}

	public List<Beneficiario> getBeneficiarios() {
		return beneficiarios;
	}

	public void setBeneficiarios(List<Beneficiario> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}

	public List<Beneficiario> getFiltered() {
		return filtered;
	}

	public void setFiltered(List<Beneficiario> filtered) {
		this.filtered = filtered;
	}

	public Beneficiario getNuevoBeneficiario() {
		return nuevoBeneficiario;
	}

	public void setNuevoBeneficiario(Beneficiario nuevoBeneficiario) {
		this.nuevoBeneficiario = nuevoBeneficiario;
	}

	public Date getFechaTemp() {
		return fechaTemp;
	}

	public void setFechaTemp(Date fechaTemp) {
		this.fechaTemp = fechaTemp;
	}

	public Beneficiario getModificadoBeneficiario() {
		return modificadoBeneficiario;
	}

	public void setModificadoBeneficiario(Beneficiario modificadoBeneficiario) {
		this.modificadoBeneficiario = modificadoBeneficiario;
	}

	public Beneficiario getEliminadoBeneficiario() {
		return eliminadoBeneficiario;
	}

	public void setEliminadoBeneficiario(Beneficiario eliminadoBeneficiario) {
		this.eliminadoBeneficiario = eliminadoBeneficiario;
	}
	
	public String show() {
		System.out.println("ES LLAMADO");
		//System.out.println(modificadoBeneficiario.getNombre());
		return "";
	}

	public GeneralServicios getGservicio() {
		return gservicio;
	}

	public void setGservicio(GeneralServicios gservicio) {
		this.gservicio = gservicio;
	}

	
	
	public String getSupermercadoTemp() {
		return supermercadoTemp;
	}


	public void setSupermercadoTemp(String supermercadoTemp) {
		this.supermercadoTemp = supermercadoTemp;
	}


	public Map<String, String> getSupermercados() {
		return supermercados;
	}


	public void setSupermercados(Map<String, String> supermercados) {
		this.supermercados = supermercados;
	}


	@PostConstruct
	public void init(){
		this.setBeneficiarios(servicio.findAll());
		List<Supermercado> a = gservicio.consultarSupermercados();
		for (int i=0;i<a.size();i++){
			supermercados.put(a.get(i).getNombre(),String.valueOf(a.get(i).getId()));
		}
	}
}
