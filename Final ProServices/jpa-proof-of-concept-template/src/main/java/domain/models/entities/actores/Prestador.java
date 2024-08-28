package domain.models.entities.actores;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "prestador")
public class Prestador {
  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "radioCoberturaEnKm")
  private Double radioCoberturaEnKm;

  @OneToMany(mappedBy = "prestador") //mappedBy va cuando utilizo una relacion bidireccional
  private List<Disponibilidad> disponibilidades;

  public Prestador(){
    this.disponibilidades = new ArrayList<>();
  }

  public void agregarDisponibilidad(Disponibilidad disponibilidad){
    this.disponibilidades.add(disponibilidad);
    disponibilidad.setPrestador(this);
  }
}
