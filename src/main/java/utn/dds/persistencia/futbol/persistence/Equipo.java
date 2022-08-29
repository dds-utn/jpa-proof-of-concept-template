package utn.dds.persistencia.futbol.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Equipo {

	@Id
	@GeneratedValue
	private Long id;

	private String nombre;
	private Long cantidadAfiliados;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCantidadAfiliados() {
		return cantidadAfiliados;
	}

	public void setCantidadAfiliados(Long cantidadAfiliados) {
		this.cantidadAfiliados = cantidadAfiliados;
	}

}
