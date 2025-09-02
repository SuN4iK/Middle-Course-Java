package TrafficLightFactory;

public abstract class TrafficLightFactory {
    public abstract TrafficLight createTrafficLight();

    public TrafficLight getTrafficLight() {
        try {
            var light = createTrafficLight();
            System.out.println("Created traffic light: " + light.getClass().getSimpleName());
            return light;
        } catch (Exception e) {
            System.err.println("Error creating traffic light: " + e.getMessage());
            return null;
        }
    }
}
