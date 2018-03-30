
public class Poligono extends Figura {
	private double base;
	private double altura;

	public Poligono(String figura, double altura, double base) {
		super(figura);
		this.altura = altura;
		this.base = base; 
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	} 
	
	public double getAltura() {
		return altura;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	
	@Override
	public double area() {
		return getBase()*getAltura();
	}
	
	@Override
	public double perimetro(){
		return 2 * (getAltura() + getBase());
		
	}

	@Override
	public double volume() {
		return 0;
	}

}
