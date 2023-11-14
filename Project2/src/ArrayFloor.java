import java.util.ArrayList;

public class ArrayFloor extends Floor{
    public ArrayFloor(int number, int maxFloor, double passengerProbability) {
        super(number, maxFloor, passengerProbability);
        upPassengers = new ArrayList<>();
        downPassengers = new ArrayList<>();
    }
}
