
public class All extends Poligono implements Diagonal{
	
	public All(String figura, double base, double altura) {
		super(figura, base, altura);

	}

	@Override
	public double diagonal(){
		return Math.sqrt(Math.pow(getBase(), 2)+Math.pow(getAltura(), 2));
		
	}
	
	@Override
	public double perimetro(){
		return 2 * (getAltura() + getBase());
		
	}
	
}