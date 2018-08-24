package model;

import java.util.List;

import javax.persistence.EntityManager;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

public class Runner {
	public static void main(String[] args) {
		//new Fixture().run();
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		List<Alumno> alumnos = 
				entityManager
				.createQuery("from Alumno")
				.getResultList();
		
		for (Alumno alumno : alumnos) {
			System.out.println(alumno.getNombre());
		}
	}
}
