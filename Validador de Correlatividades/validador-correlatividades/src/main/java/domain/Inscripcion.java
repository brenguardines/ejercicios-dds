package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inscripcion {
  private Alumno alumno;
  private List<Materia> materias;

  public Inscripcion() {
    this.materias = new ArrayList<>();
  }

  public Alumno getAlumno() {
    return alumno;
  }

  public void setAlumno(Alumno alumno) {
    this.alumno = alumno;
  }

  public boolean aprobada(){
    return this.materias.stream().allMatch(m -> this.alumno.cumpleRequisitoCorrelativa(m));
  }

  public void materiasAAnotarse(Materia ... materias){
    Collections.addAll(this.materias, materias);
  }
}
