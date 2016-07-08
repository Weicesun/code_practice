// enum type for Vehicle
enum VehicleSize {
    Motorcycle,
    Compact,
    Large,
}

abstract class Vehicle {
    // Write your code here
    protected int spotsNeeded;
    protected VehicleSize size;
    protected String licensePlate;
    
    protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
    public int getSpotsNeeded() {
        return spotsNeeded;
    }
    public VehicleSize getSize() {
        return size;
    }
    public void parkInSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
    }
    public void clearSpots() {
        for (int i = 0; i < parkingSpots.size(); i++) {
            parkingSpots.get(i).removeVehicle();
        }
        parkingSpots.clear();
    }
    public abstract boolean canFitInSpot(ParkingSpot spot);
    public abstract void print();
}

class Motorcycle extends Vehicle {
    // Write your code here
    public Motorcycle() {
        spotsNeeded = 1;
        size = VehicleSize.Motorcycle;
    }
    public boolean canFitInSpot(ParkingSpot spot) {
        return true;
    }
    public void print() {
        System.out.print("M");
    }
}

class Car extends Vehicle {
    // Write your code here
    public Car() {
        spotsNeeded = 1;
        size = VehicleSize.Compact;
    }
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Large || spot.getSize() == VehicleSize.Compact;
    }
    public void print() {
        System.out.print("C");
    }
}

class Bus extends Vehicle {
    // Write your code here
    public Bus() {
        spotsNeeded = 5;
        size = VehicleSize.Large;
    }
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Large;
    }
    public void print() {
        System.out.print("B");
    }
}

class ParkingSpot {
    private Vehicle vehicle;
    private VehicleSize spotSize;
    private int row;
    private int spotNumber;
    private Level level;
    
    public ParkingSpot(Level lvl, int r, int n, VehicleSize sz) {
        level = lvl;
        row = r;
        spotNumber = n;
        spotSize = sz;
    }
    public boolean isAvailable() {
        return vehicle == null;
    }
    public boolean canFitVehicle(Vehicle vehicle) {
        return isAvailable() && vehicle.canFitInSpot(this);
    }
    public boolean park(Vehicle v) {
        if (!canFitVehicle(v)) {
            return false;
        }
        vehicle = v;
        vehicle.parkInSpot(this);
        return true;
    }
    public void removeVehicle() {
        level.spotFreed();
        vehicle = null;
    }
    public int getRow() {
        return row;
    }
    public int getSpotNumber() {
        return spotNumber;
    }
    public VehicleSize getSize() {
        return spotSize;
    }
    public void print() {
        if (vehicle == null) {
            if (spotSize == null) {
                if (spotSize == VehicleSize.Compact) {
                    System.out.print("c");
                } else if (spotSize == VehicleSize.Large) {
                    System.out.print("l");
                } else if (spotSize == VehicleSize.Motorcycle) {
                    System.out.print("m");
                }
            } else {
                vehicle.print();
            }
        }
    }
}

/* Represents a level in a parking garage */
class Level {
    // Write your code here
    private int floor;
    private ParkingSpot[] spots;
    private int availableSpots = 0;
    private int SPORT_PER_ROW;
    
    public Level(int flr, int num_rows, int spots_per_row) {
        floor = flr;
        int numberSpots = 0;
        spots = new ParkingSpot[num_rows * spots_per_row];
        for (int row = 0; row < num_rows; row++) {
            for (int spot = 0; spot < spots_per_row / 4; spot++) {
                VehicleSize sz = VehicleSize.Motorcycle;
                spots[numberSpots] = new ParkingSpot(this, row, numberSpots, sz);
                numberSpots++;
            }
            for (int spot = spots_per_row / 4; spot < spots_per_row / 4 * 3; spot++) {
                VehicleSize sz = VehicleSize.Compact;
                spots[numberSpots] = new ParkingSpot(this, row, numberSpots, sz);
                numberSpots++;
            }
            for (int spot = spots_per_row / 4 * 3; spot < spots_per_row; spot++) {
                VehicleSize sz = VehicleSize.Large;
                spots[numberSpots] = new ParkingSpot(this, row, numberSpots, sz);
                numberSpots++;
            }
        }
        availableSpots = numberSpots;
    }
    
    public boolean parkVehicle(Vehicle vehicle) {
        if (availableSpots() < vehicle.getSpotsNeeded()) {
            return false;
        }
        int spotNumber = findAvaliableSpots(vehicle);
        if (spotNumber < 0) {
            return false;
        }
        return parkStartingAtSpot(spotNumber, vehicle);
    }
    private int findAvaliableSpots(Vehicle vehicle) {
        int spotsNeeded = vehicle.getSpotsNeeded();
        int lastRow = -1;
        int spotsFound = 0;
        
        for (int i = 0; i < spots.length; i++) {
            ParkingSpot spot = spots[i];
            if (lastRow != spot.getRow()) {
                spotsFound = 0;
                lastRow = spot.getRow();
            }
            if (spot.canFitVehicle(vehicle)) {
                spotsFound++;
            } else {
                spotsFound = 0;
            }
            if (spotsFound == spotsNeeded) {
                return i - (spotsNeeded - 1);
            }
        }
        return -1;
    }
    private boolean parkStartingAtSpot(int spotNumber, Vehicle vehicle) {
        vehicle.clearSpots();
        boolean success = true;
        
        for (int i = spotNumber; i < spotNumber + vehicle.spotsNeeded; i++) {
            success &= spots[i].park(vehicle);
        }
        availableSpots -= vehicle.spotsNeeded;
        return success;
    }
    public void spotFreed() {
        availableSpots++;
    }
    public int availableSpots() {
        return availableSpots;
    }
    public void print() {
        int lastRow = -1;
        for (int i = 0; i < spots.length; i++) {
            ParkingSpot spot = spots[i];
            if (spot.getRow() != lastRow) {
                System.out.print(" ");
                lastRow = spot.getRow();
            }
            spot.print();
        }
    }
}

public class ParkingLot {
    
    private Level[] levels;
    private int NUM_LEVELS;
    
    // @param n number of leves
    // @param num_rows  each level has num_rows rows of spots
    // @param spots_per_row each row has spots_per_row spots
    public ParkingLot(int n, int num_rows, int spots_per_row) {
        // Write your code here
        NUM_LEVELS = n;
        levels = new Level[NUM_LEVELS];
        for (int i = 0; i < NUM_LEVELS; i++) {
            levels[i] = new Level(i, num_rows, spots_per_row);
        }
    }

    // Park the vehicle in a spot (or multiple spots)
    // Return false if failed
    public boolean parkVehicle(Vehicle vehicle) {
        // Write your code here
        for (int i = 0; i < levels.length; i++) {
            if (levels[i].parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    // unPark the vehicle
    public void unParkVehicle(Vehicle vehicle) {
        // Write your code here
        vehicle.clearSpots();
    }
    public void print() {
        for (int i = 0; i < levels.length; i++) {
            System.out.print("Level" + i + ": ");
            levels[i].print();
            System.out.println("");
        }
        System.out.println("");
    }
}
