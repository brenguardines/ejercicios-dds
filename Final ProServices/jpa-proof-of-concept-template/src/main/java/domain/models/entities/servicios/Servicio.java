package domain.models.entities.servicios;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collections;
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

  @OneToMany(fetch = FetchType.EAGER ,cascade = {CascadeType.PERSIST, CascadeType.MERGE}) //FetchType.EAGER trae tod o el objeto junto, todas las tareas, mientras que lazy trae a demanda
  @JoinColumn(name = "servicio_id") //Si no se pone el JoinColumn, el ORM por defecto pone ManyToMany
  //La tabla tarea es la que va a tener una columna llamada servicio_id y la cual es FK
  private List<Tarea> tareas;

  //Caso de Desnormalización forzada por performance
  @Column
  private Integer cantDeTareas;

  public Servicio(){
    this.tareas = new ArrayList<>();
  }

  public void agregarTareas(Tarea ... tareas){
    Collections.addAll(this.tareas, tareas);

    //Caso de Desnormalización forzada por performance
    this.cantDeTareas = this.tareas.size();
  }

  @Override
  public String toString(){
    return "Servicio id: " + this.id + ", nombre: " + this.nombre;
  }

}
