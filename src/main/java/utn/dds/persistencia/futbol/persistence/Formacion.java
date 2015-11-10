package utn.dds.persistencia.futbol.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
public class Formacion {

	@Id @GeneratedValue
	private Long id;
	
	private Long goles;
	
	@Transient
	private Equipo equipo;
	
	@ManyToMany(cascade = CascadeType.PERSIST
			, fetch = FetchType.EAGER)
	private List<Jugador> jugadores = new ArrayList<Jugador>();

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public Long getGoles() {
		return goles;
	}

	public void setGoles(Long goles) {
		this.goles = goles;
	}

}
