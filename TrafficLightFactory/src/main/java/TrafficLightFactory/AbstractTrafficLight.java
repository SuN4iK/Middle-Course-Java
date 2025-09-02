package TrafficLightFactory;

public abstract class AbstractTrafficLight implements TrafficLight {
    protected TrafficLightMediator mediator;
    protected boolean isOn = false;

    @Override
    public String getState() {
        return "";
    }

    @Override
    public void setMediator(TrafficLightMediator mediator) {

    }
}
