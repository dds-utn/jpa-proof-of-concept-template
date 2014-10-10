package model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "alumnos")
public class Alumno extends PersistentEntity {

	@OneToMany
	@JoinColumn(name = "alumno_id")
	private Collection<Cursada> cursada = new ArrayList<>();

	public Collection<Cursada> getCursadas() {
		return cursada;
	}
}
