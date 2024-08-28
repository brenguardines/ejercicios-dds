package domain.models.entities.servicios;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "servicio")
public class Servicio {
  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "nombre", nullable = false)
  //nullable = false significa que no puede ser null las filas de esta columna
  private String nombre;

  @Column(name = "descripcion", columnDefinition = "TEXT")
  //Por defecto el String es un VARCHAR(255) si quiero cambiar el tipo lo hago con columnDefinition
  private String descripcion;

  @Column(name = "icono")
  private String icono;

  @OneToMany
  @JoinColumn(name = "servicio_id")
  private List<Tarea> tareas;

  public Servicio(){
    this.tareas = new ArrayList<>();
  }

}
