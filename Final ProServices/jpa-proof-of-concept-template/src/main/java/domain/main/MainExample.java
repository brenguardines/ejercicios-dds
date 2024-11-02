package domain.main;

import domain.models.entities.servicios.Servicio;
import domain.models.entities.servicios.Tarea;
import domain.models.repositories.RepositorioDeServicios;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import java.util.List;
import java.util.Optional;


public class MainExample implements WithSimplePersistenceUnit {
  private RepositorioDeServicios repositorioDeServicios;

  public static void main(String[] args) {
    MainExample instance = new MainExample();
    instance.repositorioDeServicios = new RepositorioDeServicios();

    //instance.inicializar();
    instance.guardarServicios();
    instance.agregarTareasAServicios();
    instance.recuperarServiciosYTareas();
    //instance.recuperarServicios();
    //instance.actualizarNombresDeServicios();
    //instance.agregarTareasAServicios();
  }

  /*
  private void inicializar(){
    withTransaction(() -> {

    });
  }
  */

  private void guardarServicios(){
    Servicio servicio1 = new Servicio();
    servicio1.setNombre("Abogacia");

    Servicio servicio2 = new Servicio();
    servicio2.setNombre("Ingenieria en Sistemas");

    /*
    beginTransaction();
    this.repositorioDeServicios.guardar(servicio1);
    this.repositorioDeServicios.guardar(servicio2);
    commitTransaction();
    */

    withTransaction(() -> {
      this.repositorioDeServicios.guardar(servicio1);
      this.repositorioDeServicios.guardar(servicio2);
    });

  }

  private void recuperarServicios(){
    /*
    Servicio servicio1 = this.repositorioDeServicios.buscarPorId((1L));

    if(servicio1 != null){
      System.out.println(servicio1);
    }
     */

    Optional<Servicio> posibleServicio1 = this.repositorioDeServicios.buscarPorId(1L);

    if(posibleServicio1.isPresent()){
      Servicio servicio1 = posibleServicio1.get();
      System.out.println(servicio1);
    }

    List<Servicio> servicios = this.repositorioDeServicios.buscarPorNombre("Ingenieria en Sistemas");

    if(!servicios.isEmpty()){
      Servicio servicio2 = servicios.get(0);
      System.out.println(servicio2);
    }

    List<Servicio> todosLosServicios = this.repositorioDeServicios.buscarTodos();
    System.out.println(todosLosServicios);
  }

  private void actualizarNombresDeServicios(){
    Optional<Servicio> posibleServicio1 = this.repositorioDeServicios.buscarPorId(1L);
    Optional<Servicio> posibleServicio2 = this.repositorioDeServicios.buscarPorId(2L);

    withTransaction(() -> {
      if(posibleServicio1.isPresent()){
        Servicio servicio1 = posibleServicio1.get();
        servicio1.setNombre("Abogacía");

        this.repositorioDeServicios.modificar(servicio1);
      }

      if(posibleServicio2.isPresent()){
        Servicio servicio2 = posibleServicio2.get();
        servicio2.setNombre("Ing. en Sistemas");

        this.repositorioDeServicios.modificar(servicio2);
      }
    });
  }

  private void agregarTareasAServicios(){
    Optional<Servicio> posibleServicio1 = this.repositorioDeServicios.buscarPorId(1L);
    Optional<Servicio> posibleServicio2 = this.repositorioDeServicios.buscarPorId(2L);

    withTransaction(() -> {
      if(posibleServicio1.isPresent()){
        Servicio servicio1 = posibleServicio1.get();

        servicio1.agregarTareas(
            Tarea.builder().descripcion("Lectura de caso").build(),
            Tarea.builder().descripcion("Presentacion judicial").build()
        );

        this.repositorioDeServicios.modificar(servicio1);
      }

      if(posibleServicio2.isPresent()){
        Servicio servicio2 = posibleServicio2.get();

        servicio2.agregarTareas(
            Tarea.builder().descripcion("Testing de la aplicacion").build(),
            Tarea.builder().descripcion("Diseño de modelo de datos").build()
        );

        this.repositorioDeServicios.modificar(servicio2);
      }
    });
  }

  private void recuperarServiciosYTareas(){
    List<Servicio> servicios = this.repositorioDeServicios.buscarTodos();

    servicios.forEach(s -> {
      System.out.println(s);
      System.out.println(s.getTareas());
    });
  }
}
