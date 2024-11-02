package domain.models.repositories;

import domain.models.entities.servicios.Servicio;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.util.List;
import java.util.Optional;

public class RepositorioDeServicios implements WithSimplePersistenceUnit {

  public void guardar(Servicio servicio){
    entityManager().persist(servicio); //El entityManager es el intermediario entre mundo objetos y mundo datos
  }

  public void modificar(Servicio servicio){
    entityManager().merge(servicio);
  }

  /*
  public void eliminar(Servicio servicio){
    //BAJA LOGICA //Si utilizo esto, el buscarTodos y el resto van a tener una condicion de que esten en true
    servicio.setActivo(false);
    entityManager().merge(servicio);
  }
  */


  public void eliminarFisico(Servicio servicio){
    entityManager().remove(servicio);
  }

  //Opcion sin Optional
  /*
  public Servicio buscarPorId(Long id){
    return entityManager().find(Servicio.class, id);
  }
   */

  //Opcion con Optional
  public Optional<Servicio> buscarPorId(Long id){
    return Optional.ofNullable(entityManager().find(Servicio.class, id));
  }

  @SuppressWarnings("unchecked")
  public List<Servicio> buscarTodos(){
    return entityManager()
        .createQuery("from " + Servicio.class.getName())
        .getResultList();
  }

  @SuppressWarnings("unchecked")
  public List<Servicio> buscarPorNombre(String nombre){
    return entityManager()
        .createQuery("from " + Servicio.class.getName() + " where nombre = :name")
        .setParameter("name", nombre)
        .getResultList();
  }
}
