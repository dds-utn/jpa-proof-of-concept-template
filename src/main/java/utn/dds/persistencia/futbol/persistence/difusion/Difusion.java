package utn.dds.persistencia.futbol.persistence.difusion;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import utn.dds.persistencia.futbol.persistence.Partido;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Difusion {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
          name = "UUID",
          strategy = "org.hibernate.id.UUIDGenerator"
  )
  private String id;
  
  private String codigo;

  public abstract void iniciarDifusion(Partido partido);
  public abstract void finalizarDifusion(Partido partido);

  public String getId() { return id; }
}
