package domain.models.entities.trabajos;

import domain.models.entities.Persistente;
import domain.models.entities.actores.Consumidor;
import domain.models.entities.servicios.ServicioOfrecido;
import domain.models.entities.servicios.Tarea;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Entity
@Table(name = "trabajo")
public class Trabajo extends Persistente {

  @ManyToOne
  @JoinColumn(name = "consumidor_id", referencedColumnName = "id")
  private Consumidor consumidor;

  @ManyToOne
  @JoinColumn(name = "servicioOfrecido_id", referencedColumnName = "id")
  private ServicioOfrecido servicioOfrecido;

  @Column(name = "fechaARealizar", columnDefinition = "DATE")
  private LocalDate fechaARealizar;

  @Column(name = "fechaAlta", columnDefinition = "DATE")
  private LocalDate fechaAlta;

  //@Transient //Para que no le de bola al atributo, para que no lo persista
  @Embedded
  private Ubicacion ubicacion;

  @Column(name = "horaIncio", columnDefinition = "TIME")
  private LocalTime horaIncio;

  @Column(name = "horaFin", columnDefinition = "TIME")
  private LocalTime horaFin;

  @ManyToMany
  @JoinTable(
      name = "trabajo_tarea",
      joinColumns = @JoinColumn(name = "trabajo_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "tarea_id", referencedColumnName = "id")
  )
  private List<Tarea> tareas;

  @Column(name = "finalizadosSegunConsumidor")
  private Boolean finalizadosSegunConsumidor;

  @Column(name = "finalizadosSegunPrestador")
  private Boolean finalizadosSegunPrestador;

  //Caso de Desnormalización por consistencia de datos (para no perder referencia del dato que me importa)
  @Column
  private Float precioDeContratacion;
}
