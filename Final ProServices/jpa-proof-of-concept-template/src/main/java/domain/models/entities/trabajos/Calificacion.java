package domain.models.entities.trabajos;

import domain.models.entities.Persistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "trabajo_calificacion")
public class Calificacion extends Persistente {
  @OneToOne
  @JoinColumn(name = "trabajo_id", referencedColumnName = "id")
  private Trabajo trabajo;

  @Column(name = "opinionLibre", columnDefinition = "TEXT")
  private String opinionLibre;

  @Column(name = "puntaje")
  private int puntaje; //Se pone puntaje y no estrellas ya que el dia de mañana puede cambiar de estrellas a triangulos
}
