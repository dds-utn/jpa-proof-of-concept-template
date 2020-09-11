package utn.dds.persistencia.futbol.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Equipo {
  
    @Id @GeneratedValue
    private Long id;
  
	private String nombre;
	private Long cantidadAfiliados;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "codigo_liga")
	private Liga liga;

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
	
	public Long getId() {
        return id;
    }

}
