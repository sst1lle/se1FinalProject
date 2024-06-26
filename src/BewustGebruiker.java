import Categorieen.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class BewustGebruiker extends Gebruiker {
    private BewustKosten bewustKosten;
    CategorieSparen sparen;
    CategorieHuisKosten huisKosten;
    CategorieOverig overig;
    CategorieVrijeTIjd vrijeTIjd;


    @Override
    public void invullenKosten() {
        LeesScanner sc = new LeesScanner();
        System.out.println("U hebt gekozen voor de optie financieel bewust persoon, u zal nu uw kosten moeten invullen gerelateerd aan normale kosten, als u denkt dat een bepaalde kostenpost irrelevant is voor u, vul dan 0 in.");
        System.out.println("Let op: deze kosten moeten op maandelijkse basis worden ingevuld.");

        double inkomen = sc.readPositiveDoubleInput("Inkomen: ");
        double belastingkosten = sc.readPositiveDoubleInput("Belastingkosten: ");
        double investeringen = sc.readPositiveDoubleInput("Investeringen: ");
        double huurkosten = sc.readPositiveDoubleInput("Huurkosten: ");
        double energieEnGasEnWaterKosten = sc.readPositiveDoubleInput("Kosten Gas+Licht+Water: ");
        double boodschappengeld = sc.readPositiveDoubleInput("Boodschappengeld: ");
        double reiskosten = sc.readPositiveDoubleInput("Reiskosten: ");
        double abbonementen = sc.readPositiveDoubleInput("Abbonementen: ");
        double persoonlijkeVerzorging = sc.readPositiveDoubleInput("Persoonlijke verzorging: ");
        double shopgeld = sc.readPositiveDoubleInput("Kledinggeld: ");
        double spaarVoorNoodsituaties = sc.readPositiveDoubleInput("Spaargeld voor noodsituaties: ");
        double schulden = sc.readPositiveDoubleInput("Schulden: ");
        double spaargeld = sc.readPositiveDoubleInput("Spaargeld: ");
        double budgetEntertainment = sc.readPositiveDoubleInput("Geld voor entertainment: ");
        double budgetPersoonlijkeOntwikkeling = sc.readPositiveDoubleInput("Geld voor persoonlijke ontwikkeling: ");
        double verzekeringen = sc.readPositiveDoubleInput("Verzekeringen: ");
        System.out.println();

        bewustKosten = new BewustKosten(inkomen,belastingkosten,huurkosten,energieEnGasEnWaterKosten,reiskosten,0,boodschappengeld,shopgeld,abbonementen,persoonlijkeVerzorging,spaargeld,verzekeringen,investeringen,spaarVoorNoodsituaties,schulden,budgetEntertainment,budgetPersoonlijkeOntwikkeling);
        sparen = new CategorieSparen(investeringen,spaargeld);
        huisKosten = new CategorieHuisKosten(huurkosten,energieEnGasEnWaterKosten,boodschappengeld,persoonlijkeVerzorging);
        overig = new CategorieOverig(belastingkosten,verzekeringen,spaarVoorNoodsituaties);
        vrijeTIjd = new CategorieVrijeTIjd(budgetEntertainment,budgetPersoonlijkeOntwikkeling,shopgeld);
        bewustKosten.addObserver(new KostenObserver());
    }



    @Override
    public void toonMenu() {
        System.out.println("1. Categoriseer kosten");
        System.out.println("2. Kan ik mijn schulden betalen?");
        System.out.println("3. Wijzig een specifieke kost");
        System.out.println("4. Update je kostenlijst");
        System.out.println("5. Afsluiten");
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
                // Wijzig een specifieke kost
                wijzigSpecifiekeKost();
                break;
            case 4:
                // Update kostenlijst
                bewustKosten.notifyObservers();
                break;
            case 5:
                // Afsluiten
                System.out.println("Programma afgesloten.");
                System.exit(0);
                break;
            default:
                System.out.println("Ongeldige keuze. Probeer opnieuw.");
                break;
        }
    }

    private void wijzigSpecifiekeKost() {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> kostenMap = bewustKosten.getKostenMap();
        System.out.print("Voer de naam van de kost in die u wilt wijzigen,\nLET OP: hoofdlettergevoelig\nVul hier in:   ");
        String naam = scanner.nextLine();
        System.out.print("Voer het nieuwe bedrag in: ");
        double nieuwBedrag = scanner.nextDouble();
        KostenWijzigen.wijzigKost(kostenMap, naam, nieuwBedrag);
        bewustKosten.updateKosten(naam, nieuwBedrag); // Zorg ervoor dat de wijzigingen worden doorgevoerd
    }
}
