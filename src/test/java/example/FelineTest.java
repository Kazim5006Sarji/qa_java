package example;

import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    private int actualKittensCount;
    private int expectedKittensCount;

    private Feline feline = new Feline();

    public FelineTest() {}

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void eatMeatTest() throws Exception {
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        List<String> actualResult = feline.eatMeat();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getFamilyTest() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensNotParametrizedTest() {
        assertEquals(expectedKittensCount, feline.getKittens(actualKittensCount));
    }

    @Test
    public void getFoodTest() {
        assertThrows(Exception.class, () -> feline.getFood("еда"));
    }

    @Test
    public void getGrassFoodTest() throws Exception {
        assertEquals(feline.getFood("Травоядное"), List.of("Трава", "Различные растения"));
    }
}