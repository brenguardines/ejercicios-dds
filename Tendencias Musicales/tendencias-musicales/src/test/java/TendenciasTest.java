import domain.catalogo.*;

import domain.popularidades.EnAuge;
import domain.popularidades.EnTendencia;
import domain.popularidades.Normal;
import domain.popularidades.Popularidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TendenciasTest {
  private Cancion cancion;
  private Artista artista;
  private Album album;

  @BeforeEach
  public void init(){
    this.artista = new Artista();
    this.artista.setNombre("Coldplay");

    this.album = new Album();
    this.album.setNombre("A Rush of Blood to the head");
    this.album.setAnio(2002);

    this.cancion = new Cancion();
    this.cancion.setTitulo("The Scientist");
    this.cancion.setArtista(this.artista);
    this.cancion.setAlbum(this.album);
    this.cancion.setAnio(2002);

    Normal.cantMaxReproduccionesTendenciaNormal = 2;
    EnAuge.cantMaxReproduccionesEnAuge = 3;
    EnAuge.cantMaxLikesEsperados = 3;
    EnAuge.cantMaxDislikesSoportados = 5;
    EnTendencia.cantHorasSinEscucharParaBajarPopularidad = 24;
  }

  @Test
  @DisplayName("“The Scientist” recién se lanza (tiene popularidad normal).")
  public void cancionMuestraDetalleDeTendenciaNormal(){
    String detalle = this.cancion.serEscuchada();

    Assertions.assertTrue(detalle.contains(Normal.armarLeyendaPara(this.cancion)));
    Assertions.assertEquals(1, this.cancion.getCantReproducciones());
  }
}
