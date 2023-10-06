package model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Guardarropas")
public class Guardarropa extends BaseEntity {

  @OneToMany(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "guardarropa_id")
  @OrderColumn(name = "importancia")
  private List<Prenda> prendas = new ArrayList<Prenda>();
  @Column
  private String nombre;

  public Guardarropa(String nombre) {
    this.nombre = nombre;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public List<Prenda> getPrendas() {
    return prendas;
  }

  public void setPrendas(List<Prenda> prendas) {
    this.prendas = prendas;
  }


  public void agregarPrenda(Prenda prenda) {
    this.prendas.add(prenda);
  }
}
