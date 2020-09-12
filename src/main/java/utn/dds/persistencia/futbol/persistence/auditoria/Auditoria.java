package utn.dds.persistencia.futbol.persistence.auditoria;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Auditoria {
  
  @Id
  @GeneratedValue
  private Long id;
  
  private String auditer;
  
  @OneToMany
  @JoinColumn(name = "auditoria_id")
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
