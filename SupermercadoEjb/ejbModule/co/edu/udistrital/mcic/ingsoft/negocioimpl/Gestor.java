package co.edu.udistrital.mcic.ingsoft.negocioimpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Gestor {
	
	protected EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("supermercadoejb");
	protected EntityManager entityManager = entityManagerFactory.createEntityManager();

}
