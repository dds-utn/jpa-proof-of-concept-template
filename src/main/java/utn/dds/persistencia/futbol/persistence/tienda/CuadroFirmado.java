package utn.dds.persistencia.futbol.persistence.tienda;

public class CuadroFirmado extends Producto {

  private String firmante;
  private boolean conMarco;

  public String getFirmante() {
    return firmante;
  }

  public boolean getConMarco() {
    return conMarco;
  }

  public void setFirmante(String firmante) {
    this.firmante = firmante;
  }

  public void setConMarco(boolean conMarco) {
    this.conMarco = conMarco;
  }


}
