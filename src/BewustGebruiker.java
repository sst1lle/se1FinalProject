import Categorieen.*;

import java.util.ArrayList;

public class BewustGebruiker extends Gebruiker {
    private BewustKosten bewustKosten;
    CategorieSparen sparen;
    CategorieHuisKosten huisKosten;
    CategorieOverig overig;
    CategorieVrijeTIjd vrijeTIjd;


    @Override
    public void invullenKosten() {
        System.out.println("U hebt gekozen voor de optie financieel bewust persoon, u zal nu uw kosten moeten invullen gerelateerd aan normale kosten, als u denkt dat een bepaalde kostenpost irrelevant is voor u, vul dan 0 in.");
        System.out.println("Let op: deze kosten moeten op maandelijkse basis worden ingevuld.");

        double inkomen = readPositiveDoubleInput("Inkomen: ");
        double belastingkosten = readPositiveDoubleInput("Belastingkosten: ");
        double investeringen = readPositiveDoubleInput("Investeringen: ");
        double huurkosten = readPositiveDoubleInput("Huurkosten: ");
        double energieEnGasEnWaterKosten = readPositiveDoubleInput("Kosten Gas+Licht+Water: ");
        double boodschappengeld = readPositiveDoubleInput("Boodschappengeld: ");
        double reiskosten = readPositiveDoubleInput("Reiskosten: ");
        double abbonementen = readPositiveDoubleInput("Abbonementen: ");
        double persoonlijkeVerzorging = readPositiveDoubleInput("Persoonlijke verzorging: ");
        double shopgeld = readPositiveDoubleInput("Shopgeld: ");
        double spaarVoorNoodsituaties = readPositiveDoubleInput("Spaargeld voor noodsituaties: ");
        double schulden = readPositiveDoubleInput("Schulden: ");
        double spaargeld = readPositiveDoubleInput("Spaargeld: ");
        double budgetEntertainment = readPositiveDoubleInput("Geld voor entertainment: ");
        double budgetPersoonlijkeOntwikkeling = readPositiveDoubleInput("Geld voor persoonlijke ontwikkeling: ");
        double verzekeringen = readPositiveDoubleInput("Verzekeringen: ");
        System.out.println();

        bewustKosten = new BewustKosten(inkomen,belastingkosten,huurkosten,energieEnGasEnWaterKosten,reiskosten,0,boodschappengeld,shopgeld,abbonementen,persoonlijkeVerzorging,spaargeld,verzekeringen,investeringen,spaarVoorNoodsituaties,schulden,budgetEntertainment,budgetPersoonlijkeOntwikkeling);
        sparen = new CategorieSparen(investeringen,spaargeld);
        huisKosten = new CategorieHuisKosten(huurkosten,energieEnGasEnWaterKosten,boodschappengeld,persoonlijkeVerzorging);
        overig = new CategorieOverig(belastingkosten,verzekeringen,spaarVoorNoodsituaties);
        vrijeTIjd = new CategorieVrijeTIjd(budgetEntertainment,budgetPersoonlijkeOntwikkeling,shopgeld);
    }



    @Override
    public void toonMenu() {
        System.out.println("1. Categoriseer kosten");
        System.out.println("2. Kan de gebruiker zijn schulden betalen");
        System.out.println("3. Afsluiten");
    }

    @Override
    public void verwerkOptie(int optie) {
        switch (optie) {
            case 1:
                // Categoriseer kosten
                System.out.println();
                KostenCategorie categorie = new KostenCategorie();
                categorie.voegCategorieToe(sparen,huisKosten,overig,vrijeTIjd);
                categorie.toonCategorieKosten(sparen,huisKosten,overig,vrijeTIjd);
                System.out.println("--------------------------------------------------------------");
                break;
            case 2:
                // Kan de gebruiker zijn schulden betalen
                ArrayList<Double> kosten2 = bewustKosten.getKosten();
                BerekenSchuld schuld = new BerekenSchuld();
                schuld.betaalSchulden(kosten2);
                System.out.println("\n--------------------------------------------------------------");
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
