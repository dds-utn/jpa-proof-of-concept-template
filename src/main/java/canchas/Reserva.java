package canchas;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

public class Reserva {

  private Long reservaId;

  @OneToMany(cascade = CascadeType.PERSIST, fetch= FetchType.LAZY)
  @OrderColumn(name ="ordencito")
  private Collection<Inscripcion> inscripciones;

  private LocalDateTime fechaHoraInicio;

  private LocalDateTime fechaHoraFin;

  private Color colorCancha;

  public Reserva(Collection<Inscripcion> inscripciones,
      LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, Color colorCancha) {
    this.inscripciones = inscripciones;
    this.fechaHoraInicio = fechaHoraInicio;
    this.fechaHoraFin = fechaHoraFin;
    this.colorCancha = colorCancha;
  }


}
