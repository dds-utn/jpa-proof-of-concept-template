package utn.dds.persistencia.futbol.persistence.auditoria;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class Auditable {
  
  @Id
  @GeneratedValue
  private Long id;
  
  public abstract Date getUltimaModificacion();
  
  public abstract boolean esSospechoso();

}
