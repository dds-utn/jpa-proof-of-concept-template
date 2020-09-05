package utn.dds.persistencia.futbol.persistence;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Partidos")
public class Partido {
      
    @Id 
    @GeneratedValue
    private Long id;
  
    
	private Calendar fecha;
	
	@Column(name = "cantidad_espectadores")
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

}
