package logika;

import org.junit.After;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testovací třída HraTest slouží ke komplexnímu otestování
 * třídy Hra
 *
 * @author    Jarmila Pavlíčková, Michal Průcha
 * @version  pro školní rok 2021/2022
 */
public class HraTest {
    IHra hra;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        hra = new Hra();
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }


    @Test
    void testNovinar() {
        hra.zpracujPrikaz("seber zprava_o_vrbeticich");
        assertEquals("mynarova_kancelar", hra.getHerniPlan().getAktualniProstor().getNazev());
        hra.zpracujPrikaz("jdi hradni_nadvori");
        assertEquals("hradni_nadvori", hra.getHerniPlan().getAktualniProstor().getNazev());
        hra.zpracujPrikaz("dej novinar zprava_o_vrbeticich");
        assertEquals(true, hra.konecHry());
    }

    @Test
    void testSkartovanyPudink() {
        hra.zpracujPrikaz("seber zprava_o_vrbeticich");
        assertEquals("mynarova_kancelar", hra.getHerniPlan().getAktualniProstor().getNazev());
        hra.zpracujPrikaz("jdi hradni_nadvori");
        hra.zpracujPrikaz("jdi archiv");
        hra.zpracujPrikaz("jdi skartovaci_mistnost");
        hra.zpracujPrikaz("seber pudink");
        hra.zpracujPrikaz("skartuj pudink " + hra.getHerniPlan().getHeslo());
        assertEquals(true, hra.konecHry());
    }

    @Test
    void testVyhra() {
        hra.zpracujPrikaz("seber zprava_o_vrbeticich");
        assertEquals("mynarova_kancelar", hra.getHerniPlan().getAktualniProstor().getNazev());
        hra.zpracujPrikaz("jdi hradni_nadvori");
        hra.zpracujPrikaz("jdi archiv");
        hra.zpracujPrikaz("jdi skartovaci_mistnost");
        assertEquals("skartovaci_mistnost", hra.getHerniPlan().getAktualniProstor().getNazev());
        hra.zpracujPrikaz("mluv sekretarka");
        hra.zpracujPrikaz("seber pudink");
        hra.zpracujPrikaz("jdi archiv");
        hra.zpracujPrikaz("jdi hradni_nadvori");
        hra.zpracujPrikaz("jdi lany");
        hra.zpracujPrikaz("dej zeman pudink");
        hra.zpracujPrikaz("mluv zeman");
        hra.zpracujPrikaz("jdi hradni_nadvori");
        hra.zpracujPrikaz("jdi archiv");
        hra.zpracujPrikaz("jdi skartovaci_mistnost");
        hra.zpracujPrikaz("skartuj zprava_o_vrbeticich " + hra.getHerniPlan().getHeslo());
        assertEquals(true, hra.konecHry());
    }
}
