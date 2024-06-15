import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWijzigKost {

    // Methode om kost te wijzigen of toe te voegen
    public static void wijzigKost(Map<String, Double> kostenMap, String naam, double nieuwBedrag) {
        if (nieuwBedrag >= 0) {

            if (kostenMap.containsKey(naam)) {
                kostenMap.put(naam, nieuwBedrag);
                System.out.println("Kost '" + naam + "' is succesvol gewijzigd naar €" + nieuwBedrag + "\n");
            }
        }else {
            System.out.println("Ongeldige naam. Probeer opnieuw.\n");
        }
    }

    @Test
    public void testKostToevoegen() {
        Map<String, Double> kostenMap = new HashMap<>();
        kostenMap.put("Bestaande kostnaam",50.0);

        wijzigKost(kostenMap, "Bestaande kostnaam", 50.0);
        assertEquals(1, kostenMap.size());
        assertEquals(50.0, kostenMap.get("Bestaande kostnaam"));
    }

    @Test
    public void testKostToevoegenMetNul() {
        Map<String, Double> kostenMap = new HashMap<>();
        kostenMap.put("Bestaande Kostnaam",50.0);

        wijzigKost(kostenMap, "Bestaande Kostnaam", 0.0);
        assertEquals(1, kostenMap.size());
        assertEquals(0.0, kostenMap.get("Bestaande Kostnaam"));
    }

    @Test
    public void testKostNietToevoegenMetNegatiefBedrag() {
        Map<String, Double> kostenMap = new HashMap<>();


        wijzigKost(kostenMap, "Bestaande naam", -10.0);
        assertEquals(0, kostenMap.size()); // Er mag geen kost zijn toegevoegd
    }

    @Test
    public void testKostNietToevoegenMetNietBestaandeNaam() {
        Map<String, Double> kostenMap = new HashMap<>();

        wijzigKost(kostenMap, "Niet bestaande naam", 100.0);
        assertEquals(0, kostenMap.size()); // Er mag geen kost zijn toegevoegd
    }

    @Test
    public void testKostWijzigen() {
        Map<String, Double> kostenMap = new HashMap<>();
        kostenMap.put("Bestaande naam", 50.0);

        wijzigKost(kostenMap, "Bestaande naam", 75.0);
        assertEquals(1, kostenMap.size());
        assertEquals(75.0, kostenMap.get("Bestaande naam"));
    }

    @Test
    public void testKostWijzigenMetNul() {
        Map<String, Double> kostenMap = new HashMap<>();
        kostenMap.put("Bestaande naam", 50.0);

        wijzigKost(kostenMap, "Bestaande naam", 0.0);
        assertEquals(1, kostenMap.size());
        assertEquals(0.0, kostenMap.get("Bestaande naam"));
    }

    @Test
    public void testKostNietWijzigenMetNegatiefBedrag() {
        Map<String, Double> kostenMap = new HashMap<>();
        kostenMap.put("Bestaande naam", 50.0);

        wijzigKost(kostenMap, "Bestaande naam", -10.0);
        assertEquals(1, kostenMap.size());
        assertEquals(50.0, kostenMap.get("Bestaande naam")); // Bedrag moet hetzelfde blijven
    }

    @Test
    public void testKostNietWijzigenMetNietBestaandeNaam() {
        Map<String, Double> kostenMap = new HashMap<>();
        kostenMap.put("Bestaande naam", 50.0);

        wijzigKost(kostenMap, "Niet bestaande naam", 100.0);
        assertEquals(1, kostenMap.size());
        assertEquals(50.0, kostenMap.get("Bestaande naam")); // Bedrag moet hetzelfde blijven
    }

    @Test
    public void testKostToevoegenMetNegatiefBedrag() {
        Map<String, Double> kostenMap = new HashMap<>();

        wijzigKost(kostenMap, "Bestaande kostnaam", -50.0);
        assertEquals(0, kostenMap.size()); // Er mag geen kost zijn toegevoegd
    }

    @Test
    public void testKostWijzigenMetNegatiefBedrag() {
        Map<String, Double> kostenMap = new HashMap<>();
        kostenMap.put("Bestaande naam", 50.0);

        wijzigKost(kostenMap, "Bestaande naam", -75.0);
        assertEquals(1, kostenMap.size());
        assertEquals(50.0, kostenMap.get("Bestaande naam")); // Bedrag moet hetzelfde blijven
    }

    @Test
    public void testKostWijzigenMetGeldigBedrag() {
        Map<String, Double> kostenMap = new HashMap<>();
        kostenMap.put("Bestaande naam", 50.0);

        wijzigKost(kostenMap, "Bestaande naam", 75.0);
        assertEquals(1, kostenMap.size());
        assertEquals(75.0, kostenMap.get("Bestaande naam"));
    }

    @Test
    public void testKostWijzigenMetNulAlsBedrag() {
        Map<String, Double> kostenMap = new HashMap<>();
        kostenMap.put("Bestaande naam", 50.0);

        wijzigKost(kostenMap, "Bestaande naam", 0.0);
        assertEquals(1, kostenMap.size());
        assertEquals(0.0, kostenMap.get("Bestaande naam"));
    }
}
