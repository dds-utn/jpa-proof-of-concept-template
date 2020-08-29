package utn.dds.persistencia.futbol.persistence;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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

	public Formacion ganador() {
		if (local.getGoles().compareTo(visitante.getGoles()) > 0) {
			return local;
		} else {
			return visitante;
		}
	}
	
	public Long getId() {
        return id;
    }

}
