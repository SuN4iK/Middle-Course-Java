package TrafficLightFactory.TrafficLights;

import TrafficLightFactory.Mediators.TrafficLightMediator;

public interface TrafficLight {
    void turnOn();

    void turnOff();

    String getState();

    void setMediator(TrafficLightMediator mediator);
}
