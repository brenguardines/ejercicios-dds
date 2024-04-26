package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Materia {
  private String nombre;
  private Integer codigo;
  private List<Materia> materiasCorrelativas;

  public Materia(String nombre, Integer codigo) {
    this.nombre = nombre;
    this.codigo = codigo;
    this.materiasCorrelativas = new ArrayList<>();
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(Integer codigo) {
    this.codigo = codigo;
  }

  public List<Materia> getMateriasCorrelativas() {
    return materiasCorrelativas;
  }

  public void agregarMateriaCorrelativa(Materia ... materias){
    Collections.addAll(this.materiasCorrelativas, materias);
  }

}
