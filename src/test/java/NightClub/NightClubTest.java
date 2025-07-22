package NightClub;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class) // Подключаем Mockito
class NightClubTest {

    //Встретил такую реализацию mock'а в deepseek
    @Mock
    Person mockPerson;

    @Test
    void testLetInWithMock() {

        when(mockPerson.getStyle()).thenReturn(ClothingStyle.SPORT);


        boolean result = NightClub.FaceControl.letIn(
                mockPerson,
                DayOfWeek.MONDAY,
                50,
                100
        );

        assertTrue(result);


        verify(mockPerson).getStyle();
    }

    @Test
    void testLetOutWithMock() {

        when(mockPerson.isHasDebt()).thenReturn(false);


        boolean result = NightClub.FaceControl.letOut(mockPerson);

        assertTrue(result);


        verify(mockPerson).isHasDebt();
    }
}