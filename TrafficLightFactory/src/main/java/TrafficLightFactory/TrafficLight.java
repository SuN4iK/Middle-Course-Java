package TrafficLightFactory;

public interface TrafficLight {
    void turnOn();
    void turnOff();
    String getState();
    void setMediator(TrafficLightMediator mediator);
}
