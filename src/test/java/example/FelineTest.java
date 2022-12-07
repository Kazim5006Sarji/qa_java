package example;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
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

    public FelineTest() {

    }

    /*public FelineTest(int kittensCount, int expected) {
        this.actualKittensCount = kittensCount;
        this.expectedKittensCount = expected;
    }
*/
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
        Feline feline = Mockito.mock(Feline.class);
        assertThrows(Exception.class, () -> feline.getFood(Mockito.anyString()));
    }

    @Test
    public void getGrassFoodTest() throws Exception {
        assertEquals(feline.getFood("Травоядное"), List.of("Трава", "Различные растения"));
    }
}