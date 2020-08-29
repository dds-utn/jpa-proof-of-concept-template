package utn.dds.persistencia.futbol.persistence;

public class Equipo {
  
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
