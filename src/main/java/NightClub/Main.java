package NightClub;

import java.util.*;

import NightClub.NightClub.FaceControl;

public class Main {
    public static void main(String[] args) {
        List<Person> visitors = new ArrayList<>();
        NightClub club = new NightClub(100, visitors, DayOfWeek.MONDAY);
        FaceControl bouncer = new FaceControl();

        Person person1 = new Person("Алексей", ClothingStyle.SPORT, false);
        Person person2 = new Person("Мария", ClothingStyle.CASUAL, true);

        bouncer.letIn(person1, DayOfWeek.MONDAY, 66, 90); // Допущен

    }
}

