Pendulo p;

int tamanoGrafica = 500;
int colorFondo    = 200;
int colorGrafica  = 100;

int m = 100;

float g   = 9.81;
float tau = TWO_PI;

void setup(){
	size(tamanoGrafica, tamanoGrafica);
	hint(ENABLE_STROKE_PURE);
  stroke(colorGrafica);
  fill(colorGrafica);

  p = new Pendulo(tamanoGrafica/2, tamanoGrafica/2);
}

void draw(){
  background(colorFondo);
  p.animar();
}

class Pendulo{
  PVector coorOrigen;
  PVector coorMasa;
  float r;
  float th;
  float om;
  float al;

  Pendulo(int origenX, int origenY) {
    coorOrigen = new PVector(origenX, origenY);
    r = 1*m;
    th = tau/8;
    om = 0;
    al = 0;
    coorMasa = new PVector(origenX + sin(th), origenY + r*cos(th));
  }

  void dibujar(){
    line(coorOrigen.x, coorOrigen.y, coorMasa.x, coorMasa.y);
    ellipse(coorMasa.x, coorMasa.y, 20, 20);
  }

  void actualizar(){
    al = -1*g*sin(th)/r;
    om += al;
    th += om;
    coorMasa.x = coorOrigen.x + r*sin(th);
    coorMasa.y = coorOrigen.y + r*cos(th);
  }

  void animar(){
    actualizar();
    dibujar();
  }
}