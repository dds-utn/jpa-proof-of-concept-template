package model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Consultoras")
public class Consultora {

	@Id
	private int id;
	
	private String nombre;
	private int cantidadDeEmpleados;

	@OneToMany
	@JoinColumn(name = "consultora_id")
	private Collection<Proyecto> proyectos;

	public Consultora(String nombre, int cantidadDeEmpleados) {
		this.nombre = nombre;
		this.cantidadDeEmpleados = cantidadDeEmpleados;
		this.proyectos = new ArrayList<>();
	}
	
	public void asignar(Proyecto proyecto) {
		proyectos.add(proyecto);
	}

	public int getCantidadDeEmpleados() {
		return cantidadDeEmpleados;
	}

	public String getNombre() {
		return nombre;
	}

	public Collection<Proyecto> getProyectos() {
		return proyectos;
	}
	
	public int getId() {
		return id;
	}

}
