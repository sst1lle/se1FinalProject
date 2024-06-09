import java.util.Scanner;

public abstract class Gebruiker {
    protected Scanner scanner = new Scanner(System.in);

    public abstract void invullenKosten();
    public abstract void toonMenu();
    public abstract void verwerkOptie(int optie);

    protected double readPositiveDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Ongeldige invoer. Voer een geldig getal in.");
            System.out.print(prompt);
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
