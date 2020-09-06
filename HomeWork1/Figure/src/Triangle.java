public class Triangle extends Figure {
    private static final String NAME = "Triangle";
    private double a,b,c;

    @Override
    public double getArea(){
        double poluPeriment = (a + b + c)/2;
        double area = Math.sqrt(poluPeriment * (poluPeriment - a)*(poluPeriment - b)*(poluPeriment-c));
        return area;
    }

    @Override
    public String getName() {
        return NAME;
    }
    public Triangle(double a,double b,double c) {
        this.a = a;
        this.b=b;
        this.c=c;
    }

}
