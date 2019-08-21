package canchas;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;


public class Cancha {

	private Long id;

	private String nombre;

	private Boolean tieneIluminacion;

	private Collection<Reserva> reservas = new ArrayList<Reserva>();

	private Color color;
	
	public Cancha(){
		super();
	}

	public Cancha(String nombre) {
		this.nombre = nombre;
	}

	public Cancha(String nombre, Color color) {
		this.nombre = nombre;
		this.setColor(color);
	}

	public Long getId() {
		return id;
	}

	public void setCanchaId(Long canchaId) {
		this.id = canchaId;
	}

	public Color getColor() {
		return color;
	}

	public void setNombre(String nombre) {
    this.nombre = nombre;
  }
	
	public void setColor(Color color) {
		this.color = color;
	}

  public void reservar(LocalDateTime inicioReserva, Collection<Jugador> jugadores) {
    reservas.add(new GeneradorReserva()
      .inicioReserva(inicioReserva)
      .jugadores(jugadores)
      .cancha(this)
      .build());
  }
}
