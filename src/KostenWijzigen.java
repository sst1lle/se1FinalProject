import java.util.Map;

public class KostenWijzigen {

    public static void wijzigKost(Map<String, Double> kostenMap, String naam, double nieuwBedrag) {
        if (kostenMap.containsKey(naam)) {
            kostenMap.put(naam, nieuwBedrag);
            System.out.println("Kost '" + naam + "' is succesvol gewijzigd naar €" + nieuwBedrag+"\n");
        } else {
            System.out.println("Ongeldige naam. Probeer opnieuw.\n");
        }
    }

    public static void printKosten(Map<String, Double> kostenMap) {
        for (Map.Entry<String, Double> entry : kostenMap.entrySet()) {
            System.out.println(entry.getKey() + ": €" + String.format("%.2f", entry.getValue()));
        }
        System.out.println();
    }
}
