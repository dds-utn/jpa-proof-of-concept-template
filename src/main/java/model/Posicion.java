package model;

import javax.persistence.Embeddable;


public class Posicion {

	private int latitud;
	private int longitud;

	public int getLatitud() {
		return latitud;
	}

	public void setLatitud(int latitud) {
		this.latitud = latitud;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public int distancia(Posicion posicion) {
		//calculo dificil
		return 0;
	}
}
