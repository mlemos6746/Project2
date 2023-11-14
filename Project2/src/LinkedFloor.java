import java.util.LinkedList;

public class LinkedFloor extends Floor{
    public LinkedFloor(int number, int maxFloor, double passengerProbability) {
        super(number,maxFloor, passengerProbability);
        upPassengers = new LinkedList<>();
        downPassengers = new LinkedList<>();
    }
}
