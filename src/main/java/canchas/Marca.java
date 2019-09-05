package canchas;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Embeddable
public class Marca {

	@Column(name = "marcaNombre")
	private String nombre;
	private String telefonoRepresentante;
	
	public Marca() {}
	public Marca(String nombre, String telefonoRepresentante) {
		this.nombre = nombre;
		this.telefonoRepresentante = telefonoRepresentante;
	}
}
