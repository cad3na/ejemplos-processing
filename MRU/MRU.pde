/*
 * MRU
 * por Roberto Cadena Vega
 *
 * Crea una animación de una esfera en Movimiento Rectilineo Uniforme.
 */

// Se declara el objeto e de la clase Sled
Sled s;
// Se declaran variables utiles con respecto al aspecto en pantalla.
int tamanoGrafica = 500;
int colorFondo    = 200;
// Se declaran variables utiles con respecto a la física.
int m = 100;
int f = 60;
float g   = 9.81;
float tau = TWO_PI;
// Se inicializa el entorno grafico.
void setup(){
  frameRate(f);                                       // Se actualiza la pantalla 30 veces cada segundo
	size(tamanoGrafica, tamanoGrafica);                 // Se define el tamaño de pantalla en 500px x 500px
	hint(ENABLE_STROKE_PURE);                           // Se piden trazos limpios
  s = new Sled(10, tamanoGrafica/2, 3*m/f, 0);
}
// Se dibuja el pendulo.
void draw(){
  background(colorFondo); // El color de fondo es gris claro
  s.animar();
}
// Se declara la clase Pendulo.
class Sled{
  color colorGrafica  = color(#45B3DE);
  PVector coordenada;
  PVector velocidad;
  PVector aceleracion;
  // Se declara el constructor de la clase Pendulo.
  Sled(int origenX, int origenY, int velocidadX, int velocidadY) {
    rectMode(CENTER);
    coordenada  = new PVector(origenX, origenY);
    velocidad   = new PVector(velocidadX, velocidadY);
    aceleracion = new PVector(0, 0);
  }
  // Se declara la función que desplegara en pantalla el pendulo.
  void dibujar(){
    stroke(colorGrafica);
    fill(colorGrafica);
    rect(coordenada.x, coordenada.y, 0.2*m, 0.2*m, 4);
  }
  // Se declara la función que actualizará la posición de la masa del pendulo.
  void actualizar(){
    velocidad.x  += aceleracion.x;
    velocidad.y  += aceleracion.y;
    coordenada.x += velocidad.x;
    coordenada.y += velocidad.y;
    coordenada.x = coordenada.x % tamanoGrafica;
    coordenada.y = coordenada.y % tamanoGrafica;
  }
  // Se declara una función sencilla para llamar, que actualize y despliegue en pantalla al pendulo.
  void animar(){
    actualizar();
    dibujar();
  }
}