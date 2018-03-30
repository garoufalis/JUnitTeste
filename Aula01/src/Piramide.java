public class Piramide extends Triangulo{
    public Piramide(String figura,double base,double altura) {
        super(figura,base,altura);
    }
    
    @Override
    public double volume() {
        return (Math.pow(getBase(),2)*getAltura())/3;
    }
}
