package utn.dds.persistencia.futbol.persistence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import utn.dds.persistencia.futbol.persistence.auditoria.Auditable;

@Entity
public class Formacion extends Auditable {
  
	private Long goles;
	
	@ManyToOne
	private Equipo equipo;
	
	@ManyToMany
	private Collection<Jugador> jugadores = new ArrayList<Jugador>();
	
	private Date ultimaModificacion;

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Collection<Jugador> getJugadores() {
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
	
    
    @Override
    public Date getUltimaModificacion() {
        return ultimaModificacion;
    }
    
    @Override
    public boolean esSospechoso() {
      // TODO
      return false;
    }

}
