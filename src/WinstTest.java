import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class WinstTest {

    //Testgevallen voor BerekenWinst
    @Test
    public void testBerekenWinstGeenWinst(){
        ArrayList<Double> kosten = new ArrayList<Double>();
        kosten.addAll(Arrays.asList(5000.0,0.0,0.0,0.0,6000.0,0.0,0.0,1000.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0));
        BerekenWinst winst = new BerekenWinst();
        winst.berekenWinst(kosten);

        assertEquals(0.0,winst.getOmzet(),0.01);
    }
    @Test
    public void testBerekenWinstWelWinst(){
        ArrayList<Double> kosten = new ArrayList<Double>();
        kosten.addAll(Arrays.asList(5000.0,0.0,0.0,0.0,7000.0,0.0,0.0,1000.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0));
        BerekenWinst winst = new BerekenWinst();
        winst.berekenWinst(kosten);

        assertEquals(1000.0,winst.getOmzet(),0.01);
    }
    @Test
    public void testBerekenWinstGeenWinstVeelSchulden(){
        ArrayList<Double> kosten = new ArrayList<Double>();
        kosten.addAll(Arrays.asList(5000.0,0.0,0.0,0.0,6000.0,0.0,0.0,3000.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0));
        BerekenWinst winst = new BerekenWinst();
        winst.berekenWinst(kosten);

        assertEquals(-2000.0,winst.getOmzet(),0.01);
    }
    @Test
    public void TestBerekenWinstWelWinstVeelSchulden(){
        ArrayList<Double> kosten = new ArrayList<Double>();
        kosten.addAll(Arrays.asList(5000.0,0.0,0.0,0.0,10000.0,0.0,0.0,3000.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0));
        BerekenWinst winst = new BerekenWinst();
        winst.berekenWinst(kosten);

        assertEquals(2000.0,winst.getOmzet(),0.01);
    }
    @Test public void TestBerekenWinstWelWinstWeinigSchulden(){
        ArrayList<Double> kosten = new ArrayList<Double>();
        kosten.addAll(Arrays.asList(5000.0,0.0,0.0,0.0,10000.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0));
        BerekenWinst winst = new BerekenWinst();
        winst.berekenWinst(kosten);

        assertEquals(5000.0,winst.getOmzet(),0.01);
    }
    @Test
    public void TestBerekenWinstGeenWinstWeinigSchulden(){
        ArrayList<Double> kosten = new ArrayList<Double>();
        kosten.addAll(Arrays.asList(5000.0,0.0,0.0,0.0,4000.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0));
        BerekenWinst winst = new BerekenWinst();
        winst.berekenWinst(kosten);

        assertEquals(-1000.0,winst.getOmzet(),0.01);
    }


}
