package TrafficLightFactory.TrafficLightFactorys;

import TrafficLightFactory.TrafficLights.PedestrianTrafficLight;
import TrafficLightFactory.TrafficLights.TrafficLight;

public class PedestrianTrafficLightFactory extends TrafficLightFactory {
    @Override
    public TrafficLight createTrafficLight() {
        return PedestrianTrafficLight.builder()
                .redLight("RED")
                .greenLight("GREEN")
                .build();
    }
}
