package TrafficLightFactory.TrafficLights;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class PedestrianTrafficLight extends AbstractTrafficLight {
    public String redLight;
    public String greenLight;

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Pedestrian Traffic Light is ON");
        if (mediator != null) {
            mediator.notify(this, "TURNED_ON");
        }
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Pedestrian Traffic Light is OFF");
        if (mediator != null) {
            mediator.notify(this, "TURNED_OFF");
        }
    }
}
