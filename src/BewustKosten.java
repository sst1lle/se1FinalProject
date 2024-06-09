import java.util.ArrayList;

public class BewustKosten extends Kosten {
    private ArrayList<Double> bewustKostenArray;
    private double investeringen;
    private double spaarVoorNoodsituaties;
    private double schulden;
    private double budgetEntertainment;
    private double budgetPersoonlijkeOntwikkeling;
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

        voegBewustKostenToe(investeringen,spaarVoorNoodsituaties,schulden,budgetEntertainment,budgetPersoonlijkeOntwikkeling);
    }

    // Methode om kosten toe te voegen aan de arraylist
    public void voegBewustKostenToe(double... bewustKostenArray) {
        voegKostenToe(bewustKostenArray);

    }




}
