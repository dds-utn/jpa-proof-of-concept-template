package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Usuarios")
public class Usuario {

  @Id
  @GeneratedValue
  private long id;

  private String username;

  private String password;

  @OneToMany
  @JoinColumn(name = "administrador")
  private Collection<Consultora> consultorasAdministradas = new ArrayList<>();

  public Usuario(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public Usuario() {
  }

  public String getPassword() {
    return password;
  }

  public Long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public Collection<Consultora> getConsultorasAdministradas() {
    return consultorasAdministradas;
  }

  public void agregarConsultora(Consultora consultora) {
    consultorasAdministradas.add(consultora);
  }
}
