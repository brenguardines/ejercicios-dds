package domain.popularidades;

import domain.catalogo.Cancion;
import domain.helpers.Icono;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class EnTendencia extends Popularidad{
  public static Integer cantHorasSinEscucharParaBajarPopularidad = 24;
  @Setter
  private LocalDateTime fechaAComprar;

  public LocalDateTime getFechaAComprar(){
    return fechaAComprar == null ? LocalDateTime.now() : this.fechaAComprar;
  }
  @Override
  public void reproducir(Cancion cancion) {
    if(this.hanPasadoMasDeHSDesde(cancion.getUltVezReproducida(), cantHorasSinEscucharParaBajarPopularidad)){
      cancion.cambiarPopularidad(new Normal(cancion.getCantReproducciones()));
    }
  }

  private Boolean hanPasadoMasDeHSDesde(LocalDateTime fechaHora, Integer horas){
    return this.getFechaAComprar().minusHours(horas).isAfter(fechaHora);
  }

  @Override
  protected String icono() {
    return Icono.FIRE.texto();
  }

  @Override
  protected String leyenda(Cancion cancion) {
    return armarLeyendaPara(cancion);
  }

  public static String armarLeyendaPara(Cancion cancion){
    return String.format(" %S - %S - (%S- %d)",
        cancion.getTitulo(),
        cancion.getArtista().getNombre(),
        cancion.getAlbum().getNombre(),
        cancion.getAnio());
  }

}