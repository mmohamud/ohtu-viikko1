package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void yritetaanOttaaLiikaaTavaraa() {
        varasto.otaVarastosta(15);
        
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void yritetaanLaittaaLiikaaTavaraa() {
        varasto.lisaaVarastoon(15);
        
        assertEquals(0, varasto.paljonkoMahtuu(), vertailuTarkkuus);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void yritetaanLisataNegatiivinenMaaraTavaraaVarastoon() {
        varasto.lisaaVarastoon(-5);
        
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void yritetaanOttaaNegatiivinenMaaraTavaraaVarastosta() {
        Varasto varasto1 = new Varasto(10, 5);
        
        varasto.otaVarastosta(-5);
        
        assertEquals(10, varasto1.getTilavuus(), vertailuTarkkuus);
        assertEquals(5, varasto1.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriTest1() {
        Varasto varasto2 = new Varasto(-5);
        
        assertEquals(0, varasto2.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriTest2() {
        Varasto varasto3 = new Varasto(-5, -5);
        
        assertEquals(0, varasto3.getTilavuus(), vertailuTarkkuus);
        assertEquals(0, varasto3.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void kontruktoriTest3() {
        Varasto varasto4 = new Varasto(10, 15);
        
        assertEquals(10, varasto4.getSaldo(), vertailuTarkkuus);
        assertEquals(10, varasto4.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void kontruktoriTest4() {
        Varasto varasto5 = new Varasto(10, 5);
        
        assertEquals(5, varasto5.getSaldo(), vertailuTarkkuus);
        assertEquals(10, varasto5.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void toStringTest() {
        Varasto varasto6 = new Varasto(10, 5);
        
        assertEquals("saldo = 5.0, vielä tilaa 5.0", varasto6.toString());
    }
    
}