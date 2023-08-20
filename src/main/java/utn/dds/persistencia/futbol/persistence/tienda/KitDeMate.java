package utn.dds.persistencia.futbol.persistence.tienda;

public class KitDeMate extends Producto {

  private Material material;
  private boolean incluyeFunda;

  public Material getMaterial() {
    return material;
  }

  public boolean getIncluyeFunda() {
    return incluyeFunda;
  }

  public void setMaterial(Material material) {
    this.material = material;
  }

  public void setIncluyeFunda(boolean incluyeFunda) {
    this.incluyeFunda = incluyeFunda;
  }


}
