package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "notas")
public class Nota extends PersistentEntity {

	private String comentario;
	private int numero;

	public int getNumero() {
		return numero;
	}

	public String getComentario() {
		return comentario;
	}

}
