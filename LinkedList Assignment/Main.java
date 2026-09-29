public class Main {
    public static void main(String[] args) {
        LinkedList carList = new LinkedList(){};
        LinkedList driverList = new LinkedList(){};

        // Add data
        carList.add(new Node(new Car("Red Bull", 320, 800)));
        carList.add(new Node(new Car("Ferrari", 340, 780)));
        carList.add(new Node(new Car("Mercedes", 330, 790)));

        driverList.add(new Node(new Driver("Max Verstappen", 4,true)));
        driverList.add(new Node(new Driver("Lewis Hamilton",7,true)));

        // Display
        System.out.println("=== CAR LIST ===");
        carList.displayLinkedList();

        System.out.println("=== DRIVER LIST ===");
        driverList.displayLinkedList();

        // Get data by index
        System.out.println("=== GET CAR AT INDEX 2 ===");
        Car c = (Car) carList.getAt(2);
        if (c != null) {
            System.out.println(c.getName() + " top speed: " + c.getTopSpeed() + " Weight: " + c.getWeight());
        }
        System.out.println("=== GET CAR AT INDEX 0 ===");
        Driver d = (Driver) driverList.getAt(0);
        if (d != null) {
            System.out.println(d.getName() + " Wdc: " + d.getWdc() + " Active: " + d.getActive());
        }

        // Insert at index
        System.out.println("=== insert car at index(1, McLaren) ===");
        carList.insertAt(1, new Node(new Car("McLaren", 335, 785)));
        carList.displayLinkedList();
        System.out.println("=== insert driver at index(0, Fernando Alonso) ===");
        driverList.insertAt(0,new Node(new Driver("Fernando Alonso",2,true)));
        driverList.displayLinkedList();
        
        // Search
        System.out.println("=== SEARCH ===");
        carList.searchLinkedList(new Car("Ferrari"));
        carList.searchLinkedList(new Car("Toyota"));
        driverList.searchLinkedList(new Driver("Max Verstappen"));
        driverList.searchLinkedList(new Driver("Daniel Riccardo"));

        // Delete
        System.out.println("=== DELETE Ferrari & Lewis Hamilton ===");
        carList.delete(new Car("Ferrari"));
        carList.displayLinkedList();
        driverList.delete(new Driver("Lewis Hamilton"));
        driverList.displayLinkedList();

        // Count
        System.out.println("=== COUNT ===");
        System.out.println("cars   : " + carList.count());
        System.out.println("drivers: " + driverList.count());
    }
}
