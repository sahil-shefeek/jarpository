class Box {
    double height;
    double width;
    double depth;

    // Constructor with no parameters
    Box() {
        height = 1.0;
        width = 1.0;
        depth = 1.0;
    }

    // Constructor with one parameter (for a cube)
    Box(double side) {
        height = side;
        width = side;
        depth = side;
    }

    // Constructor with three parameters (custom dimensions)
    Box(double height, double width, double depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    // Method to calculate the volume of the box
    double calculateVolume() {
        return height * width * depth;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create box objects using different constructors
        Box box1 = new Box(); // Default box
        Box box2 = new Box(2.0); // Cube with side length 2.0
        Box box3 = new Box(3.0, 4.0, 5.0); // Custom-sized box

        // Calculate and display the volumes
        System.out.println("Volume of box1: " + box1.calculateVolume());
        System.out.println("Volume of box2: " + box2.calculateVolume());
        System.out.println("Volume of box3: " + box3.calculateVolume());
    }
}
