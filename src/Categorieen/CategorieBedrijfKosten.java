package Categorieen;

import java.util.ArrayList;

public class CategorieBedrijfKosten implements CategorieKosten{

    private ArrayList<Double> BedrijfsKostenArray = new ArrayList<>();

    public CategorieBedrijfKosten(double marketingkosten, double reiskosten, double grondstoffenOfProductieKosten, double personeelskosten, double administratieKosten)
    {
        BedrijfsKostenArray.add(marketingkosten);
        BedrijfsKostenArray.add(reiskosten);
        BedrijfsKostenArray.add(grondstoffenOfProductieKosten);
        BedrijfsKostenArray.add(personeelskosten);
        BedrijfsKostenArray.add(administratieKosten);
    }

    @Override
    public ArrayList<Double> getKosten() {
        return BedrijfsKostenArray;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Bedrijfskosten: ");
        double totaal = 0;
        for (double kost : BedrijfsKostenArray) {
            sb.append(String.format("€%.2f ", kost));
            totaal += kost;
        }
        sb.append(String.format("\nTotale Bedrijfskosten: €%.2f\n", totaal));
        return sb.toString();
    }
}
