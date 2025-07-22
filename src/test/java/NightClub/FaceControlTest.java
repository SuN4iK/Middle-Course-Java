package NightClub;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FaceControlTest {

    Person mockPerson = Mockito.mock(Person.class);

    @Test
    void letIn_shouldAllowSportStyleOnMonday() {
        when(mockPerson.getStyle()).thenReturn(ClothingStyle.SPORT);

        boolean result = NightClub.FaceControl.letIn(
                mockPerson,
                DayOfWeek.MONDAY,
                50,
                80
        );

        assertTrue(result);
    }

    // Остальные тесты из предыдущего примера...
}