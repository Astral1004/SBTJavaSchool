public class Car {
    private Type type;
    private String nameOfTheCar;

    public Car() {
    }

    public Car(Type type, String nameOfTheCar) {
        this.type = type;
        this.nameOfTheCar = nameOfTheCar;
    }

    public Type getType() {
        return type;
    }

    public String getNameOfTheCar() {
        return nameOfTheCar;
    }

    @Override
    public String toString() {
        return ""+getType();
    }
}
