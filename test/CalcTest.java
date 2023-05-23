import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalcTest {
    ProcessingTimeCalculator processingTimeCalculator ;

    @BeforeEach
    public void initEach() {
        this.processingTimeCalculator = new ProcessingTimeCalculator();
    }
    
    @Test
    public void testCalcBodyIndex() {
        double actual = this.processingTimeCalculator.calcBodyIndex(100,33, 25 );
        double expected = 0.12;
        assertEquals(expected, actual, 0.1);
    }

    @Test
    public void testCalcBodyIndexSecond() {
        double actual = this.processingTimeCalculator.calcBodyIndex(140, 55, 28);
        double expected = 0.09;
        assertEquals(expected, actual, 0.1);
    }
    @Test
    public void testCalcBodyIndexBottom() {
        double actual = this.processingTimeCalculator.calcBodyIndex(45, 24, 8);
        double expected = 0.23;
        assertEquals(expected, actual, 0.1);
    }
    @Test
    public void testCalcBodyIndexTop() {
        double actual = this.processingTimeCalculator.calcBodyIndex(650, 2.5,16);
        double expected = 16.25;
        assertEquals(expected, actual, 0.1);
    }


}