import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class KleinBedrijfKosten extends Kosten implements BerekenBTW{
    private ArrayList<Double> kbkostenArray;
    private Map<String, Double> kostenMap;
    private double omzet;
    private double grondstoffenOfProductenKosten;
    private double personeelsKosten;
    private double administratieKosten;



    public KleinBedrijfKosten(double inkomen, double belastingkosten, double huurkosten, double energieEnGasEnWaterKosten, double reiskosten,
                     double marketingkosten, double boodschappengeld, double shopgeld, double abbonementen,
                     double persoonlijkeVerzorging, double spaargeld, double verzekeringen
                     , double omzet, double grondstoffenOfProductenKosten,double personeelsKosten,double administratieKosten) {
        super(inkomen, belastingkosten, huurkosten, energieEnGasEnWaterKosten, reiskosten, marketingkosten, boodschappengeld, shopgeld, abbonementen, persoonlijkeVerzorging, spaargeld, verzekeringen);
        this.omzet = omzet;
        this.grondstoffenOfProductenKosten = grondstoffenOfProductenKosten;
        this.personeelsKosten = personeelsKosten;
        this.administratieKosten =administratieKosten;
        this.kbkostenArray = new ArrayList<>();
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
        kostenMap.put("Omzet", omzet);
        kostenMap.put("Grondstoffen of Proudctiekosten",grondstoffenOfProductenKosten);
        kostenMap.put("Personeelskosten",personeelsKosten);
        kostenMap.put("Administratiekosten",administratieKosten);

        voegKBKostenToe(omzet,grondstoffenOfProductenKosten,personeelsKosten,administratieKosten);
    }
    public Map<String, Double> getKostenMap() {
        return kostenMap;
    }
    @Override
    public ArrayList<Double> getKosten() {
        return new ArrayList<>(kostenMap.values());
    }
    public void voegKBKostenToe(double... kbkostenArray) {
        voegKostenToe(kbkostenArray);
    }


    @Override
    public void berekenBTW(ArrayList<Double> kbkostenArray) {

        double kost = kbkostenArray.get(3);
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
