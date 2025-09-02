package TrafficLightFactory;

public interface TrafficLightMediator {
    void addTrafficLight(TrafficLight light);
    void removeTrafficLight(TrafficLight light);
    void notify(TrafficLight sender, String event);
    void turnAllOn();
    void turnAllOff();
}
