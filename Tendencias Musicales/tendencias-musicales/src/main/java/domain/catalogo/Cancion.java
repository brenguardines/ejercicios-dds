package domain.catalogo;

import domain.popularidades.Normal;
import domain.popularidades.Popularidad;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


public class Cancion {

  @Getter
  @Setter
  private String titulo;

  @Getter
  @Setter
  private Integer anio;

  @Getter
  @Setter
  private Integer cantLikes;

  @Getter
  @Setter
  private Integer cantDislikes;

  @Getter
  private LocalDateTime ultVezReproducida;

  @Getter
  private Integer cantReproducciones;

  @Getter
  @Setter
  private Artista artista;

  @Getter
  @Setter
  private Album album;

  @Getter
  @Setter
  private Popularidad popularidad;

  public Cancion() {
    this.cantLikes = 0;
    this.cantDislikes = 0;
    this.cantReproducciones = 0;
    this.popularidad = new Normal(this.cantReproducciones);
  }

  public void cambiarPopularidad(Popularidad popularidad){
    this.popularidad = popularidad;
  }

  private void reproducir(){
    this.cantReproducciones++;
    this.popularidad.reproducir(this);
    this.ultVezReproducida = LocalDateTime.now();
  }

  private String detalleCompleto(){
    return this.popularidad.detalle(this);
  }

  public String serEscuchada(){
    this.reproducir();
    return this.detalleCompleto();
  }

  public void recibirLike(){
    this.cantLikes++;
  }

  public void recibirDislike(){
    this.cantDislikes++;
    this.popularidad.recibirDislike();
  }
}
