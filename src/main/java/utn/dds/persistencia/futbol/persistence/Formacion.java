package utn.dds.persistencia.futbol.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "formaciones")
public class Formacion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name="gl")
  private Long goles;

  @ManyToOne
  @JoinColumn(name = "equipo_id") // redundante
  private Equipo equipo;

  @ManyToMany
  @JoinTable(name = "jugador_x_formacion")
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

  public Long getId() {
    return id;
  }

}
