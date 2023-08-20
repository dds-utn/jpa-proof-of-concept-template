package utn.dds.persistencia.futbol.persistence;

import utn.dds.persistencia.futbol.persistence.difusion.Difusion;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
public class Partido implements Competitivo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Calendar fecha;
  private Integer cantidadEspectadores;

  @ManyToOne
  private Formacion local;
  @ManyToOne
  private Formacion visitante;

  @ManyToMany
  @OrderColumn(name = "posicion")
  private List<Jugador> goleadores = new ArrayList<>();

  @Enumerated
  private Difusion difusion;

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

  @Override
  public boolean esDeAltoRendimiento() {
    return cantidadEspectadores > 100000;
  }

}
