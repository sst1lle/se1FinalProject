import java.util.Scanner;

public class MenuBeginScherm {
    LeesScanner leesScanner= new LeesScanner();


    public void start() {
        System.out.println("Welkom bij de Kostenbeheer Applicatie!\n");
        System.out.println("Wat voor gebruiker ben je in dit programma?");
        System.out.println("1. Ik ben ZZP'er en wil graag een overzicht van mijn kosten en BTW.");
        System.out.println("2. Ik ben een financieel bewust persoon en wil graag mijn kosten overzichtelijk zien.");
        System.out.println("3. Ik ben de eigenaar van een bedrijf en wil graag mijn financiën en analyses zien.\n");

        System.out.print("Kies een optie: ");
        int optie = leesScanner.readIntInput(1, 3);

        Gebruiker gebruiker;
        switch (optie) {
            case 1:
                gebruiker = new ZZPGebruiker();
                break;
            case 2:
                gebruiker = new BewustGebruiker();
                break;
            case 3:
                gebruiker = new BedrijfGebruiker();
                break;
            default:
                throw new IllegalArgumentException("Ongeldige optie");
        }

        gebruiker.invullenKosten();
        boolean doorgaan = true;
        while (doorgaan) {
            gebruiker.toonMenu();
            int keuze = leesScanner.readIntInput(1, 5);
            gebruiker.verwerkOptie(keuze);
        }
    }

}
