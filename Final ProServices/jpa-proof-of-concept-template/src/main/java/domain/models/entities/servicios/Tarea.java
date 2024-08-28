package domain.models.entities.servicios;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "tarea")
public class Tarea {
  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "descripcion", columnDefinition = "TEXT")
  private String descripcion;

}
