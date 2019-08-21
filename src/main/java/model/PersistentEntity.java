package model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class PersistentEntity {

	@Id
	@GeneratedValue
	private Long id;

	public Long getId() {
		return id;
	}


}
