# Elevator Simulation

This program simulates an elevator system with multiple floors and elevators. The simulation includes the generation of passengers, elevator travel, loading and unloading of passengers, and tracks statistics such as the average, longest, and shortest time between passenger arrival and conveyance to the final destination.

- The simulation parameters can be configured in the `Simulation.properties` file.

- Simulation runs for a specified duration, and during each tick, the following events may occur:
    - Elevator unload & load
    - Elevator travel
    - New passengers request transportation
After the simulation concludes, the `report` method calculates and prints the following statistics:

- Average length of time between passenger arrival and conveyance to the final destination
- Longest time between passenger arrival and conveyance to the final destination
- Shortest time between passenger arrival and conveyance to the final destination
