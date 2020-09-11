package utn.dds.persistencia.futbol.persistence.auditoria;

import java.util.Collection;

public class Auditoria {
  
  private String auditer;
  
  private Collection<Auditable> aRevisar;

  public String getAuditer() {
    return auditer;
  }

  public Collection<Auditable> getARevisar() {
    return aRevisar;
  }

  public void setAuditer(String auditer) {
    this.auditer = auditer;
  }
  
  public void setARevisar(Collection<Auditable> aRevisar) {
    this.aRevisar = aRevisar;
  }

 
  
  

}
