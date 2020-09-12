package utn.dds.persistencia.futbol.persistence.difusion;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import utn.dds.persistencia.futbol.persistence.Partido;

public enum Difusion {
  
  TVPublica {
    @Override
    public void iniciarDifusion(Partido partido) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void finalizarDifusion(Partido partido) {
      // TODO Auto-generated method stub
      
    }
  }, PagarParaVer {
    @Override
    public void iniciarDifusion(Partido partido) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void finalizarDifusion(Partido partido) {
      // TODO Auto-generated method stub
      
    }
  }, SinDifusion {
    @Override
    public void iniciarDifusion(Partido partido) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void finalizarDifusion(Partido partido) {
      // TODO Auto-generated method stub
      
    }
  };
  
  public abstract void iniciarDifusion(Partido partido);
  public abstract void finalizarDifusion(Partido partido);

}



