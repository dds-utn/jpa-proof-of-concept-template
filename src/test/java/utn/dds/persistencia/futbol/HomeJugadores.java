package utn.dds.persistencia.futbol;

import static utn.dds.persistencia.futbol.db.EntityManagerHelper.getEntityManager;

import java.util.List;

import utn.dds.persistencia.futbol.db.EntityManagerHelper;
import utn.dds.persistencia.futbol.persistence.Jugador;

public class HomeJugadores {

	public void registrar(Jugador jugador) {
		getEntityManager().persist(jugador);
	}

	@SuppressWarnings("unchecked")
	public List<Jugador> todos() {
		return getEntityManager()
				.createQuery("from Jugador")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Jugador> filtrarPorNombre(String nombre) {
		return getEntityManager()
				.createQuery("from Jugador where nombre = :nombre")
				.setParameter("nombre", nombre)
				.getResultList();
	}

}
