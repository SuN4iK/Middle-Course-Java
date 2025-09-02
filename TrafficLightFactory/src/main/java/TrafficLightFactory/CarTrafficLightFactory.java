package TrafficLightFactory;

public class CarTrafficLightFactory extends TrafficLightFactory {
    @Override
    public TrafficLight createTrafficLight() {
        return CarTrafficLight.builder()
                .redLight("RED")
                .yellowLight("YELLOW")
                .greenLight("GREEN")
                .build();
    }
}
