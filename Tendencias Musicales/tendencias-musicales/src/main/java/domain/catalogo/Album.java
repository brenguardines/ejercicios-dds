package domain.catalogo;

import lombok.Getter;
import lombok.Setter;

public class Album {
  @Getter
  @Setter
  private String nombre;

  @Getter
  @Setter
  private Integer anio;
}
