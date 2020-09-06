public class Main {
    public static void main(String[] args) {
        Figure[] figure = {new Rect(8, 12),
                new Square(9),
                new Triangle(5, 8, 5),
                new Circle(10)};

        for(Figure fig : figure)
            System.out.println(fig.getName() + ": Площадь = " + fig.getArea());
    }
}
