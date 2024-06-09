package Categorieen;

import java.util.ArrayList;

public class CategorieHuisKosten implements CategorieKosten{

    private ArrayList<Double> huisKostenArray = new ArrayList<>();

    public CategorieHuisKosten(double huurKosten, double GWL, double boodschappenGeld, double persoonlijkeVerzorging){
        huisKostenArray.add(huurKosten);
        huisKostenArray.add(GWL);
        huisKostenArray.add(boodschappenGeld);
        huisKostenArray.add(persoonlijkeVerzorging);
    }


    @Override
    public ArrayList<Double> getKosten() {
        return huisKostenArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Huiselijke Kosten of kosten voor uw pand: ");
        double totaal = 0;
        for (double kost : huisKostenArray) {
            sb.append(String.format("€%.2f ", kost));
            totaal += kost;
        }
        sb.append(String.format("\nTotale huiselijke kosten: €%.2f\n", totaal));
        return sb.toString();
    }
}
