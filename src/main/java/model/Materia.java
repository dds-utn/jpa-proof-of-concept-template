package model;

import static javax.persistence.InheritanceType.SINGLE_TABLE;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@Entity
@Table(name = "materias")
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Materia extends PersistentEntity {

	@Column(nullable=false)
	protected String nombre;

	public abstract boolean esPromocionable();

	public String getNombre() {
		return nombre;
	}
	
	// Mas comportamiento común

}
