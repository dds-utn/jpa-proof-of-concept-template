package utn.dds.persistencia.futbol.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Lesion {

  @Id
  @GeneratedValue
  private Long id;
  private Date fecha;
  private String descripción;
 
  
  public Lesion(Date fecha, String descripción) { 
    this.fecha = fecha;
    this.descripción = descripción;
  }
  
  public Date getFecha() {
    return fecha;
  }
  
  public String getDescripción() {
    return descripción;
  }
  
    
  

}
