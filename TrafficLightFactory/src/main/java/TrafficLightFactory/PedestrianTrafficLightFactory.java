package TrafficLightFactory;

public class PedestrianTrafficLightFactory extends TrafficLightFactory {
    @Override
    public TrafficLight createTrafficLight() {
        return PedestrianTrafficLight.builder()
                .redLight("RED")
                .greenLight("GREEN")
                .build();
    }
}
