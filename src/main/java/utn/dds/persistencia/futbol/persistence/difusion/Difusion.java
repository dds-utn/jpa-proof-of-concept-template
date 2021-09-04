package utn.dds.persistencia.futbol.persistence.difusion;

import utn.dds.persistencia.futbol.persistence.Partido;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Difusion {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private long id;
  
  public abstract void iniciarDifusion(Partido partido);
  public abstract void finalizarDifusion(Partido partido);

  public long getId() { return id; }

}
