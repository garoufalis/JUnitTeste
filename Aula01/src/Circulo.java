
public class Circulo extends Figura {
	
	private double raio;
	public Circulo(String figura, double raio, double base) {
		super(figura);
		this.raio = raio;
	}
	

	public double getRaio(){
		return raio;
	}
	public void setRaio(double raio) {
		this.raio = raio;
	}
	
	@Override
	public double area() {
		return (2 * raio) * Math.PI;
	}
	
	@Override
	public double perimetro(){
		return (2 * Math.PI) * getRaio();
	}

	@Override
	public double volume() {
		return 0;
	}
		
}
