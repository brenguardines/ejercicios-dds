package domain.models.entities.actores.reputaciones;

import domain.models.entities.trabajos.Calificacion;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("MALA")
@Table(name = "reputacion_mala")
public class ReputacionMala extends Reputacion{
  @Column
  private String tres;
  @Override
  public void recibirCalificacion(Calificacion calificacion) {
    //TODO
  }
}