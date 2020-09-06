public class Square extends Figure {
    private double a;
    private static final String NAME = "Square";
    public Square(double a){
        this.a = a;
    }

    @Override
    public double getArea() {
        double area = a * a;
        return area;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
