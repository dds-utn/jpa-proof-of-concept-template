package utn.dds.persistencia.biblioteca;

public class Revista extends Publicacion {

  private int numero;
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
