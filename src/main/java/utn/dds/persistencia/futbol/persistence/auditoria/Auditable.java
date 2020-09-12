package utn.dds.persistencia.futbol.persistence.auditoria;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

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
