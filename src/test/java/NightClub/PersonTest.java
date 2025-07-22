package NightClub;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void personCreation_shouldSetCorrectValues() {
        Person person = new Person("Иван", ClothingStyle.SPORT, true);

        assertEquals("Иван", person.getName());
        assertEquals(ClothingStyle.SPORT, person.getStyle());
        assertTrue(person.isHasDebt());
    }
}
