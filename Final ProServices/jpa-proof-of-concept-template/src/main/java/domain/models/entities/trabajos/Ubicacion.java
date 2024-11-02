package domain.models.entities.trabajos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable //Lo uso para no crear la tabla
@Setter
@Getter
public class Ubicacion {
  @Column
  private String calle;
  @Column
  private String altura;
  @Column
  private String localidad;
  @Column
  private String provincia;
}
