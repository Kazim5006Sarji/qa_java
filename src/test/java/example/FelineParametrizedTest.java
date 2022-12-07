package example;

import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParametrizedTest {
    private int actualKittensCount;
    private int expectedKittensCount;
    private Feline feline = new Feline();

    public FelineParametrizedTest(int kittensCount, int expected) {
        this.actualKittensCount = kittensCount;
        this.expectedKittensCount = expected;
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters
    public static Object[] getKittensCount() {
        return new Object[][]{{0, 0}, {1, 1}, {10, 10}};
    }

    @Test
    public void getKittensParametrizedTest() {
        assertEquals(expectedKittensCount, feline.getKittens(actualKittensCount));
    }
}