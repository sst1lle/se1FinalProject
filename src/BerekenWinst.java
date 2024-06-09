import java.util.ArrayList;

public class BerekenWinst {
    private double omzet;
    private double totaleKosten;
    private double rest;

    public void berekenWinst(ArrayList<Double> kosten){
        for (double kost : kosten){
            System.out.println(kost);
        }
        omzet += kosten.get(12);
        totaleKosten += kosten.get(1);
        totaleKosten += kosten.get(2);
        totaleKosten += kosten.get(3);
        totaleKosten += kosten.get(4);
        totaleKosten += kosten.get(5);
        totaleKosten += kosten.get(6);
        totaleKosten += kosten.get(8);
        totaleKosten += kosten.get(9);
        totaleKosten += kosten.get(13);
        totaleKosten += kosten.get(11);
        totaleKosten += kosten.get(14);
        totaleKosten += kosten.get(15);
        omzet += kosten.get(10);//spaargeld meegeven aan omzet
        rest += (omzet - totaleKosten);
        System.out.println("Let op: er volgt nu aan schatting van uw maandelijkse winst, uw spaargeld is inbegrepen bij de winst");
        System.out.println();
        if (rest >= 0){
            System.out.printf("Uw winst: €%.0f",rest);
            System.out.println();
        }
        else {
            System.out.println("U heeft deze maand helaas geen winst.");
        }


    }
}
