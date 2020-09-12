package utn.dds.persistencia.futbol.persistence;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import utn.dds.persistencia.futbol.persistence.auditoria.Auditable;
import utn.dds.persistencia.futbol.persistence.tienda.Producto;

@Entity
public class Equipo extends Auditable implements Competitivo {
  
	private String nombre;
	private Long cantidadAfiliados;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "codigo_liga")
	private Liga liga;
	
	@OneToMany
	@JoinColumn(name = "equipo_id")
	private List<Producto> productosEnTienda;

	private Date ultimaModificacion;

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
	
	
	@Override
	public Date getUltimaModificacion() {
	    return ultimaModificacion;
	}
	
	@Override
	public boolean esSospechoso() {
	  // TODO
	  return false;
	}
	
	@Override
	public boolean esDeAltoRendimiento() {
	  return cantidadAfiliados > 10000;
	}
}
