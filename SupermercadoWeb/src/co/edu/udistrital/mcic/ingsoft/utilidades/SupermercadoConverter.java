package co.edu.udistrital.mcic.ingsoft.utilidades;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import co.edu.udistrital.mcic.ingsoft.entidad.Supermercado;
import co.edu.udistrital.mcic.ingsoft.servicios.GeneralServicios;

@FacesConverter("supermercadoConverter")
public class SupermercadoConverter implements Converter {
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
    	System.out.println("LLEGA AQUI 1");
        if(value != null && value.trim().length() > 0) {
        	System.out.println("LLEGA AQUI 2");
            try {
            	System.out.println("LLEGA AQUI 4");
            	System.out.println("LLEGA AQUI 6"+value+"************");
            	
            	GeneralServicios gservicio = new GeneralServicios();
            	return gservicio.consultarSupermercado(Integer.parseInt(value));
            } catch(NumberFormatException e) {
            	System.out.println("LLEGA AQUI 5");
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
        	System.out.println("LLEGA AQUI 3");
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
        	System.out.println(object);
        	if (object instanceof String){
        		System.out.println("Supermercado como string "+object);
        		//return (String)object;
        	}
        	if (object instanceof Supermercado){
        		Supermercado s=(Supermercado)object;
        		System.out.println("Supermercado como supermercado "+s.getNombre()+" "+s.getId());
                return String.valueOf(s.getId());
        	}
        	return "";	
        	
        }
        else {
            return null;
        }
    }   
}         
    