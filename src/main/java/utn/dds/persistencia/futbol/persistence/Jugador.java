package utn.dds.persistencia.futbol.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderColumn;

@Entity
public class Jugador {
  
    @Id @GeneratedValue
    private Long id;
	
	private String nombre;
	private String posicion;

	public String getNombre() {
		return nombre;
	}
	
	private List<String> lesiones = new ArrayList<>();

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	public Long getId() {
        return id;
    }

}
