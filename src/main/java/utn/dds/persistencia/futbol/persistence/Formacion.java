package utn.dds.persistencia.futbol.persistence;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/*

Formaciones ->------|- Equipos
Equipos -|-------<- Formaciones

 muchas formaciones tienen un equipo
 formaciones tiene una relación muchos a uno con equipo

 un equipo (puede tener/tiene) muchas formaciones
 equipos tiene una relación uno a muchos con formaciones
*/


@Entity
public class Formacion {

	@Id
	@GeneratedValue
	private Long id;
  
	private Long goles;

	@ManyToOne
	private Equipo equipo;

	@ManyToMany
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
