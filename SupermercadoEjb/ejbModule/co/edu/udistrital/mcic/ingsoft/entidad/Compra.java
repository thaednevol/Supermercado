package co.edu.udistrital.mcic.ingsoft.entidad;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Compra implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4856381085803440597L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private Date fecha;
	private Time hora;
	private Beneficiario beneficiario;
	private List<Producto> productos = new ArrayList<Producto>();
	private double total;
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public Beneficiario getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public void registrarCompra() {
		// Realizar persistencia a la BD (fecha, hora, beneficiario,
		// supermercado, productos)
	}

	public void agregarProducto(Producto producto) {
		if (productos==null){
			productos = new ArrayList<Producto>();
		}
		productos.add(producto);
	}

	public boolean verificarBeneficiario() {
		return false;
	}

	public boolean validarHorario() {
		
		boolean a =beneficiario.getCupo()<10000?true:false;
		return a;
		
	}

	public void restarProducto(Producto producto) {
		productos.remove(producto);
	}

	public void calcularTotal() {
		double t=0;
		for (Producto p:productos){
			t=t+p.getPrecio();
		}
		total=t;
	}
	


	public boolean validarCupoGlobal() {
		return false;
	}

	public boolean validarCupoParcial() {
		if(this.total<this.beneficiario.getCupo())
			return true;
		
		return false;
	}

	public boolean confirmarCompra() {
		return false;
	}

	public boolean cancelarCompra() {
		return false;
	}

	public void enviarMensajeAfiliado() {

	}

}
