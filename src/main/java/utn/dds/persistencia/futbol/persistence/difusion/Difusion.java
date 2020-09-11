package utn.dds.persistencia.futbol.persistence.difusion;

import utn.dds.persistencia.futbol.persistence.Partido;

public interface Difusion {
  
  public void iniciarDifusion(Partido partido);
  public void finalizarDifusion(Partido partido);

}
