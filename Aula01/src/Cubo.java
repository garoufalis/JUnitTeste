
public class Cubo extends Poligono{
	
	public Cubo(String figura, double altura, double base) {
		super(figura, altura, base);
		
	}
	
	@Override
	public double volume(){
		return getBase()*getBase()*getBase();
	}

}