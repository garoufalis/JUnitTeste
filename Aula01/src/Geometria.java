import java.util.ArrayList;
public class Geometria {
    public static void main(String[]args) {
        ArrayList<Figura> figuras = new ArrayList<>();
        figuras.add(new Circulo("Circulo",5.00, 0));
        figuras.add(new Triangulo("Triangulo",10.00,5.00));
        figuras.add(new Losango("Losango",10.00,5.00));
        figuras.add(new All("Quadrado",5.00,2.00));
        figuras.add(new All("Retangulo",5.00,3.00));
        figuras.add(new Trapezio("Trapezio",5.00,3.00,2.00,2.00,2.00));
        figuras.add(new Cubo("Cubo",5.00,5.00));
        figuras.add(new Esfera("Esfera",5.00,5.00));
        figuras.add(new Piramide("Piramide",5.00,5.00));
        figuras.add(new Cilindro("Cilindro",5.00,5.00,10.00));
        
        for(Figura fig:figuras) {
            System.out.println(fig.getFigura());
            System.out.println(fig.area());
            System.out.println(fig.perimetro());
            System.out.println(fig.volume());
            if(fig instanceof Diagonal)
            System.out.println(((Diagonal)fig).diagonal());
        }
    }
}
