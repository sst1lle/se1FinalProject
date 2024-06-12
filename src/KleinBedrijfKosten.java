import java.util.*;

class KleinBedrijfKosten extends Kosten implements BerekenBTW{
    private ArrayList<Double> kbkostenArray;
    private Map<String, Double> kostenMap;
    private double omzet;
    private double grondstoffenOfProductenKosten;
    private double personeelsKosten;
    private double administratieKosten;
    private List<Observer> observers;



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
        this.observers = new ArrayList<>();
        kostenMap = new HashMap<>();
        kostenMap.put("Inkomen", inkomen);
        kostenMap.put("Kosten voor belastingen", belastingkosten);
        kostenMap.put("Kosten voor huur of lening van bedrijfspand", huurkosten);
        kostenMap.put("Kosten voor nutsvoorzieningen (gas, water, elektriciteit)", energieEnGasEnWaterKosten);
        kostenMap.put("Reiskosten voor zakelijke doeleinden", reiskosten);
        kostenMap.put("Kosten voor marketing en reclame", marketingkosten);
        kostenMap.put("Boodschappengeld", boodschappengeld);
        kostenMap.put("Kledinggeld", shopgeld);
        kostenMap.put("Kosten voor abonnementen", abbonementen);
        kostenMap.put("Persoonlijke verzorging", persoonlijkeVerzorging);
        kostenMap.put("Spaargeld of reservefonds voor het bedrijf", spaargeld);
        kostenMap.put("Kosten voor verzekeringen", verzekeringen);
        kostenMap.put("Omzet", omzet);
        kostenMap.put("Kosten voor grondstoffen of producten",grondstoffenOfProductenKosten);
        kostenMap.put("Kosten voor personeel",personeelsKosten);
        kostenMap.put("Kosten voor administratie",administratieKosten);

        voegKBKostenToe(omzet,grondstoffenOfProductenKosten,personeelsKosten,administratieKosten);
    }
    @Override
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

        double kost = kbkostenArray.get(4);
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
    // Observer methods

    public void addObserver(Observer observer) {
        observers.add(observer);
    }


    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(kostenMap);
        }
    }

}
