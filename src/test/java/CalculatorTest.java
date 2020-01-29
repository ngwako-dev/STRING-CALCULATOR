
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class  CalculatorTest {

    @Test
    void handleIntegersPassedAsStrings() throws Exception {
        assertEquals(0, Calculator.add(""));

        assertEquals(1, Calculator.add("1"));

        assertEquals(2, Calculator.add("1,1"));

    }

    @Test
    void handleMultipleIntegers() throws Exception {
        assertEquals(0, Calculator.add(""));

        assertEquals(1, Calculator.add("1"));

        assertEquals(2, Calculator.add("1,1"));

        assertEquals(10, Calculator.add("1,2,3,4"));
    }

    @Test
    void handleNewLines() throws Exception {
        assertEquals(6, Calculator.add(("1\n2,3")));
    }

    @Test
    void handleDifferentDelimeter() throws Exception {
        assertEquals(3, Calculator.add("//4\n142"));
        assertEquals(3, Calculator.add("//;\n1;2"));
    }

    @Test
    void delimeterOfAnyLength() throws Exception {

        assertEquals(6,Calculator.add("//***\n1***2***3"));
    }

    @Test
    void testExpectedExceptionWithSuperType() {

        Assertions.assertThrows(Exception.class, ()-> Calculator.add("-1"));

    }

    @Test
         void ignoreIntegerMoreThan1000() throws Exception {

               assertEquals(2, Calculator.add("1,1,1000,20000"));
    }


}


