package domain.models.entities;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass
public abstract class Persistente {
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE) //Es necesario para la estrategia de JOINED
  private Long id;

  @Column(name = "activo")
  private Boolean activo = true;

}
