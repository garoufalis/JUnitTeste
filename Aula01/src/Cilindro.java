
public class Cilindro extends Circulo{
	private double altura;
	public Cilindro(String figura, double raio, double base, double altura) {
		super(figura, raio, base);			
		this.altura = altura;
	}
	
	public double getAltura(){
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	
	@Override
	public double volume(){
		return getRaio() * getAltura();
	}
}
