package model;

import org.apache.commons.codec.digest.DigestUtils;

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

  @Column
  private String hashContrasenia;

  @OneToMany(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "usuario_id")
  private Collection<Guardarropa> guardarropas = new ArrayList<>();

  public Usuario() {
  }

  public Usuario(String nombre, String email, String contrasenia) {
    this.nombre = nombre;
    this.email = email;
    this.setContrasenia(contrasenia);
  }

  public void setContrasenia(String contrasenia) {
    this.hashContrasenia = DigestUtils.sha256Hex(contrasenia);
  }

  public void agregarGuardarropa(Guardarropa guardarropa) {
    this.guardarropas.add(guardarropa);
  }

}
