package domain;

import org.junit.Before;
import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.*;

public class CirkelTest {
Point2D.Double geldigMiddelpunt;
private Cirkel cirkel;
double geldigeStraal;
    @Before
public void setBefore()
{   geldigMiddelpunt=new Point2D.Double(15,16);;
    geldigeStraal =14;
    cirkel = new Cirkel(geldigMiddelpunt,geldigeStraal);
}
    @Test(expected =  IllegalArgumentException.class)
    public void test_middelpunt_is_leeg_gooit_exception()
{
    new Cirkel(null, 24);
}
@Test(expected = IllegalArgumentException.class)
    public void test_straal_negatief_gooit_exception()
{
    new Cirkel(new Point2D.Double(2,4),-2);
}
@Test(expected = IllegalArgumentException.class)
public void test_straal_groter_dan_x_middelpunt_gooit_exception()
{
    new Cirkel(new Point2D.Double(2,4),5);

}
    @Test(expected = IllegalArgumentException.class)
    public void test_straal_groter_dan_y_middelpunt_gooit_exception()
    {
        new Cirkel(new Point2D.Double(2,4),3);

    }
    @Test
    public void test_nieuw_object_straal_positief_niet_groter_dan_middelpunt_en_middelpunt_niet_leeg_maakt_object()
    {
        Cirkel cirkel = new Cirkel(geldigMiddelpunt,geldigeStraal);
        assertEquals(new Point2D.Double(15,16),cirkel.getMiddelpunt()   );
        assertEquals(14,cirkel.getStraal(),2);
    }
    //er zijn hier geen foute testcases
    @Test
    public void test_oppervlaktemethode_cirkel_geeft_correct_resultaat()
    {
        assertEquals(cirkel.oppervlakte(),cirkel.getStraal()*cirkel.getStraal()*Math.PI,2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_puntInCirkel_middelpunt_leeg_gooit_exception()
    {
        cirkel.puntInCirkel(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_puntInCirkel_middelpunt_gelijk_aan_centraalmiddelpunt_gooit_exception()
    {
        cirkel.puntInCirkel(geldigMiddelpunt);
    }
    @Test
    public void test_puntInCirkel_geldig_punt_geeft_true()
    {
        assertTrue(cirkel.puntInCirkel(new Point2D.Double(17,17)));
    }
    @Test
    public void test_puntInCirkel_geldig_punt_niet_binnen_geeft_false()
    {
        assertFalse(cirkel.puntInCirkel(new Point2D.Double(20000,20000)));
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_vergrotenStraal_factor_negatief_gooit_exception()
    {
        cirkel.vergrotenStraal(-2);
    }
    //de straal zelf kan nooit negatief zijn
    @Test(expected = IllegalArgumentException.class)
    public void test_vergrotenStraal_factor_straal_groter_dan_x_middelpunt_gooit_exception()
    {
        cirkel.vergrotenStraal(3);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_vergrotenStraal_factor_straal_groter_dan_y_middelpunt_gooit_exception()
    {
        cirkel.vergrotenStraal(3);
    }
    @Test
    public void test_vergrotenStraal_vergroot_straal()
    {
        cirkel.vergrotenStraal(0.5);
        assertEquals(cirkel.getStraal(),7,2);
    }
}