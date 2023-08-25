package utn.dds.persistencia.futbol.persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Partido {

  @Id
  @GeneratedValue
  private Long id;

  private LocalDate fecha;
  private Integer cantidadEspectadores;

  private Formacion local;
  private Formacion visitante;

  private List<Jugador> goleadores = new ArrayList<>();

  public LocalDate getFecha() {
    return fecha;
  }

  public void setFecha(LocalDate fecha) {
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
