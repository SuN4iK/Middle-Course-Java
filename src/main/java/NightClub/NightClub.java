package NightClub;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
public class NightClub {
    private int capacity;
    private List<Person> persons;
    private DayOfWeek currentDay;


    static class FaceControl {
        static boolean letIn(Person person, DayOfWeek dayOfWeek, int currentVisitors, int capacity) {
            if (dayOfWeek == DayOfWeek.MONDAY) {
                System.out.println("Сегодня понедельник, наш клуб работает и впускает только спортивных!");
                if (person.getStyle() == ClothingStyle.SPORT) {
                    System.out.println("Вы подходите по стилю, давайте проверим вместимость клуба..");
                    return currentVisitors < capacity;
                }
                return false;
            } else {
                System.out.println("Приходите в другой раз!");
                return false;
            }
        }

        static boolean letOut(Person person) {
            if (person.isHasDebt()) {
                System.out.println(person.getName() + " не может покинуть клуб из-за задолженности!");
                return false;
            } else {
                System.out.println(person.getName() + " может свободно покинуть клуб.");
                return true;
            }
        }
    }
}



