package utn.dds.persistencia.futbol.persistence.auditoria;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Auditable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  public abstract Date getUltimaModificacion();

  public abstract boolean esSospechoso();


  public Long getId() {
    return id;
  }


}
