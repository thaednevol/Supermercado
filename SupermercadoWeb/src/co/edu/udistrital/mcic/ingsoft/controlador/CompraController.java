package co.edu.udistrital.mcic.ingsoft.controlador;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import co.edu.udistrital.mcic.ingsoft.entidad.Beneficiario;
import co.edu.udistrital.mcic.ingsoft.entidad.Compra;
import co.edu.udistrital.mcic.ingsoft.entidad.Supermercado;
import co.edu.udistrital.mcic.ingsoft.servicios.GeneralServicios;
import co.edu.udistrital.mcic.ingsoft.servicios.UsuarioServicios;

@ManagedBean(name="compraController")
@ViewScoped
public class CompraController {
	
	private Date fechaCompra=new Date();
	private Date horaCompra=new Date();
	private String identificacionBeneficiario;
	private List<Beneficiario> beneficiarios;
	private UsuarioServicios servicio = new UsuarioServicios();
	private GeneralServicios gservicio = new GeneralServicios();
	private Map<String,String> supermercados = new HashMap<String, String>();
	private String supermercadoTemp=new String();
	
	private List<Compra> compras;
	private List<Compra> filtered;
	

	public void registrarCompra(ActionEvent actionEvent){
		Compra c=new Compra();
		c.setFecha(new java.sql.Date(fechaCompra.getTime()));
		c.setHora(new java.sql.Date(fechaCompra.getTime()));
		c.setBeneficiario(servicio.consultarBeneficiario(identificacionBeneficiario));
		gservicio.registrarCompra(c);
		
		this.setCompras(gservicio.consultarCompras());
	}
	
	public String registrarCompra(){
		Compra c=new Compra();
		c.setFecha(new java.sql.Date(fechaCompra.getTime()));
		c.setHora(new java.sql.Date(fechaCompra.getTime()));
		c.setBeneficiario(servicio.consultarBeneficiario(identificacionBeneficiario));
		gservicio.registrarCompra(c);
		return "";
	}
	
	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Date getHoraCompra() {
		return horaCompra;
	}

	public void setHoraCompra(Date horaCompra) {
		this.horaCompra = horaCompra;
	}

	public String getIdentificacionBeneficiario() {
		return identificacionBeneficiario;
	}

	public void setIdentificacionBeneficiario(String identificacionBeneficiario) {
		this.identificacionBeneficiario = identificacionBeneficiario;
	}

	public UsuarioServicios getServicio() {
		return servicio;
	}

	public void setServicio(UsuarioServicios servicio) {
		this.servicio = servicio;
	}

	public GeneralServicios getGservicio() {
		return gservicio;
	}

	public void setGservicio(GeneralServicios gservicio) {
		this.gservicio = gservicio;
	}
	
	

	public List<Beneficiario> getBeneficiarios() {
		return beneficiarios;
	}

	public void setBeneficiarios(List<Beneficiario> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}
	
	

	public Map<String, String> getSupermercados() {
		return supermercados;
	}

	public void setSupermercados(Map<String, String> supermercados) {
		this.supermercados = supermercados;
	}

	public String getSupermercadoTemp() {
		return supermercadoTemp;
	}

	public void setSupermercadoTemp(String supermercadoTemp) {
		this.supermercadoTemp = supermercadoTemp;
	}
	
	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	
	

	public List<Compra> getFiltered() {
		return filtered;
	}

	public void setFiltered(List<Compra> filtered) {
		this.filtered = filtered;
	}

	@PostConstruct
	public void init(){
		this.setCompras(gservicio.consultarCompras());
		this.setBeneficiarios(servicio.findAll());
		List<Supermercado> a = gservicio.consultarSupermercados();
		for (int i=0;i<a.size();i++){
			supermercados.put(a.get(i).getNombre(),String.valueOf(a.get(i).getId()));
		}
	}


}
