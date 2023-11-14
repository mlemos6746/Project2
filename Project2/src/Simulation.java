import java.util.ArrayList;
import java.util.List;

public class Simulation  implements Simulablatable{
    private final static String DEFAULT_STRUCTURE = "linked";
    private final static String LINKED_STRUCTURE = "linked";
    private final static String ARRAY_STRUCTURE = "array";
    private final  static int DEFAULT_FLOORS = 32;
    private final double DEFAULT_PASSENGER_PROBABILITY = 0.03;
    private final int DEFAULT_ELEVATORS = 1;
    private final int DEFAULT_ELEVATOR_CAPACITY = 10;

    private final int DEFAULT_SIMULATION_DURATION = 500;


    private String structure;
    private int floorsCount;
    private double passengerProbability;
    private int elevatorsCount;
    private int elevatorCapacity;
    private int  duration;



    private List<Elevator> elevators;
    private List<Floor> floors;
    private int time;


    public Simulation(String fileName) {
        if (fileName == null) {
            structure = DEFAULT_STRUCTURE;
            floorsCount = DEFAULT_FLOORS;
            passengerProbability = DEFAULT_PASSENGER_PROBABILITY;
            elevatorsCount = DEFAULT_ELEVATORS;
            elevatorCapacity = DEFAULT_ELEVATOR_CAPACITY;
            duration = DEFAULT_SIMULATION_DURATION;
        }else {
            init(fileName);
        }

        setUp();
    }

    private void  init(String fileName) {

    }

    private void setUp() {
        time = 0;
        elevators = new ArrayList<>();
        floors = new ArrayList<>();

        for (int i = 1; i <= floorsCount; i++) {
            Floor floor;
            if (structure.equals(LINKED_STRUCTURE)) {
                floor = new LinkedFloor(i, floorsCount, passengerProbability);
            } else {
                floor = new ArrayFloor(i, floorsCount, passengerProbability);
            }
            floors.add(floor);
        }

        for (int i = 0; i < elevatorsCount; i++) {
            Floor initialFloor = floors.get(0); // You can modify this based on your requirements
            Elevator elevator;
            if (structure.equals(LINKED_STRUCTURE)) {
                elevator = new LinkedElevator(initialFloor, elevatorCapacity);
            } else {
                elevator = new ArrayElevator(initialFloor, elevatorCapacity);
            }
            elevators.add(elevator);
        }
    }


    public void run() {
        while (time < duration) {
            clockTick();
            time ++;
        }
    }


    public void report() {
        List<Long> conveyanceTimes = new ArrayList<>();

        for (Floor floor : floors) {
            for (Passenger passenger : floor.getConveyedPassengers()) {
                long conveyanceTime = passenger.getConveyanceTime() - passenger.getArrivalTime();
                conveyanceTimes.add(conveyanceTime);
            }
        }

        if (!conveyanceTimes.isEmpty()) {
            // Calculate average
            double averageTime = conveyanceTimes.stream().mapToLong(Long::longValue).average().orElse(0.0);
            System.out.println("Average time between arrival and conveyance: " + averageTime);

            // Calculate longest time
            long longestTime = conveyanceTimes.stream().mapToLong(Long::longValue).max().orElse(0);
            System.out.println("Longest time between arrival and conveyance: " + longestTime);

            // Calculate shortest time
            long shortestTime = conveyanceTimes.stream().mapToLong(Long::longValue).min().orElse(0);
            System.out.println("Shortest time between arrival and conveyance: " + shortestTime);
        } else {
            System.out.println("No passengers conveyed during the simulation.");
        }
    }



    @Override
    public void clockTick() {
        for (Elevator elevator : elevators) {
            elevator.clockTick();
        }

        for (Floor floor : floors) {
            floor.clockTick();
        }

    }

    public static void main(String[] args) {
        Simulation sim = new Simulation(null);
        sim.run();
        sim.report();
    }


}
