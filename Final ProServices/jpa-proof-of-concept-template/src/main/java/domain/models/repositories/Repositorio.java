package domain.models.repositories;

import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.util.List;

public class Repositorio implements WithSimplePersistenceUnit {

  public void guardar(Object o){
    entityManager().persist(o);
  }

  public List<Object> buscarTodos(String nombreDeClase){
    return entityManager()
        .createQuery("from " + nombreDeClase)
        .getResultList();
  }
}
