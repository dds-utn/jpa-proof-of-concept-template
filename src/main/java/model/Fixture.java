package model;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

public class Fixture implements WithGlobalEntityManager, TransactionalOps {

	public void run() {
		withTransaction(() -> {
			entityManager().persist(new Alumno("1196133", "Gaston", "gastonprietoutn@gmail.com","gastonprieto", "Prieto", "secretCode"));
			entityManager().persist(new Alumno("1233123", "Juan", "jzaffaroni@gmail.com","jzaffaroni", "Zaffaroni", "zaffaCode"));
		}); 
	}

	
	
}
