import java.util.ArrayList;

class KleinBedrijfKosten extends Kosten implements BerekenBTW{
    private ArrayList<Double> kbkostenArray;
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

        voegKBKostenToe(omzet,grondstoffenOfProductenKosten,personeelsKosten,administratieKosten);
    }
    public void voegKBKostenToe(double... kbkostenArray) {
        voegKostenToe(kbkostenArray);
    }


    @Override
    public void berekenBTW(double kost) {
        kost = (kost * 0.21);
        String afgerond = String.format("%.0f",kost);
        System.out.println("Let op: dit is een schatting van je maandelijkse omzetbelasting die je elk kwartaal moet betalen. Dus het bedrag zal ongeveer 1/3 zijn van wat u elk kwartaal moet betalen.");
        System.out.println("Maandelijkse omzetbelasting: €" + afgerond);
    }

}
