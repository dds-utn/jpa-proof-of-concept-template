package model;

import javax.persistence.Entity;

@Entity
public class Pantalon extends Prenda {

   private int cantidadBolsillos;

   public Pantalon(Marca marca, int precio, Prenda reemplazo,
         int cantidadBolsillos) {
      super(marca, precio, reemplazo);
      this.cantidadBolsillos = cantidadBolsillos;
   }

}
