
public abstract class Figura {
	private String figura;
	
	public Figura(String figura) {
		this.figura = figura;
	}

	public String getFigura() {
		return figura;
	}
	
	public void setFigura(String figura) {
		this.figura = figura;
	}
	
	public abstract double area();
	
	public abstract double perimetro();
	
	public abstract double volume();
}
