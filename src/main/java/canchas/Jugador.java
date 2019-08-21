package canchas;

import java.util.Date;

public abstract class Jugador {
	
  private Long jugadorId;
	
  private String nombre;
  
  private String apellido;
  
  private String domicilio;
  
  private String telefono;
  
  private Date fechaNacimiento;

  private Paleta paleta;

  public Inscripcion crearInscripcion() {
    return new Inscripcion(this, this.paleta);
  }

  public void setPaleta(Paleta paletaB) {
    this.paleta = paleta;
  }
  
}
