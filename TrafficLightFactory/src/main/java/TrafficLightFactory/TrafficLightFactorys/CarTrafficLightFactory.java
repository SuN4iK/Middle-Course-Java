package TrafficLightFactory.TrafficLightFactorys;

import TrafficLightFactory.TrafficLights.CarTrafficLight;
import TrafficLightFactory.TrafficLights.TrafficLight;

public class CarTrafficLightFactory extends TrafficLightFactory {
    //Реализация Factory Method
    @Override
    public TrafficLight createTrafficLight() {
        return CarTrafficLight.builder()
                .redLight("RED")
                .yellowLight("YELLOW")
                .greenLight("GREEN")
                .build();
    }
}
