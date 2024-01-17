package Ejercicio;

import Entidad.University;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TareaEvaluativa4bDelete {
	/**
	 * 4. OneToMany bidireccional entre entidades Student y University
	 * Borra una Universidad y sus estudiantes.
	 */
	public static void main(String[] args) {

		// crea sessionFactory y session
				EntityManagerFactory factory = Persistence.createEntityManagerFactory("ud4");
				EntityManager em = factory.createEntityManager();    
		
		
		try {			
			// crea un objeto Student
			System.out.println("Borrando una universidad sin borrar sus estudiantes");
			
			int university_id = 3;
			
			University tempUniversity = em.find(University.class, university_id);
			// comienza la transacci�n
			em.getTransaction().begin();
		
			// borra la universidad pero no el estudiante. "on delete set null" en BD
			em.remove(tempUniversity);
			
			// hace commit de la transaccion
			em.getTransaction().commit();
					
			System.out.println("Hecho!");
		}
		catch ( Exception e ) {
			// rollback ante alguna excepci n
			System.out.println("Realizando Rollback");
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		finally {
			em.close();
			factory.close();
		}
	}
	
}




