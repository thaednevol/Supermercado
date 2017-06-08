package co.edu.udistrital.mcic.ingsoft.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import co.edu.udistrital.mcic.ingsoft.entidad.Beneficiario;
import co.edu.udistrital.mcic.ingsoft.servicios.UsuarioServicios;


@ManagedBean
@ViewScoped
public class BeneficiarioController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3895020601436413454L;
	private UsuarioServicios servicio = new UsuarioServicios();
	private List<Beneficiario> beneficiarios = new ArrayList<Beneficiario>();
	private List<Beneficiario> filtered = new ArrayList<Beneficiario>();
	private Beneficiario nuevoBeneficiario = new Beneficiario();
	private Date fechaTemp;
	
	@PostConstruct
	public void init(){
		this.beneficiarios=servicio.findAll();
	}
	
	public void consultar(ActionEvent actionEvent){
		this.beneficiarios=servicio.findAll();
	}
	
	public String guardar(){
		System.out.println(servicio.consultarBeneficiario(nuevoBeneficiario.getIdentificacion()));
		;
		//nuevoBeneficiario.setFechaNacimiento(new java.sql.Date(fechaTemp.getTime()));
		//servicio.guardarBeneficiario(nuevoBeneficiario);
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

}
