package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cursadas")
public class Cursada extends PersistentEntity {

	@ManyToOne
	private Materia materia;

	@OneToMany
	@OrderColumn(name = "posicion")
	@JoinColumn(name = "cursada_id")
	private List<Nota> notas = new ArrayList<>();

	public Materia getMateria() {
		return materia;
	}

	public List<Nota> getNotas() {
		return notas;
	}

}
