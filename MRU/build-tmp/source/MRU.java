import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class MRU extends PApplet {

/*
 * MRU
 * por Roberto Cadena Vega
 *
 * Crea una animaci\u00f3n de una esfera en Movimiento Rectilineo Uniforme.
 */
// Se declara el objeto e de la clase Esfera
Esfera e;
// Se declaran variables utiles con respecto al aspecto en pantalla.
int tamanoGrafica = 500;
int colorFondo    = 200;
int colorGrafica  = 100;
// Se declaran variables utiles con respecto a la f\u00edsica.
int m = 100;
int f = 30;
float g   = 9.81f;
float tau = TWO_PI;
// Se inicializa el entorno grafico.
public void setup(){
  frameRate(f);                                       // Se actualiza la pantalla 30 veces cada segundo
	size(tamanoGrafica, tamanoGrafica);                 // Se define el tama\u00f1o de pantalla en 500px x 500px
	hint(ENABLE_STROKE_PURE);                           // Se piden trazos limpios
  stroke(colorGrafica);                               // El color para las lineas es gris oscuro
  fill(colorGrafica);                                 // El color para el relleno de las figuras es gris oscuro
  e = new Esfera(10, tamanoGrafica/2, 5, 0);
}
// Se dibuja el pendulo.
public void draw(){
  background(colorFondo); // El color de fondo es gris claro
  e.animar();
}
// Se declara la clase Pendulo.
class Esfera{
  PVector coordenada;
  PVector velocidad;
  PVector aceleracion;
  // Se declara el constructor de la clase Pendulo.
  Esfera(int origenX, int origenY, int velocidadX, int velocidadY) {
    coordenada = new PVector(origenX, origenY);
    velocidad = new PVector(velocidadX, velocidadY);
    aceleracion = new PVector(0, 0);
  }
  // Se declara la funci\u00f3n que desplegara en pantalla el pendulo.
  public void dibujar(){
    ellipse(coordenada.x, coordenada.y, 20, 20);
  }
  // Se declara la funci\u00f3n que actualizar\u00e1 la posici\u00f3n de la masa del pendulo.
  public void actualizar(){
    velocidad.x += aceleracion.x;
    velocidad.y += aceleracion.y;
    coordenada.x += velocidad.x;
    coordenada.y += velocidad.y;
    coordenada.x = coordenada.x % tamanoGrafica;
    coordenada.y = coordenada.y % tamanoGrafica;
  }
  // Se declara una funci\u00f3n sencilla para llamar, que actualize y despliegue en pantalla al pendulo.
  public void animar(){
    actualizar();
    dibujar();
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--stop-color=#cccccc", "MRU" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
