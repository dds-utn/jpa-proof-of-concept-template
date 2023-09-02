package model;

import javax.persistence.*;


// si agrego posiciones

// posiciones
// id | vehiculo_id | lat | long
// 1  | 1            |   0  | 0
// 2  | 2            |   0  | 0
// 3  | 1            |   0  | 0.1

// si actualizo posiciones

// posiciones
// id | vehiculo_id | lat | long
// 1  | 1            |   0  | 0.1
// 2  | 2            |   0  | 0


// en realidad convendria que el vehiculo tenga esa información!


// vehiculo
// id | ... | lat | long
// 1  | ... |   0  | 0.1
// 2  | ... |   0  | 0

@Entity
public class Vehiculo {

	@Id
	@GeneratedValue
	private int id;

	private String patente;

	private int velocidadMaxima;

	@Embedded
	private Posicion posicion;

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public int getVelocidadMaxima() {
		return velocidadMaxima;
	}

	public void setVelocidadMaxima(int velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

}
