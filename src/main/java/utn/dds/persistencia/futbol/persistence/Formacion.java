package utn.dds.persistencia.futbol.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Formaciones")
public class Formacion {
  
    @Id 
    @GeneratedValue
    private Long id;
  
	private Long goles;
	
	@ManyToOne
	private Equipo equipo;
	
	@ManyToMany
	@JoinTable(name = "Participantes")
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
