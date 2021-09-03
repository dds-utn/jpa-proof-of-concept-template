package utn.dds.persistencia.futbol.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Jugador {
  
    @Id @GeneratedValue
    private Long id;
	
	private String nombre;
	private String posicion;

	// 1. Decidimos promover las lesiones de strings a
	// objetos de dominio
	// 2. Acabamos de usar una OneToMany
	@OneToMany
	@JoinColumn(name = "jugador_id")
	private List<Lesion> lesiones = new ArrayList<>();

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
	
	public Long getId() {
        return id;
    }

}
