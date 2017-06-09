package co.edu.udistrital.mcic.ingsoft.controlador;

import java.sql.Time;
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
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.context.RequestContext;

import co.edu.udistrital.mcic.ingsoft.entidad.Beneficiario;
import co.edu.udistrital.mcic.ingsoft.entidad.Compra;
import co.edu.udistrital.mcic.ingsoft.entidad.Producto;
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
	
	private List<Compra> compras = new ArrayList<Compra>();
	private List<Compra> filtered;
	
	private Compra compra = new Compra();
	
	private Producto producto;
	private String productoSel;
	private Map<String,String> productos = new HashMap<String, String>();
	private List<Producto> listProductos;

	public void registrarCompra(ActionEvent actionEvent){
		Compra c=new Compra();
		c.setFecha(new java.sql.Date(fechaCompra.getTime()));
		c.setHora(new Time(horaCompra.getTime()));
		c.setBeneficiario(servicio.consultarBeneficiario(identificacionBeneficiario));
		gservicio.registrarCompra(c);
		this.setCompras(gservicio.consultarCompras());
	}
	
	public String registrarCompra(){
		Compra c=new Compra();
		c.setFecha(new java.sql.Date(fechaCompra.getTime()));
		c.setHora(new Time(horaCompra.getTime()));
		c.setBeneficiario(servicio.consultarBeneficiario(identificacionBeneficiario));
		gservicio.registrarCompra(c);
		return "";
	}
	
	
	public void listener(AjaxBehaviorEvent event) {
		if (Integer.parseInt(productoSel)!=-1){
			producto=listProductos.get(Integer.parseInt(productoSel)-1);
		}
		
    }
	
	public String agregarProducto(){
		compra.agregarProducto(producto);
		compra.calcularTotal();
		return "";
	}
	
	public String showCompra(){
		return "";
	}
	
	public String restarProducto(Producto pro){
		compra.restarProducto(pro);
		compra.calcularTotal();
		return "";
	}
	
	public String confirmarCompra(){
		if(!compra.validarCupoParcial()){
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("No tiene suficiente saldo para realizar la compra"));
		}
		else {
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('dlgCompra').hide();");
			FacesContext fContext = FacesContext.getCurrentInstance();
			fContext.addMessage(null, new FacesMessage("La compra se ha realizado con éxito"));
			
			gservicio.actualizarCompra(compra);
			
		}
		
			
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
	
	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public String getProductoSel() {
		return productoSel;
	}

	public void setProductoSel(String productoSel) {
		this.productoSel = productoSel;
	}

	public Map<String, String> getProductos() {
		return productos;
	}

	public void setProductos(Map<String, String> productos) {
		this.productos = productos;
	}
	
	public List<Producto> getListProductos() {
		return listProductos;
	}

	public void setListProductos(List<Producto> listProductos) {
		this.listProductos = listProductos;
	}
	
	

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@PostConstruct
	public void init(){
		this.setCompras(gservicio.consultarCompras());
		this.setBeneficiarios(servicio.findAll());
		listProductos=gservicio.consultarProductos();
		for (int i=0;i<listProductos.size();i++){
			System.out.println(listProductos.get(i).getNombre()+" "+String.valueOf(listProductos.get(i).getId()));
			productos.put(listProductos.get(i).getNombre(),String.valueOf(listProductos.get(i).getId()));
		}
		
		List<Supermercado> s = gservicio.consultarSupermercados();
		for (int i=0;i<s.size();i++){
			supermercados.put(s.get(i).getNombre(),String.valueOf(s.get(i).getId()));
		}
	}

}