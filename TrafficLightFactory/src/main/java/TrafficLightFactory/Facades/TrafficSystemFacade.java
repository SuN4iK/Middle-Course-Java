package TrafficLightFactory.Facades;

import TrafficLightFactory.Controllers.TrafficLightController;
import TrafficLightFactory.Groups.TrafficLightGroup;
import TrafficLightFactory.Mediators.TrafficLightMediator;
import TrafficLightFactory.TrafficLightFactorys.CarTrafficLightFactory;
import TrafficLightFactory.TrafficLightFactorys.PedestrianTrafficLightFactory;
import TrafficLightFactory.TrafficLightFactorys.TrafficLightFactory;
import TrafficLightFactory.TrafficLights.TrafficLight;

import java.util.Map;

public class TrafficSystemFacade {
    private final TrafficLightMediator mediator;
    private final Map<String, TrafficLightFactory> factories;

    public TrafficSystemFacade() {
        this.mediator = new TrafficLightController();
        this.factories = Map.of(
                "car", new CarTrafficLightFactory(),
                "pedestrian", new PedestrianTrafficLightFactory()
        );
    }

    public TrafficLight createTrafficLight(String type) {
        try {
            var factory = factories.get(type.toLowerCase());
            if (factory == null) {
                throw new IllegalArgumentException("Unknown traffic light type: " + type);
            }
            var light = factory.getTrafficLight();
            mediator.addTrafficLight(light);
            return light;
        } catch (Exception e) {
            System.err.println("Error creating traffic light: " + e.getMessage());
            return null;
        }
    }

    public void turnOnAllLights() {
        mediator.turnAllOn();
    }

    public void turnOffAllLights() {
        mediator.turnAllOff();
    }

    public TrafficLightGroup createIntersectionGroup() {
        var group = new TrafficLightGroup();
        group.add(createTrafficLight("car"));
        group.add(createTrafficLight("pedestrian"));
        group.setMediator(mediator);
        return group;
    }
}
