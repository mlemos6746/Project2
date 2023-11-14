import java.util.ArrayList;
import java.util.List;

public abstract class Elevator  implements Simulablatable{
    protected List<Passenger> passengers;
    protected int capacity;
    private boolean moving;
    public enum ElevatorDirection {
        DOWN, UP
    }
    private Floor currentFloor;
    private ElevatorDirection direction;

    public Elevator(Floor floor, int capacity) {
        currentFloor = floor;
        this.capacity = capacity;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }


    @Override
    public void clockTick() {
        List<Passenger> unloadedPassengers = new ArrayList<>();
        for (Passenger passenger : passengers) {
            if (passenger.getDestination() == currentFloor.getNumber()) {
                unloadedPassengers.add(passenger);
            }
        }
        passengers.removeAll(unloadedPassengers);


        List<Passenger> boardingPassengers = new ArrayList<>();
        List<Passenger> floorPassengers = currentFloor.getPassengers(direction);
        for (Passenger passenger : floorPassengers) {
            if (passenger.getDirection() == direction) {
                boardingPassengers.add(passenger);
            }
        }
        passengers.addAll(boardingPassengers);
        floorPassengers.removeAll(boardingPassengers);
    }

    public Floor getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(Floor currentFloor) {
        this.currentFloor = currentFloor;
    }
}
