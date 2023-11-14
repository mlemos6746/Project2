import java.util.Random;

public class Passenger {
    private int source;
    private int destination;
    private Elevator.ElevatorDirection direction;

    public Passenger(int source, int destination) {
        if (source == destination) {
            throw new IllegalArgumentException("Passenger source and destination elevator can not be the same!");
        }
        this.source = source;
        this.destination = destination;
        direction = source> destination ? Elevator.ElevatorDirection.DOWN : Elevator.ElevatorDirection.UP;
    }

    public Elevator.ElevatorDirection getDirection() {
        return direction;
    }

    public int getDestination() {
        return destination;
    }

    public int getArrivalTime() {
        return new Random().nextInt(100);
    }

    public int getConveyanceTime() {
        return new Random().nextInt(50);
    }
}
