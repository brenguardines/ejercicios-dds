package domain;

import org.junit.Assert;
import org.junit.Test;

public class InscripcionTest {
  Materia algoritmos;
  Materia paradigmas;
  Materia analisisDeSistemas;
  Materia disenio;
  @Test
  public void unAlumnoSePuedeAnotarseADisenio(){
    Alumno unAlumno = new Alumno("Brenda", "Guardines", 1234567);
    Inscripcion unaIncripcion = new Inscripcion();
    algoritmos = new Materia("Algoritmos y Estructuras de Datos", 12345);
    analisisDeSistemas = new Materia("Analisis de Sistemas", 23456);
    paradigmas = new Materia("Paradigmas de Programacion", 34567);

    disenio = new Materia("Diseño de Sistemas", 45678);

    unAlumno.agregarMateriaAprobada(algoritmos,analisisDeSistemas,paradigmas);
    paradigmas.agregarMateriaCorrelativa(algoritmos);
    disenio.agregarMateriaCorrelativa(analisisDeSistemas,paradigmas);
    unaIncripcion.setAlumno(unAlumno);
    unaIncripcion.materiasAAnotarse(disenio);

    Assert.assertTrue(unaIncripcion.aprobada());
  }

  @Test
  public void unAlumnoNoSePuedeAnotarseADisenio(){
    Alumno unAlumno = new Alumno("Brenda", "Guardines", 1234567);
    Inscripcion unaIncripcion = new Inscripcion();
    algoritmos = new Materia("Algoritmos y Estructuras de Datos", 12345);
    paradigmas = new Materia("Paradigmas de Programacion", 34567);

    disenio = new Materia("Diseño de Sistemas", 45678);

    unAlumno.agregarMateriaAprobada(algoritmos,paradigmas);
    paradigmas.agregarMateriaCorrelativa(algoritmos);
    disenio.agregarMateriaCorrelativa(analisisDeSistemas,paradigmas);
    unaIncripcion.setAlumno(unAlumno);
    unaIncripcion.materiasAAnotarse(disenio);

    Assert.assertFalse(unaIncripcion.aprobada());
  }
}
