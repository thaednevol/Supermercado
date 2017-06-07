package co.edu.udistrital.mcic.ingsoft.entidad;


import org.eclipse.persistence.descriptors.ClassExtractor;
import org.eclipse.persistence.sessions.Record;
import org.eclipse.persistence.sessions.Session;

public class UsuarioExtractor extends ClassExtractor {
    @Override
    public Class<?> extractClassFromRow(Record databaseRow, Session session) {
    	
    	 if (databaseRow.containsKey("AFILIADO")) {
             return Afiliado.class;
         } else if (databaseRow.containsKey("ADMINISTRADOR_SUPERMERCADO")) {
             return AdministradorSupermercado.class;
         } else {
             return Usuario.class; // this should never happen
         }
    }

}
