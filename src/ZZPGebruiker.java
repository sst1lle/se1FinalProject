import Categorieen.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

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
        LeesScanner sc = new LeesScanner();
        System.out.println("U hebt gekozen voor de optie voor ZZP'ers, u zal nu uw kosten/inkomen moeten invullen gerelateerd aan ZZP kosten, als u denkt dat een bepaalde kostenpost irrelevant is voor u, vul dan 0 in.");

         inkomen += sc.readPositiveDoubleInput("Inkomen: ");
        double belastingkosten = sc.readPositiveDoubleInput("Belastingkosten: ");
        double huurkosten = sc.readPositiveDoubleInput("Huurkosten: ");
        double energieEnGasEnWaterKosten = sc.readPositiveDoubleInput("Gas Water en Licht: ");
        double boodschappengeld = sc.readPositiveDoubleInput("Boodschappengeld: ");
        double shopgeld = sc.readPositiveDoubleInput("Kledinggeld: ");
        double marketingkosten = sc.readPositiveDoubleInput("Marketingkosten: ");
        double reiskosten = sc.readPositiveDoubleInput("Reiskosten: ");
        double abbonementen = sc.readPositiveDoubleInput("Abbonementen: ");
        double verzekeringen = sc.readPositiveDoubleInput("Verzekeringen: ");
        double persoonlijkeVerzorging = sc.readPositiveDoubleInput("Persoonlijke verzorging: ");
        double spaargeld = sc.readPositiveDoubleInput("Spaargeld: ");
        double administratieKosten = sc.readPositiveDoubleInput("Administratiekosten: ");
        System.out.println();

        zzpKosten = new ZZPKosten(inkomen,belastingkosten,huurkosten,energieEnGasEnWaterKosten,reiskosten,marketingkosten,boodschappengeld,shopgeld,abbonementen,persoonlijkeVerzorging,spaargeld,verzekeringen,administratieKosten);
        sparen = new CategorieSparen(0,spaargeld);
        bedrijfKosten = new CategorieBedrijfKosten(marketingkosten,reiskosten,0,0,administratieKosten);
        huisKosten = new CategorieHuisKosten(huurkosten,energieEnGasEnWaterKosten,boodschappengeld,persoonlijkeVerzorging);
        overig = new CategorieOverig(belastingkosten,verzekeringen,0);
        vrijeTIjd = new CategorieVrijeTIjd(0,0,shopgeld);
        zzpKosten.addObserver(new KostenObserver());
    }

    @Override
    public void toonMenu() {
        System.out.println("1. Bereken BTW");
        System.out.println("2. Categoriseer kosten");
        System.out.println("3. Wijzig een specifieke kost");
        System.out.println("4. Update je kostenlijst");
        System.out.println("5. Afsluiten");
    }

    @Override
    public void verwerkOptie(int optie) {
        switch (optie) {
            case 1:
                // Bereken BTW
                System.out.println();
                ArrayList<Double> kosten = zzpKosten.getKosten();
                zzpKosten.berekenBTW(kosten);
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
                // Wijzig een specifieke kost
                wijzigSpecifiekeKost();
                break;
            case 4:
                // Update kostenlijst
                zzpKosten.notifyObservers();
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
        Map<String, Double> kostenMap = zzpKosten.getKostenMap();

        System.out.print("Voer de naam van de kost in die u wilt wijzigen,\nLET OP: hoofdlettergevoelig\nVul hier in:   ");
        String naam = scanner.nextLine();
        System.out.print("Voer het nieuwe bedrag in: ");
        double nieuwBedrag = scanner.nextDouble();
        KostenWijzigen.wijzigKost(kostenMap, naam, nieuwBedrag);
        zzpKosten.updateKosten(naam, nieuwBedrag); // Zorg ervoor dat de wijzigingen worden doorgevoerd
    }
}
