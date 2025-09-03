package TrafficLightFactory.Groups;

import TrafficLightFactory.Mediators.TrafficLightMediator;
import TrafficLightFactory.TrafficLights.TrafficLight;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Composite
public class TrafficLightGroup implements TrafficLight {
    private final List<TrafficLight> trafficLights = new ArrayList<>();
    private TrafficLightMediator mediator;

    public void add(TrafficLight light) {
        trafficLights.add(light);
    }

    public void remove(TrafficLight light) {
        trafficLights.remove(light);
    }

    @Override
    public void turnOn() {
        System.out.println("Turning ON traffic light group");
        trafficLights.forEach(TrafficLight::turnOn);
    }

    @Override
    public void turnOff() {
        System.out.println("Turning OFF traffic light group");
        trafficLights.forEach(TrafficLight::turnOff);
    }

    @Override
    public String getState() {
        return trafficLights.stream()
                .map(TrafficLight::getState)
                .collect(Collectors.joining(", "));
    }

    @Override
    public void setMediator(TrafficLightMediator mediator) {
        this.mediator = mediator;
        trafficLights.forEach(light -> light.setMediator(mediator));
    }
}
