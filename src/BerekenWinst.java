import java.util.ArrayList;

public class BerekenWinst {
    private double omzet;
    private double totaleKosten;


    public void berekenWinst(ArrayList<Double> kosten){
        for(double kost : kosten){
            System.out.println(kost);
        }

        omzet += kosten.get(4);
        totaleKosten += kosten.get(1);
        totaleKosten += kosten.get(7);
        totaleKosten += kosten.get(0);
        totaleKosten += kosten.get(5);
        totaleKosten += kosten.get(2);
        totaleKosten += kosten.get(8);
        totaleKosten += kosten.get(9);
        totaleKosten += kosten.get(14);
        totaleKosten += kosten.get(15);
        totaleKosten += kosten.get(10);
        totaleKosten += kosten.get(12);
        double spaar = kosten.get(6);
        omzet += spaar;
        omzet = (omzet - totaleKosten);
        System.out.println("Let op: er volgt nu aan schatting van uw maandelijkse winst, uw spaargeld is inbegrepen bij de winst");
        System.out.println();
        if (omzet >= 0){
            System.out.printf("Uw winst: €%.0f",omzet);
            System.out.println();
        }
        else {
            System.out.println("U heeft deze maand helaas geen winst.");
        }


    }
}
