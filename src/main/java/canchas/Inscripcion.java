package canchas;

public class Inscripcion {

  private Long inscripcionId;

  private Paleta paleta;

  private Jugador jugador;

  public Inscripcion(Jugador jugador, Paleta paleta) {
    this.jugador = jugador;
    this.paleta = paleta;
  }
}
