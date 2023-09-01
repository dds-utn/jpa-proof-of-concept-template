package utn.dds.persistencia.futbol.persistence.difusion;

import utn.dds.persistencia.futbol.persistence.Partido;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Difusion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public abstract void iniciarDifusion(Partido partido);

  public abstract void finalizarDifusion(Partido partido);

}
