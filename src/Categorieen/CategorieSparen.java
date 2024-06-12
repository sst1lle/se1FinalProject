package Categorieen;

import java.util.ArrayList;

public class CategorieSparen implements CategorieKosten{
   private ArrayList<Double> sparenArray = new ArrayList<>();

   public CategorieSparen(double investeringen, double spaarGeld){
       sparenArray.add(investeringen);
       sparenArray.add(spaarGeld);
   }


    @Override
    public ArrayList<Double> getKosten() {
        return sparenArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Uw gespaard geld: ");
        double totaal = 0;
        for (double kost : sparenArray) {
            totaal += kost;
        }
        sb.append(String.format("\nTotale spaargeld: €%.2f\n", totaal));
        return sb.toString();
    }
}
