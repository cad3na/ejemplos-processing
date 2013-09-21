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

public class pendulo extends PApplet {

/*
 * Pendulo
 * por Roberto Cadena Vega
 *
 * Crea una animaci\u00f3n de un pendulo.
 */

// Se declara el objeto p de la clase pendulo.
Pendulo p;
// Se declaran variables utiles con respecto al aspecto en pantalla.
int tamanoGrafica = 500;
int colorFondo    = 200;
// Se declaran variables utiles con respecto a la f\u00edsica.
int m = 100;
int f = 60;
float g   = 9.81f;
float tau = TWO_PI;
// Se inicializa el entorno grafico.
public void setup(){
  frameRate(f);                                       // Se actualiza la pantalla 30 veces cada segundo
	size(tamanoGrafica, tamanoGrafica);                 // Se define el tama\u00f1o de pantalla en 500px x 500px
	hint(ENABLE_STROKE_PURE);                           // Se piden trazos limpios
  p = new Pendulo(tamanoGrafica/2, tamanoGrafica/2);  // Se inicializa el pendulo con origen en el centro de la pantalla
}
// Se dibuja el pendulo.
public void draw(){
  background(colorFondo); // El color de fondo es gris claro
  p.animar();             // Se llama a la funci\u00f3n que despliega el siguiente cuadro del pendulo
}
// Se declara la clase Pendulo.
class Pendulo{
  int colorGrafica = color(0xff63AA37);
  PVector coorOrigen;
  PVector coorMasa;
  float r;
  float th;
  float om;
  float al;
  // Se declara el constructor de la clase Pendulo.
  Pendulo(int origenX, int origenY) {
    coorOrigen = new PVector(origenX, origenY);
    r = 2*m;
    th = tau/8;
    om = 0;
    al = 0;
    coorMasa = new PVector(origenX + r*sin(th), origenY + r*cos(th));
  }
  // Se declara la funci\u00f3n que desplegara en pantalla el pendulo.
  public void dibujar(){
    stroke(colorGrafica);
    fill(colorGrafica);
    line(coorOrigen.x, coorOrigen.y, coorMasa.x, coorMasa.y);
    ellipse(coorMasa.x, coorMasa.y, 20, 20);
  }
  // Se declara la funci\u00f3n que actualizar\u00e1 la posici\u00f3n de la masa del pendulo.
  public void actualizar(){
    al = -1*g*sin(th)/(r*f);
    om += al;
    th += om;
    coorMasa.x = coorOrigen.x + r*sin(th);
    coorMasa.y = coorOrigen.y + r*cos(th);
  }
  // Se declara una funci\u00f3n sencilla para llamar, que actualize y despliegue en pantalla al pendulo.
  public void animar(){
    actualizar();
    dibujar();
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--stop-color=#cccccc", "pendulo" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
