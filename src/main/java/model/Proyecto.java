package model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name="Proyectos")
public class Proyecto {

	@Id
	private long id;
	
	private String nombre;
	private BigDecimal costoEstimado;
	
	public Proyecto(String nombre, BigDecimal costoEstimado) {
		this.nombre = nombre;
		this.costoEstimado = costoEstimado;
	}

	public String getNombre() {
		return nombre;
	}

	public BigDecimal getCostoEstimado() {
		return costoEstimado;
	}
	
	public long getId() {
		return id;
	}

}
