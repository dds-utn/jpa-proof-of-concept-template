package utn.dds.persistencia.futbol.persistence;


import java.util.List;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

public class HomeJugadores implements WithGlobalEntityManager {

	public void registrar(Jugador jugador) {
		entityManager().persist(jugador);
	}

	@SuppressWarnings("unchecked")
	public List<Jugador> todos() {
		return entityManager()
				.createQuery("from Jugador")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Jugador> filtrarPorNombre(String nombre) {
		return entityManager()
				.createQuery("from Jugador where nombre = :nombre")
				.setParameter("nombre", nombre)
				.getResultList();
	}

}
