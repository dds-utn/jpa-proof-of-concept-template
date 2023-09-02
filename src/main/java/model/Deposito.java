package model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
public class Deposito {

	@Id
	@GeneratedValue
	private int id;

	@ElementCollection
	private List<LocalDate> fechasDeInspeccion;

	private int capacidadM3;

	private int cantidadPasillos;

	private boolean abiertoALaNoche;

	@Embedded
	private Posicion posicion;

	@ElementCollection
	private Collection<Posicion> entradas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacidadM3() {
		return capacidadM3;
	}

	public void setCapacidadM3(int capacidadM3) {
		this.capacidadM3 = capacidadM3;
	}

	public int getCantidadPasillos() {
		return cantidadPasillos;
	}

	public void setCantidadPasillos(int cantidadPasillos) {
		this.cantidadPasillos = cantidadPasillos;
	}

	public boolean isAbiertoALaNoche() {
		return abiertoALaNoche;
	}

	public void setAbiertoALaNoche(boolean abiertoALaNoche) {
		this.abiertoALaNoche = abiertoALaNoche;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

}
