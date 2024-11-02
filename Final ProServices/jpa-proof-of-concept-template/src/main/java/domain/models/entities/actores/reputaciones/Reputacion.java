package domain.models.entities.actores.reputaciones;

import domain.models.entities.Persistente;
import domain.models.entities.trabajos.Calificacion;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
/*
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //SINGLE_TABLE genera una Unica Tabla
@DiscriminatorColumn(name = "tipo") //Columna para representar las instancias de las clases (Buena-Mala-Regular)
*/
@Inheritance(strategy = InheritanceType.JOINED) //JOINED genera una tabla por la clase padre y una tabla por cada clase hija
@Table(name = "reputacion")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //TABLE_PER_CLASS genera una unica tabla por cada clase hija
public abstract class Reputacion extends Persistente {

  @Column
  private String uno;

  public abstract void recibirCalificacion(Calificacion calificacion);
}
