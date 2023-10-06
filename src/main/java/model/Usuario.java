package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Usuarios")
public class Usuario extends BaseEntity {

  @Column
  private String nombre;

  @Column
  private String email;

  @OneToMany(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "usuario_id")
  private Collection<Guardarropa> guardarropas = new ArrayList<>();

  public Usuario(String nombre, String email) {
    this.nombre = nombre;
    this.email = email;
  }

  public void agregarGuardarropa(Guardarropa guardarropa) {
    this.guardarropas.add(guardarropa);
  }

}
