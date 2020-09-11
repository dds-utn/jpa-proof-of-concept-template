package utn.dds.persistencia.futbol.persistence.auditoria;

import java.util.Date;

public interface Auditable {
  
  public Date getUltimaModificacion();
  
  public boolean esSospechoso();

}
