package utn.dds.persistencia.futbol.persistence.difusion;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import utn.dds.persistencia.futbol.persistence.Partido;

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



