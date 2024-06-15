import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadPositiveDoubleInputTest {

    // Aangepaste methode die nu een String input accepteert
    double readPositiveDoubleInput(String input) {
        double value = 0.0;
        try {
            value = Double.parseDouble(input);
            if (value < 0) {
                System.out.println("Invoer moet positief zijn. Voer opnieuw in.");
                return 0.0; // Of gooi een exception om opnieuw te vragen
            }
        } catch (NumberFormatException e) {
            System.out.println("Ongeldige invoer. Voer een geldig getal in.");
            return 0.0; // Of gooi een exception om opnieuw te vragen
        }
        return value;
    }

    @Test
    void testPositiveInputZero() {
        assertEquals(0.0, readPositiveDoubleInput("0.0"));
    }

    @Test
    void testPositiveInputSmall() {
        assertEquals(0.001, readPositiveDoubleInput("0.001"));
    }

    @Test
    void testPositiveInputLarge() {
        assertEquals(100000000.0, readPositiveDoubleInput("100000000"));
    }

    @Test
    void testNegativeInput() {
        assertEquals(0.0, readPositiveDoubleInput("-1000"));
    }

    @Test
    void testNegativeInputSmall() {
        assertEquals(0.0, readPositiveDoubleInput("-0.0001"));
    }

    @Test
    void testNonNumericInput() {
        assertEquals(0.0, readPositiveDoubleInput("hoi"));
    }

    @Test
    void testNonNumericInputWithNumber() {
        assertEquals(0.0, readPositiveDoubleInput("Hello12345"));
    }

}
