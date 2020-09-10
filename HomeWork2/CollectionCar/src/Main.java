import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
        List<Car> lisCarsType = new ArrayList<>();
        lisCarsType.add(new Car(new Type("KAI A5"), "Седан"));
        lisCarsType.add(new Car(new Type("Audi A3 Sportback"), "Хэтчбек"));
        lisCarsType.add(new Car(new Type("AUDI S6"), "Седан"));
        lisCarsType.add(new Car(new Type("Hyundai Elantra"), "Седан"));
        lisCarsType.add(new Car(new Type("Renault Talisman Estate"), "Универсал"));
        lisCarsType.add(new Car(new Type("Lada Granta Cross"), "Универсал"));
        lisCarsType.add(new Car(new Type("Chevrolet Spark"), "Хэтчбек"));

        Map<String,List<Car>> CarsMap = lisCarsType.stream().collect(Collectors.groupingBy(Car::getNameOfTheCar));


        System.out.println(CarsMap);
    }
}


