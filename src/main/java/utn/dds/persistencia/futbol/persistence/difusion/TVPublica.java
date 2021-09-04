package utn.dds.persistencia.futbol.persistence.difusion;

import utn.dds.persistencia.futbol.persistence.Partido;

import javax.persistence.Entity;

@Entity
public class TVPublica extends  Difusion {
  
  private String frecuencia;

  @Override
  public void iniciarDifusion(Partido partido) {
    // TODO Auto-generated method stub

  }

  @Override
  public void finalizarDifusion(Partido partido) {
    // TODO Auto-generated method stub

  }

}
