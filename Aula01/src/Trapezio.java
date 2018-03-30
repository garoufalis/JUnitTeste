
public class Trapezio extends Poligono{
	private double l1, l2, base2;
	public Trapezio(String figura, double base, double altura, double l1, double l2, double base2) {
		super(figura, base, altura);
		this.l1 = l1;
		this.l2 = l2;
		this.base2 = base2;
	}

	public double getl1() {
		return l1;
	}
	
	public void setl1(double l1) {
		this.l1 = l1;
	}
	
	public double getl2() {
		return l2;
	}
	
	public void setl2(double l2) {
		this.l2 = l2;
	}
	
	public double getBase2() {
		return base2;
	}
	
	public void setBase2(double base2) {
		this.base2 = base2;
	}

	@Override
	public double area() {
		return ((getBase() + base2) * getAltura()) / 2;
	}
	
	@Override
	public double perimetro() {
		return getBase() + base2 + l1 + l2;
	}


	
}
