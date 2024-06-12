import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BewustKosten extends Kosten {

    private Map<String, Double> kostenMap;

    private ArrayList<Double> bewustKostenArray;
    private double investeringen;
    private double spaarVoorNoodsituaties;
    private double schulden;
    private double budgetEntertainment;
    private double budgetPersoonlijkeOntwikkeling;
    private List<Observer> observers;
    // Constructor voor kosten van een financieel bewust persoon

    //Long parameter list, ik weet hiervan, maar de enige oplossing die ik denk ik kan vinden hiervoor is door gebruik te maken van een builder pattern, wat eigenlijk niet helemaal het probleem oplost, omdat ik dan alsnog een lange parameter zal krijgen met het woord .builder() ertusssen.
    public BewustKosten(double inkomen, double belastingkosten,double huurkosten, double energieEnGasEnWaterKosten, double reiskosten,
                        double marketingkosten, double boodschappengeld, double shopgeld, double abbonementen,
                        double persoonlijkeVerzorging, double spaargeld, double verzekeringen, double investeringen, double spaarVoorNoodsituaties, double schulden, double budgetEntertainment, double budgetPersoonlijkeOntwikkeling) {
        super(inkomen,belastingkosten,huurkosten,energieEnGasEnWaterKosten,reiskosten,marketingkosten,boodschappengeld,shopgeld,abbonementen,persoonlijkeVerzorging,spaargeld,verzekeringen);
        this.bewustKostenArray = new ArrayList<>();
        this.investeringen = investeringen;
        this.spaarVoorNoodsituaties = spaarVoorNoodsituaties;
        this.schulden = schulden;
        this.budgetEntertainment = budgetEntertainment;
        this.budgetPersoonlijkeOntwikkeling = budgetPersoonlijkeOntwikkeling;
        this.observers = new ArrayList<>();
        kostenMap = new HashMap<>();
        kostenMap.put("Inkomen", inkomen);
        kostenMap.put("Belastingkosten", belastingkosten);
        kostenMap.put("Huurkosten", huurkosten);
        kostenMap.put("Kosten Gas+Licht+Water", energieEnGasEnWaterKosten);
        kostenMap.put("Reiskosten", reiskosten);
        kostenMap.put("Marketingkosten", marketingkosten);
        kostenMap.put("Boodschappengeld", boodschappengeld);
        kostenMap.put("Kledinggeld", shopgeld);
        kostenMap.put("Abonnementen", abbonementen);
        kostenMap.put("Persoonlijke verzorging", persoonlijkeVerzorging);
        kostenMap.put("Spaargeld", spaargeld);
        kostenMap.put("Verzekeringen", verzekeringen);
        kostenMap.put("Investeringen", investeringen);
        kostenMap.put("Spaargeld voor noodsituaties", spaarVoorNoodsituaties);
        kostenMap.put("Schulden", schulden);
        kostenMap.put("Geld voor entertainment", budgetEntertainment);
        kostenMap.put("Geld voor persoonlijke ontwikkeling", budgetPersoonlijkeOntwikkeling);

        voegBewustKostenToe(investeringen,spaarVoorNoodsituaties,schulden,budgetEntertainment,budgetPersoonlijkeOntwikkeling);
    }

    public Map<String, Double> getKostenMap() {
        return kostenMap;
    }
    @Override
    public ArrayList<Double> getKosten() {
        return new ArrayList<>(kostenMap.values());
    }

    // Methode om kosten toe te voegen aan de arraylist
    public void voegBewustKostenToe(double... bewustKostenArray) {
        voegKostenToe(bewustKostenArray);

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
