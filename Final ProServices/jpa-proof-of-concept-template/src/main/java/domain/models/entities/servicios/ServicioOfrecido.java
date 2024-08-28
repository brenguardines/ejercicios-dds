package domain.models.entities.servicios;

import domain.models.entities.actores.Prestador;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "servicio_ofrecido")
public class ServicioOfrecido {
  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  @JoinColumn(name = "prestador_id")
  private Prestador prestador;

  @ManyToOne
  @JoinColumn(name = "servicio_id")
  private Servicio servicio;

  @Column(name = "experiencias", columnDefinition = "TEXT")
  private String experiencias;

  @ElementCollection
  @CollectionTable(name = "servicio_ofrecido_foto", joinColumns = @JoinColumn(name = "servicioOfrecido_id"))
  @Column(name = "foto")
  private List<String> fotos;
}
