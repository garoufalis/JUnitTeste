
public class Esfera extends Circulo{
	
	public Esfera(String figura, double raio, double base) {
		super(figura, raio, base);
		
	}
	@Override
	public double volume(){
		return (4 * Math.PI * Math.pow(getRaio(), 3) / 3);
	}

}
