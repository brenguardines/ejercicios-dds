package domain.models.entities.actores.reputaciones;

import domain.models.entities.trabajos.Calificacion;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("BUENA")
@Table(name = "reputacion_buena")
public class ReputacionBuena extends Reputacion{
  @Column
  private String cuatro;
  @Override
  public void recibirCalificacion(Calificacion calificacion) {
    //TODO
  }
}
