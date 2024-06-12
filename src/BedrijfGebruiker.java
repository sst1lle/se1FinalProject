import Categorieen.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class BedrijfGebruiker extends Gebruiker {
    private KleinBedrijfKosten bedrijfKosten;
    private double omzet;
    CategorieSparen sparen;
    CategorieHuisKosten huisKosten;
    CategorieOverig overig;
    CategorieBedrijfKosten cBedrijfKosten;

    @Override
    public void invullenKosten() {
        LeesScanner sc = new LeesScanner();
        System.out.println("U hebt gekozen voor de optie voor Klein bedrijf, u zal nu uw kosten moeten invullen gerelateerd aan kosten voor een klein bedrijf, als u denkt dat een bepaalde kostenpost irrelevant is voor u, vul dan 0 in.");

         omzet = sc.readPositiveDoubleInput("Omzet: ");
        double huurkosten = sc.readPositiveDoubleInput("Kosten voor huur of lening van bedrijfspand: ");
        double nutsvoorzieningenKosten = sc.readPositiveDoubleInput("Kosten voor nutsvoorzieningen (gas, water, elektriciteit): ");
        double grondstoffenOfProductenKosten = sc.readPositiveDoubleInput("Kosten voor grondstoffen of producten: ");
        double reiskosten = sc.readPositiveDoubleInput("Reiskosten voor zakelijke doeleinden: ");
        double abbonementen = sc.readPositiveDoubleInput("Kosten voor abonnementen: ");
        double marketingkosten = sc.readPositiveDoubleInput("Kosten voor marketing en reclame: ");
        double spaargeld = sc.readPositiveDoubleInput("Spaargeld of reservefonds voor het bedrijf: ");
        double personeelsKosten = sc.readPositiveDoubleInput("Kosten voor personeel: ");
        double administratieKosten = sc.readPositiveDoubleInput("Kosten voor administratie: ");
        double verzekeringen = sc.readPositiveDoubleInput("Kosten voor verzekeringen: ");
        double belastingKosten = sc.readPositiveDoubleInput("Kosten voor belastingen: ");
        System.out.println();

        bedrijfKosten = new KleinBedrijfKosten(0,belastingKosten,huurkosten,nutsvoorzieningenKosten,reiskosten,marketingkosten,0,0,abbonementen,0,spaargeld,verzekeringen,omzet,grondstoffenOfProductenKosten,personeelsKosten,administratieKosten);
        sparen = new CategorieSparen(0,spaargeld);
        huisKosten = new CategorieHuisKosten(huurkosten,nutsvoorzieningenKosten,0,0);
        overig = new CategorieOverig(belastingKosten,verzekeringen,0);
        cBedrijfKosten = new CategorieBedrijfKosten(marketingkosten,reiskosten,grondstoffenOfProductenKosten,personeelsKosten,administratieKosten);
        bedrijfKosten.addObserver(new KostenObserver());

    }

    @Override
    public void toonMenu() {
        System.out.println("1. Categoriseer kosten");
        System.out.println("2. Bereken winst");
        System.out.println("3. Bereken je BTW");
        System.out.println("4. Wijzig een specifieke kost");
        System.out.println("5. Update je kostenlijst");
        System.out.println("6. Afsluiten");
    }

    @Override
    public void verwerkOptie(int optie) {
        switch (optie) {
            case 1:
                // Categoriseer kosten
                System.out.println();
                KostenCategorie categorie = new KostenCategorie();
                categorie.voegCategorieToe(sparen,huisKosten,overig,cBedrijfKosten);
                categorie.toonCategorieKosten(cBedrijfKosten,huisKosten,sparen,overig);
                System.out.println("--------------------------------------------------------------");
                break;
            case 2:
                // Bereken winst
                ArrayList<Double> kosten2 = bedrijfKosten.getKosten();
                BerekenWinst winst = new BerekenWinst();
                winst.berekenWinst(kosten2);
                System.out.println("\n--------------------------------------------------------------");
                break;
            case 3:
                //BerekenBTW
                System.out.println();
                ArrayList<Double> kosten = bedrijfKosten.getKosten();
                bedrijfKosten.berekenBTW(kosten);
                System.out.println("--------------------------------------------------------------");
                break;
            case 4:
                //wijzig een kost
                wijzigSpecifiekeKost();
                break;
            case 5:
                // Update kostenlijst
                bedrijfKosten.notifyObservers();
                break;
            case 6:
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
        Map<String, Double> kostenMap = bedrijfKosten.getKostenMap();
        System.out.print("Voer de naam van de kost in die u wilt wijzigen,\nLET OP: hoofdlettergevoelig\nVul hier in:   ");
        String naam = scanner.nextLine();
        System.out.print("Voer het nieuwe bedrag in: ");
        double nieuwBedrag = scanner.nextDouble();
        KostenWijzigen.wijzigKost(kostenMap, naam, nieuwBedrag);
        bedrijfKosten.updateKosten(naam, nieuwBedrag); // Zorg ervoor dat de wijzigingen worden doorgevoerd
    }
}
