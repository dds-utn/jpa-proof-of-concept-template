package utn.dds.persistencia.futbol.persistence.difusion;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import utn.dds.persistencia.futbol.persistence.Partido;

@Entity
@DiscriminatorValue("S")
public class SinDifusion extends Difusion {


  @Override
  public void iniciarDifusion(Partido partido) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void finalizarDifusion(Partido partido) {
    // TODO Auto-generated method stub
    
  }

}
