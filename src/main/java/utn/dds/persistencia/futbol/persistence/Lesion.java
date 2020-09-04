package utn.dds.persistencia.futbol.persistence;

import java.util.Date;

public class Lesion {
  
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
