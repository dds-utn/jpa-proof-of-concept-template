package utn.dds.persistencia.futbol.persistence;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

@Entity
public class Partido {
  
    @Id @GeneratedValue
    private Long id;

	private Calendar fecha;
	private Integer cantidadEspectadores;

	@ManyToOne
	private Formacion local;
	@ManyToOne
	private Formacion visitante;

	@ManyToMany
	@OrderColumn(name = "orden")
	// dani(1) 0
	// dani(1) 1
	// feli(2) 2
	// juli(3) 3
	// dani(1) 4
	private List<Jugador> goleadores = new ArrayList<>();

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public Integer getCantidadEspectadores() {
		return cantidadEspectadores;
	}

	public void setCantidadEspectadores(Integer cantidadEspectadores) {
		this.cantidadEspectadores = cantidadEspectadores;
	}
	
	public void registrarGol(Jugador jugador, Formacion formacion) {
	  formacion.setGoles(formacion.getGoles() + 1);
	  goleadores.add(jugador);
	}

	public Formacion ganador() {
		if (local.getGoles().compareTo(visitante.getGoles()) > 0) {
			return local;
		} else {
			return visitante;
		}
	}
	
	public List<Jugador> getGoleadores() {
      return goleadores;
    }
	
	public Long getId() {
        return id;
    }

}
