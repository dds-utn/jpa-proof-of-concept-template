package utn.dds.persistencia.futbol.persistence.difusion;

import utn.dds.persistencia.futbol.persistence.Partido;

import javax.persistence.*;

@Entity
@DiscriminatorColumn(name = "tipo", length = 1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Difusion {

  @Id
  @GeneratedValue
  private Long id;

  private String codigo;

  public abstract void iniciarDifusion(Partido partido);

  public abstract void finalizarDifusion(Partido partido);

}



