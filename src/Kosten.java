import java.util.ArrayList;

public class Kosten {

    private ArrayList<Double> kosten;
    private double inkomen;
    private double belastingkosten;
    private double huurkosten;
    private double energieEnGasEnWaterKosten;
    private double reiskosten;
    private double marketingkosten;
    private double boodschappengeld;
    private double shopgeld;
    private double abbonementen;
    private double persoonlijkeVerzorging;
    private double spaargeld;
    private double verzekeringen;

                        //Long parameter list, ik weet hiervan, maar de enige oplossing die ik denk ik kan vinden hiervoor is door gebruik te maken van een builder pattern, wat eigenlijk niet helemaal het probleem oplost, omdat ik dan alsnog een lange parameter zal krijgen met het woord .builder() ertusssen.
    public Kosten(double inkomen, double belastingkosten,double huurkosten, double energieEnGasEnWaterKosten, double reiskosten,
                  double marketingkosten, double boodschappengeld, double shopgeld, double abbonementen,
                  double persoonlijkeVerzorging, double spaargeld, double verzekeringen) {
        this.inkomen  = inkomen;
        this.belastingkosten = belastingkosten;
        this.huurkosten = huurkosten;
        this.energieEnGasEnWaterKosten = energieEnGasEnWaterKosten;
        this.reiskosten = reiskosten;
        this.marketingkosten = marketingkosten;
        this.boodschappengeld = boodschappengeld;
        this.shopgeld = shopgeld;
        this.abbonementen = abbonementen;
        this.persoonlijkeVerzorging = persoonlijkeVerzorging;
        this.spaargeld = spaargeld;
        this.verzekeringen = verzekeringen;
        this.kosten = new ArrayList<>();

        voegKostenToe(inkomen, belastingkosten, huurkosten, energieEnGasEnWaterKosten, reiskosten, marketingkosten, boodschappengeld, shopgeld, abbonementen, persoonlijkeVerzorging, spaargeld, verzekeringen);

    }
    public void voegKostenToe(double... kostenArray) {
        for (double kost : kostenArray) {
            this.kosten.add(kost);
        }
    }
    public ArrayList<Double> getKosten() {
        return this.kosten;
    }
}
