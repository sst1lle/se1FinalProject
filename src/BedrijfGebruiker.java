import Categorieen.*;

import java.util.ArrayList;

public class BedrijfGebruiker extends Gebruiker {
    private KleinBedrijfKosten bedrijfKosten;
    private double omzet;
    CategorieSparen sparen;
    CategorieHuisKosten huisKosten;
    CategorieOverig overig;
    CategorieBedrijfKosten cBedrijfKosten;

    @Override
    public void invullenKosten() {
        System.out.println("U hebt gekozen voor de optie voor Klein bedrijf, u zal nu uw kosten moeten invullen gerelateerd aan kosten voor een klein bedrijf, als u denkt dat een bepaalde kostenpost irrelevant is voor u, vul dan 0 in.");

         omzet = readPositiveDoubleInput("Omzet: ");
        double huurkosten = readPositiveDoubleInput("Kosten voor huur of lening van bedrijfspand: ");
        double nutsvoorzieningenKosten = readPositiveDoubleInput("Kosten voor nutsvoorzieningen (gas, water, elektriciteit): ");
        double grondstoffenOfProductenKosten = readPositiveDoubleInput("Kosten voor grondstoffen of producten: ");
        double reiskosten = readPositiveDoubleInput("Reiskosten voor zakelijke doeleinden: ");
        double abbonementen = readPositiveDoubleInput("Kosten voor abonnementen: ");
        double marketingkosten = readPositiveDoubleInput("Kosten voor marketing en reclame: ");
        double spaargeld = readPositiveDoubleInput("Spaargeld of reservefonds voor het bedrijf: ");
        double personeelsKosten = readPositiveDoubleInput("Kosten voor personeel: ");
        double administratieKosten = readPositiveDoubleInput("Kosten voor administratie: ");
        double verzekeringen = readPositiveDoubleInput("Kosten voor verzekeringen: ");
        double belastingKosten = readPositiveDoubleInput("Kosten voor belastingen: ");
        System.out.println();

        bedrijfKosten = new KleinBedrijfKosten(0,belastingKosten,huurkosten,nutsvoorzieningenKosten,reiskosten,marketingkosten,0,0,abbonementen,0,spaargeld,verzekeringen,omzet,grondstoffenOfProductenKosten,personeelsKosten,administratieKosten);
        sparen = new CategorieSparen(0,spaargeld);
        huisKosten = new CategorieHuisKosten(huurkosten,nutsvoorzieningenKosten,0,0);
        overig = new CategorieOverig(belastingKosten,verzekeringen,0);
        cBedrijfKosten = new CategorieBedrijfKosten(marketingkosten,reiskosten,grondstoffenOfProductenKosten,personeelsKosten,administratieKosten);
    }

    @Override
    public void toonMenu() {
        System.out.println("1. Categoriseer kosten");
        System.out.println("2. Bereken winst");
        System.out.println("3. Bereken je BTW");
        System.out.println("4. Afsluiten");
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
                bedrijfKosten.berekenBTW(omzet);
                System.out.println("--------------------------------------------------------------");
                break;
            case 4:
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
