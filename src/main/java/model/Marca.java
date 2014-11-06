package model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@DiscriminatorColumn(name="Tipo")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Marca {
   
   @Id
   @GeneratedValue
   private long id;

}
