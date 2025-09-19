package TrafficLightFactory.Mediators;

import TrafficLightFactory.TrafficLights.TrafficLight;

public interface TrafficLightMediator {
    void addTrafficLight(TrafficLight light);

    void removeTrafficLight(TrafficLight light);

    void notify(TrafficLight sender, String event);

    //Централизованное управление
    void turnAllOn();

    void turnAllOff();
}
