package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Asignacion {

	@Id @GeneratedValue
	private Long id;
	
	@Transient
	private List<String> notas;	
	
	@ManyToOne
	private Tarea tarea;
	
	public Asignacion(Tarea tarea) {
		this.tarea = tarea;
		this.notas = new ArrayList<>();
	}

	public List<String> getNotas() {
		return notas;
	}

	public void setNotas(List<String> notas) {
		this.notas = notas;
	}

	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}
	
}
