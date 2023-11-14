import java.util.ArrayList;

public class ArrayElevator extends Elevator{
    public ArrayElevator(Floor floor, int capacity) {
        super(floor , capacity);
        passengers =  new ArrayList<>(capacity);
    }
}
