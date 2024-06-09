import java.util.Scanner;

public class LeesScanner {

    //methode om invoer te checken of die correct is.
    int readIntInput(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Ongeldige invoer. Voer alstublieft een nummer in tussen " + min + " en " + max + ".");
                scanner.next();
            }
            input = scanner.nextInt();
            if (input < min || input > max) {
                System.out.println("Ongeldige keuze. Voer een nummer in tussen " + min + " en " + max + ".");
            }
        } while (input < min || input > max);
        return input;
    }

    //methode om invoer te checken of die correct is.
    double readPositiveDoubleInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        double input;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextDouble()) {
                System.out.println("Ongeldige invoer. Voer een geldig getal in.");
                scanner.next();
            }
            input = scanner.nextDouble();
            if (input < 0) {
                System.out.println("Invoer moet positief zijn. Voer opnieuw in.");
            }
        } while (input < 0);
        return input;
    }
}
