package Categorieen;

import java.util.ArrayList;

public class CategorieOverig implements CategorieKosten{
    private ArrayList<Double>overigArray = new ArrayList<>();

    public CategorieOverig(double belastingKosten, double verzekeringen, double spaarVoorNoodSituaties){
        overigArray.add(belastingKosten);
        overigArray.add(verzekeringen);
        overigArray.add(spaarVoorNoodSituaties);
    }
    @Override
    public ArrayList<Double> getKosten() {
        return overigArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Overige Kosten: ");
        double totaal = 0;
        for (double kost : overigArray) {
            totaal += kost;
        }
        sb.append(String.format("\nTotale overige kosten: €%.2f\n", totaal));
        return sb.toString();
    }
}
