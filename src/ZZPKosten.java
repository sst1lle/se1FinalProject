import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class ZZPKosten extends Kosten implements BerekenBTW{
    private double administratieKosten;
    private Map<String, Double> kostenMap;

    private ArrayList<Double> zzpkostenArray;



    //Long parameter list, ik weet hiervan, maar de enige oplossing die ik denk ik kan vinden hiervoor is door gebruik te maken van een builder pattern, wat eigenlijk niet helemaal het probleem oplost, omdat ik dan alsnog een lange parameter zal krijgen met het woord .builder() ertusssen.
    public ZZPKosten(double inkomen, double belastingkosten, double huurkosten, double energieEnGasEnWaterKosten, double reiskosten,
                     double marketingkosten, double boodschappengeld, double shopgeld, double abbonementen,
                     double persoonlijkeVerzorging, double spaargeld, double verzekeringen,
                     double administratieKosten) {
        super(inkomen, belastingkosten, huurkosten, energieEnGasEnWaterKosten, reiskosten, marketingkosten, boodschappengeld, shopgeld, abbonementen, persoonlijkeVerzorging, spaargeld, verzekeringen);
        this.administratieKosten = administratieKosten;
        this.zzpkostenArray = new ArrayList<>();
        kostenMap = new HashMap<>();
        kostenMap.put("Inkomen", inkomen);
        kostenMap.put("Belastingkosten", belastingkosten);
        kostenMap.put("Huurkosten", huurkosten);
        kostenMap.put("Energie en gas en water kosten", energieEnGasEnWaterKosten);
        kostenMap.put("Reiskosten", reiskosten);
        kostenMap.put("Marketingkosten", marketingkosten);
        kostenMap.put("Boodschappengeld", boodschappengeld);
        kostenMap.put("Kledinggeld", shopgeld);
        kostenMap.put("Abonnementen", abbonementen);
        kostenMap.put("Persoonlijke verzorging", persoonlijkeVerzorging);
        kostenMap.put("Spaargeld", spaargeld);
        kostenMap.put("Verzekeringen", verzekeringen);
        kostenMap.put("Administratiekosten",administratieKosten);


        voegZZPKostenToe(administratieKosten);
    }

    public Map<String, Double> getKostenMap() {
        return kostenMap;
    }
    @Override
    public ArrayList<Double> getKosten() {
        return new ArrayList<>(kostenMap.values());
    }

    public void voegZZPKostenToe(double... zzpKostenArray) {
        voegKostenToe(zzpKostenArray);
    }


    @Override
    public void berekenBTW(ArrayList<Double> zzpkostenArray) {

       double kost = zzpkostenArray.get(8);
        kost = (kost * 0.21);
        String afgerond = String.format("%.0f",kost);
        System.out.println("Let op: dit is een schatting van je maandelijkse omzetbelasting die je elk kwartaal moet betalen. Dus het bedrag zal ongeveer 1/3 zijn van wat u elk kwartaal moet betalen.");
        System.out.println("Maandelijkse omzetbelasting: €" + afgerond);
    }
    public void updateKosten(String naam, double waarde) {
        if (kostenMap.containsKey(naam)) {
            kostenMap.put(naam, waarde);
        }
    }


}
