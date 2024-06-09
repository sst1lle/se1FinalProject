import java.util.ArrayList;

public class BerekenSchuld {

    private double inkomen;
    private double totaleKosten;
    private double rest;

    //methode om te checken of de gebruiker na het aftrekken van alle normale kosten, zijn of haar schulden nog kan betalen.
    public void betaalSchulden(ArrayList<Double> kosten){

        inkomen += kosten.getFirst();

        System.out.println("Deze optie laat zien of je je schulden nog kan betalen nadat je al je maandelijkse kosten hebt betaald, budgetten en spaargeld worden niet meegerekend in deze berekening.");
        totaleKosten += (kosten.get(1)); //specifieke kosten die in een bepaalde volgorde ziten in de arraylist toevoegen aan totalekosten
        totaleKosten += (kosten.get(2));
        totaleKosten += (kosten.get(3));
        totaleKosten += (kosten.get(4));
        totaleKosten += (kosten.get(6));
        totaleKosten += (kosten.get(7));
        totaleKosten += (kosten.get(8));
        totaleKosten += (kosten.get(9));
        totaleKosten += (kosten.get(11));
        totaleKosten += (kosten.get(14));
        rest += inkomen - totaleKosten;
        double schulden= kosten.get(10);
        System.out.println("Kunt u uw schulden betalen?");
        if (rest >= schulden){
            rest -= schulden;

            System.out.printf("\nU kunt uw schulden wel betalen. Het bedrag wat u overhoudt na het betalen van uw schulden: €%.0f",rest);
        }
        else {
            System.out.println("\nU kunt uw schulden niet betalen na het betalen van uw maandelijkse kosten.");
        }
    }
}
