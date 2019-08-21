package canchas;

import java.time.LocalDateTime;
import java.util.Collection;

public class Reserva {

  private Long reservaId;

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
