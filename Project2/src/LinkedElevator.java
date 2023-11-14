import java.util.LinkedList;

public class LinkedElevator extends Elevator{
    public LinkedElevator(Floor floor, int capacity) {
        super(floor, capacity);
        passengers = new LinkedList<>();

    }
}
