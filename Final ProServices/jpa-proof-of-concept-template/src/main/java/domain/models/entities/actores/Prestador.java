package domain.models.entities.actores;

import domain.converters.MedioDeNotificacionAttributeConverter;
import domain.models.entities.actores.reputaciones.Reputacion;
import domain.models.entities.mediosDeNotificacion.IMedioDeNotificacion;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "prestador")
public class Prestador {
  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "radioCoberturaEnKm")
  private Double radioCoberturaEnKm;

  @OneToMany(mappedBy = "prestador") //mappedBy va cuando utilizo una relacion bidireccional
  //@OneToMany(mappedBy = "prestador", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
  //@OrderBy("dia ASC")
  private List<Disponibilidad> disponibilidades;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "apellido")
  private String apellido;

  @Column(name = "foto")
  private String foto;

  @Column(name = "fechaNacimiento", columnDefinition = "DATE")
  private LocalDate fechaNacimiento;

  @Enumerated(EnumType.STRING)
  private TipoDocumento tipoDocumento;

  @Column(name = "nroDocumento")
  private String nroDocumento;

  @Column(name = "cuitCuil")
  private String cuitCuil;

  @ElementCollection
  @CollectionTable(name = "prestador_telefono", joinColumns = @JoinColumn(name = "prestador_id", referencedColumnName = "id"))
  @Column(name = "telefono")
  private List<String> telefonos;

  @ElementCollection
  @CollectionTable(name = "prestador_email", joinColumns = @JoinColumn(name = "prestador_id", referencedColumnName = "id"))
  @Column(name = "email")
  private List<String> emails;

  @OneToOne
  @JoinColumn(name = "reputacion_id")
  private Reputacion reputacion;

  //@Transient
  @Convert(converter = MedioDeNotificacionAttributeConverter.class)
  @Column(name = "medioDeNotificacion")
  private IMedioDeNotificacion medioDeNotificacion;

  public Prestador(){
    this.disponibilidades = new ArrayList<>();
  }

  public void agregarDisponibilidad(Disponibilidad disponibilidad){
    this.disponibilidades.add(disponibilidad);
    disponibilidad.setPrestador(this);
  }
}
