import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Floor implements Simulablatable{
    private final int number;
    private final  int maxFloor;
    private double passengerProbability;

    protected List<Passenger> upPassengers;
    protected List<Passenger>  downPassengers;

    protected List<Elevator> elevators;

    public Floor(int number, int maxFloor,  double passengerProbability) {
        this.number = number;
        this.maxFloor = maxFloor;
        this.passengerProbability = passengerProbability;
        elevators = new ArrayList<>();
    }

    @Override
    public void clockTick() {
        Random random = new Random();
        double randValue = random.nextDouble();
        if (randValue <= passengerProbability) {
            int destination = number;
            while (destination == number) {
                destination = random.nextInt(maxFloor) + 1;
            }
            Passenger passenger = new Passenger(number, destination);
            if (passenger.getDirection() == Elevator.ElevatorDirection.DOWN) {
                downPassengers.add(passenger);
            }else {
                upPassengers.add(passenger);
            }
        }
    }


    public int getNumber() {
        return number;
    }

    public List<Passenger> getPassengers (Elevator.ElevatorDirection direction) {
        return direction == Elevator.ElevatorDirection.DOWN ? downPassengers : upPassengers;
    }

    public List<Passenger> getConveyedPassengers() {
       return  new ArrayList<>();
    }
}
