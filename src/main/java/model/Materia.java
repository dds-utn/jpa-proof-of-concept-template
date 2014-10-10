package model;

import static javax.persistence.InheritanceType.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@Entity
@Table(name="materias")
@Inheritance(strategy=TABLE_PER_CLASS)
@DiscriminatorColumn(name= "foo")
public abstract class Materia extends PersistentEntity {

	@Column(nullable=false)
	protected String nombre;

	public abstract boolean esPromocionable();

	public String getNombre() {
		return nombre;
	}
	
	// Mas comportamiento común

}
