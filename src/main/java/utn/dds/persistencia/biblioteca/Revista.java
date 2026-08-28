package utn.dds.persistencia.biblioteca;

import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Entity
public class Revista extends Publicacion {

  private int numero;

  @Enumerated
  private Periodicidad periodicidad;

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public Periodicidad getPeriodicidad() {
    return periodicidad;
  }

  public void setPeriodicidad(Periodicidad periodicidad) {
    this.periodicidad = periodicidad;
  }

}
