package utn.dds.persistencia.futbol.persistence;

import utn.dds.persistencia.futbol.persistence.auditoria.Auditable;
import utn.dds.persistencia.futbol.persistence.tienda.Producto;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Equipo extends Auditable implements Competitivo {

  private String nombre;
  private Long cantidadAfiliados;

  @Enumerated(EnumType.ORDINAL)
  @Column(name = "codigo_liga")
  private Liga liga;

  @OneToMany
  @JoinColumn(name = "equipo_id")
  private List<Producto> productosEnTienda;

  private Date ultimaModificacion;

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Long getCantidadAfiliados() {
    return cantidadAfiliados;
  }

  public void setCantidadAfiliados(Long cantidadAfiliados) {
    this.cantidadAfiliados = cantidadAfiliados;
  }


  @Override
  public Date getUltimaModificacion() {
    return ultimaModificacion;
  }

  @Override
  public boolean esSospechoso() {
    // TODO
    return false;
  }

  @Override
  public boolean esDeAltoRendimiento() {
    return cantidadAfiliados > 10000;
  }
}
