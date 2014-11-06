package model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorColumn(name="Tipo")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Prenda {

   @ManyToOne
   private Marca marca;
   private int precio;
   @ManyToOne
   private Prenda reemplazo;
   @Id
   @GeneratedValue
   private long id;

   public Prenda(Marca marca, int precio, Prenda reemplazo) {
      this.marca = marca;
      this.precio = precio;
      this.reemplazo = reemplazo;
   }

}
