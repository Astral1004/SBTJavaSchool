public class Rect extends Figure {
    private static final String NAME = "Rect";
    private  double a;
    private  double b;

    public Rect(double a, double b){
        this.a = a;
        this.b = b;
    }
    @Override
    public double getArea() {
        double area = a * b;
        return area;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
