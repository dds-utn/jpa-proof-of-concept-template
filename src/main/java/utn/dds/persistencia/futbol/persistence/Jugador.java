package utn.dds.persistencia.futbol.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Jugador {

	@Id
	// Nota: observar cómo cambia el esquema y cómo cambia el orden
	// de las operaciones al correr el ContextTest usando una u otra
	// estrategia
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@GeneratedValue
	private Long id;
	
	private String nombre;
	private String posicion;

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

}
