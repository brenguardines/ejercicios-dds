package domain.popularidades;

import domain.catalogo.Cancion;
import domain.helpers.Icono;

public class Normal extends Popularidad{

  public static Integer cantMaxReproduccionesTendenciaNormal = 1000;
  private Integer cantReproduccionesIniciales;

  public Normal(Integer cantReproduccionesIniciales) {
    this.cantReproduccionesIniciales = cantReproduccionesIniciales;
  }

  @Override
  public void reproducir(Cancion cancion) {
    if(this.superaCantReproducciones(cancion)){
      cancion.cambiarPopularidad(new EnAuge(cancion.getCantReproducciones()));
    }
  }

  private boolean superaCantReproducciones(Cancion cancion) {
    return this.cantReproduccionesEnEstaPopularidad(cancion) > cantMaxReproduccionesTendenciaNormal;
  }

  private Integer cantReproduccionesEnEstaPopularidad(Cancion cancion) {
    return cancion.getCantReproducciones() - this.cantReproduccionesIniciales;
  }

  @Override
  protected String icono() {
    return Icono.MUSICAL_NOTE.texto();
  }
  @Override
  protected String leyenda(Cancion cancion) {
    return armarLeyendaPara(cancion);
  }

  public static String armarLeyendaPara(Cancion cancion){
    return String.format(" %S - %S - %S",
        cancion.getArtista().getNombre(),
        cancion.getAlbum().getNombre(),
        cancion.getTitulo());
  }

}
