package TrafficLightFactory;

import java.util.ArrayList;
import java.util.List;

public class TrafficLightController implements TrafficLightMediator {
    private final List<TrafficLight> trafficLights = new ArrayList<>();

    @Override
    public void addTrafficLight(TrafficLight light) {
        trafficLights.add(light);
        light.setMediator(this);
    }

    @Override
    public void removeTrafficLight(TrafficLight light) {
        trafficLights.remove(light);
        light.setMediator(null);
    }

    @Override
    public void notify(TrafficLight sender, String event) {
        System.out.println("Mediator received event: " + event + " from " + sender.getClass().getSimpleName());
    }

    @Override
    public void turnAllOn() {
        System.out.println("Turning ALL traffic lights ON");
        trafficLights.forEach(TrafficLight::turnOn);
    }

    @Override
    public void turnAllOff() {
        System.out.println("Turning ALL traffic lights OFF");
        trafficLights.forEach(TrafficLight::turnOff);
    }

}
