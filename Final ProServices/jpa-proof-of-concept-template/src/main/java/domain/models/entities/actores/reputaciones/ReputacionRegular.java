package domain.models.entities.actores.reputaciones;

import domain.models.entities.trabajos.Calificacion;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("REGULAR")
@Table(name = "reputacion_regular")
public class ReputacionRegular extends Reputacion{
  @Column
  private String dos;
  @Override
  public void recibirCalificacion(Calificacion calificacion) {
    //TODO
  }
}