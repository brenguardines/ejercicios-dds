package domain.models.entities.servicios;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tarea {
  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "descripcion", columnDefinition = "TEXT")
  private String descripcion;

  @Override
  public String toString(){
    return "Tarea id: " + this.id + ", descripcion: " + this.descripcion;
  }

}
