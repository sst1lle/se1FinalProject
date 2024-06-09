import Categorieen.*;

public class ZZPGebruiker extends Gebruiker {
    private ZZPKosten zzpKosten;
    private double inkomen;
    CategorieSparen sparen;
    CategorieHuisKosten huisKosten;
    CategorieOverig overig;
    CategorieBedrijfKosten bedrijfKosten;
    CategorieVrijeTIjd vrijeTIjd;
    @Override
    public void invullenKosten() {
        System.out.println("U hebt gekozen voor de optie voor ZZP'ers, u zal nu uw kosten/inkomen moeten invullen gerelateerd aan ZZP kosten, als u denkt dat een bepaalde kostenpost irrelevant is voor u, vul dan 0 in.");

         inkomen += readPositiveDoubleInput("Inkomen: ");
        double belastingkosten = readPositiveDoubleInput("Belastingkosten: ");
        double huurkosten = readPositiveDoubleInput("Huurkosten: ");
        double energieEnGasEnWaterKosten = readPositiveDoubleInput("Gas Water en Licht: ");
        double boodschappengeld = readPositiveDoubleInput("Boodschappengeld: ");
        double shopgeld = readPositiveDoubleInput("Shopgeld: ");
        double marketingkosten = readPositiveDoubleInput("Marketingkosten: ");
        double reiskosten = readPositiveDoubleInput("Reiskosten: ");
        double abbonementen = readPositiveDoubleInput("Abbonementen: ");
        double verzekeringen = readPositiveDoubleInput("Verzekeringen: ");
        double persoonlijkeVerzorging = readPositiveDoubleInput("Persoonlijke verzorging: ");
        double spaargeld = readPositiveDoubleInput("Spaargeld: ");
        double administratieKosten = readPositiveDoubleInput("Administratiekosten: ");
        System.out.println();

        zzpKosten = new ZZPKosten(inkomen,belastingkosten,huurkosten,energieEnGasEnWaterKosten,reiskosten,marketingkosten,boodschappengeld,shopgeld,abbonementen,persoonlijkeVerzorging,spaargeld,verzekeringen,administratieKosten);
        sparen = new CategorieSparen(0,spaargeld);
        bedrijfKosten = new CategorieBedrijfKosten(marketingkosten,reiskosten,0,0,administratieKosten);
        huisKosten = new CategorieHuisKosten(huurkosten,energieEnGasEnWaterKosten,boodschappengeld,persoonlijkeVerzorging);
        overig = new CategorieOverig(belastingkosten,verzekeringen,0);
        vrijeTIjd = new CategorieVrijeTIjd(0,0,shopgeld);
    }

    @Override
    public void toonMenu() {
        System.out.println("1. Bereken BTW");
        System.out.println("2. Categoriseer kosten");
        System.out.println("3. Afsluiten");
    }

    @Override
    public void verwerkOptie(int optie) {
        switch (optie) {
            case 1:
                // Bereken BTW
                System.out.println();
                zzpKosten.berekenBTW(inkomen);
                System.out.println("--------------------------------------------------------------");
                break;
            case 2:
                // Categoriseer kosten
                System.out.println();
                KostenCategorie categorie = new KostenCategorie();
                categorie.voegCategorieToe(huisKosten,sparen,bedrijfKosten,overig,vrijeTIjd);
                categorie.toonCategorieKosten(huisKosten,sparen,bedrijfKosten,overig,vrijeTIjd);
                System.out.println("-------------------------------------------------------------");
                break;
            case 3:
                // Afsluiten
                System.out.println("Programma afgesloten.");
                System.exit(0);
                break;
            default:
                System.out.println("Ongeldige keuze. Probeer opnieuw.");
                break;
        }
    }
}
