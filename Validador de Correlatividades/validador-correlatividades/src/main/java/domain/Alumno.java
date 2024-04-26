package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alumno {
  private String nombre;
  private String apellido;
  private Integer nroLegajo;
  private List<Materia> materiasAprobadas;

  public Alumno(String nombre, String apellido, Integer nroLegajo) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.nroLegajo = nroLegajo;
    this.materiasAprobadas = new ArrayList<>();
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Integer getNroLegajo() {
    return nroLegajo;
  }

  public void setNroLegajo(Integer nroLegajo) {
    this.nroLegajo = nroLegajo;
  }

  public List<Materia> getMateriasAprobadas() {
    return materiasAprobadas;
  }

  public void agregarMateriaAprobada(Materia ... materias){
    Collections.addAll(this.materiasAprobadas, materias);
  }

  public boolean tieneMateriaAprobada(Materia unaMateria){
    return materiasAprobadas.contains(unaMateria);
  }

  public boolean cumpleRequisitoCorrelativa(Materia unaMateria) {
    return unaMateria.getMateriasCorrelativas().stream().allMatch(m -> this.tieneMateriaAprobada(m));
  }
}
