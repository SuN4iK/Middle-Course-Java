package TrafficLightFactory;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class CarTrafficLight extends AbstractTrafficLight {
    public String redLight;
    public String greenLight;
    public String yellowLight;

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Car Traffic Light is ON");
        if (mediator != null) {
            mediator.notify(this, "TURNED_ON");
        }
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Car Traffic Light is OFF");
        if (mediator != null) {
            mediator.notify(this, "TURNED_OFF");
        }
    }
}
