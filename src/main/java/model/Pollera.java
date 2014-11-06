package model;

import javax.persistence.Entity;


@Entity
public class Pollera extends Prenda {

   private int largo;

   public Pollera(Marca marca, int precio, Prenda reemplazo, int largo) {
      super(marca, precio, reemplazo);
      this.largo = largo;
   }

}
