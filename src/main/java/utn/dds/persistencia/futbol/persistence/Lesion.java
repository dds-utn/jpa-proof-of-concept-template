package utn.dds.persistencia.futbol.persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Lesion {

  private LocalDateTime fecha;
  private String descripción;


  public Lesion(LocalDateTime fecha, String descripción) {
    this.fecha = fecha;
    this.descripción = descripción;
  }

  public LocalDateTime getFecha() {
    return fecha;
  }

  public String getDescripción() {
    return descripción;
  }


}
