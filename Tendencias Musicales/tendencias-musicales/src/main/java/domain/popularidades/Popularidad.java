package domain.popularidades;
import domain.catalogo.Cancion;

public abstract class Popularidad {
  public abstract void reproducir(Cancion cancion);

  public String detalle(Cancion cancion){
    String detalleCompleto = "";
    detalleCompleto += this.icono();
    detalleCompleto += this.leyenda(cancion);
    return detalleCompleto;
  }

  protected abstract String icono();
  protected abstract String leyenda(Cancion cancion);


  public void recibirDislike() {

  }
}
