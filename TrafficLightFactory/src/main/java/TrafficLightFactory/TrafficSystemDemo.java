package TrafficLightFactory;

public class TrafficSystemDemo {
    public static void main(String[] args) {
        try {
            var trafficSystem = new TrafficSystemFacade();

            // Создаем отдельные светофоры
            var carLight = trafficSystem.createTrafficLight("car");
            var pedestrianLight = trafficSystem.createTrafficLight("pedestrian");

            // Создаем группу светофоров для перекрестка
            var intersection = trafficSystem.createIntersectionGroup();

            System.out.println("=== Testing individual lights ===");
            carLight.turnOn();
            pedestrianLight.turnOn();

            System.out.println("\n=== Testing group ===");
            intersection.turnOn();

            System.out.println("\n=== Testing mediator control ===");
            trafficSystem.turnOffAllLights();

        } catch (Exception e) {
            System.err.println("Demo error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
