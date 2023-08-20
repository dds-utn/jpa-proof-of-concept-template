package model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Proyectos")
public class Proyecto {

  @Id
  @GeneratedValue
  private long id;

  private String nombre;

  @Column(name = "costo_estimado")
  private BigDecimal costoEstimado;

  @ManyToOne
  @JoinColumn(name = "consultora_encargada")
  private Consultora consultoraEncargada;

  protected Proyecto() {
  }

  public Proyecto(String nombre, BigDecimal costoEstimado) {
    this.nombre = nombre;
    this.costoEstimado = costoEstimado;
  }

  public String getNombre() {
    return nombre;
  }

  public BigDecimal getCostoEstimado() {
    return costoEstimado;
  }

  void asignarA(Consultora consultora) {
    this.consultoraEncargada = consultora;

  }
}
