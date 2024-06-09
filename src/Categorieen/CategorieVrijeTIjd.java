package Categorieen;

import java.util.ArrayList;

public class CategorieVrijeTIjd implements CategorieKosten{

    private ArrayList<Double> vrijeTijdArray = new ArrayList<>();

    public CategorieVrijeTIjd(double budgetEntertainment, double budgetPersoonlijkeOntwikkeling,double kledingGeld){
        vrijeTijdArray.add(budgetEntertainment);
        vrijeTijdArray.add(budgetPersoonlijkeOntwikkeling);
        vrijeTijdArray.add(kledingGeld);
    }
    @Override
    public ArrayList<Double> getKosten() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Vrije tijd: ");
        double totaal = 0;
        for (double kost : vrijeTijdArray) {
            sb.append(String.format("€%.2f ", kost));
            totaal += kost;
        }
        sb.append(String.format("\nTotale vermogen voor uw vrije tijd: €%.2f\n", totaal));
        return sb.toString();
    }
}
