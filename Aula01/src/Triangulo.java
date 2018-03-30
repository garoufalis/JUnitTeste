
public class Triangulo extends Poligono {
	public Triangulo(String figura, double base, double altura) {
		super(figura, base, altura);
	}
	
	@Override
	public double perimetro(){
		return getAltura() + getAltura() + getBase();
		
	}
}
