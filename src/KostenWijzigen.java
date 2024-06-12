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

}
