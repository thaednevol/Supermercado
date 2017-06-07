package co.edu.udistrital.mcic.ingsoft.entidad;

import java.sql.Date;
import java.util.List;

public class Reporte {
	
	
	private Usuario usuarioConsulta;
	
	private List<Compra> compras;

	
	public void Generar(Usuario usuario , Date fechaInicio, Date fechaFin  ) {
		
	}
	
	
	public void Imprimir(Usuario usuario) {
			
	}
	
	
	public boolean enviarEmail(Usuario usuario) {
		return false;
	}


	public Usuario getUsuarioConsulta() {
		return usuarioConsulta;
	}


	public void setUsuarioConsulta(Usuario usuarioConsulta) {
		this.usuarioConsulta = usuarioConsulta;
	}


	public List<Compra> getCompras() {
		return compras;
	}


	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	
	
	

}
