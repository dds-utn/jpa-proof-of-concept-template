package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("O")
public class MateriaObligatoria extends Materia {

	private Boolean homogenea;

	public MateriaObligatoria(String nombre, Boolean homogenea) {
		this.nombre = nombre;
		this.homogenea = homogenea;
	}

	public boolean esPromocionable() {
		return homogenea;
	}


}
