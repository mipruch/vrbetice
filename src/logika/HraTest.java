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

    /**
     * Testuje prohru
     */
    @Test
    void testNovinar() {
        hra.zpracujPrikaz("seber zprava_o_vrbeticich");
        assertEquals("mynarova_kancelar", hra.getHerniPlan().getAktualniProstor().getNazev());
        hra.zpracujPrikaz("jdi hradni_nadvori");
        assertEquals("hradni_nadvori", hra.getHerniPlan().getAktualniProstor().getNazev());
        hra.zpracujPrikaz("dej novinar zprava_o_vrbeticich");
        assertTrue(hra.konecHry());
    }

    /**
     * Testuje prohru
     */
    @Test
    void testSkartovanyPudink() {
        hra.zpracujPrikaz("seber zprava_o_vrbeticich");
        assertEquals("mynarova_kancelar", hra.getHerniPlan().getAktualniProstor().getNazev());
        hra.zpracujPrikaz("jdi hradni_nadvori");
        hra.zpracujPrikaz("jdi archiv");
        hra.zpracujPrikaz("jdi skartovaci_mistnost");
        hra.zpracujPrikaz("seber pudink");
        hra.zpracujPrikaz("skartuj pudink " + hra.getHerniPlan().getHeslo());
        assertFalse(hra.konecHry());
    }

    /**
     * Testuje výhru
     */
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
        assertTrue(hra.konecHry());
    }
    /**
     * Testuje, že skartovačka nejde vložit do inventáře
     */
    @Test
    void testVzitSkartovacka(){
        hra.zpracujPrikaz("jdi hradni_nadvori");
        hra.zpracujPrikaz("jdi archiv");
        hra.zpracujPrikaz("jdi skartovaci_mistnost");
        hra.zpracujPrikaz("seber skartovacka");
        assertEquals("skartovaci_mistnost", hra.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra.getHerniPlan().getInventar().obsahujeItem("skartovacka"));
    }

    /**
     * Testuje omezené množství v inventáři
     */
    @Test
    void testPlnyInventar() {
        hra.zpracujPrikaz("seber zprava_o_vrbeticich");
        hra.zpracujPrikaz("jdi hradni_nadvori");
        hra.zpracujPrikaz("jdi archiv");
        hra.zpracujPrikaz("prohledej");
        hra.zpracujPrikaz("seber peroutkuv_clanek");
        hra.zpracujPrikaz("jdi skartovaci_mistnost");
        assertEquals("skartovaci_mistnost", hra.getHerniPlan().getAktualniProstor().getNazev());
        hra.zpracujPrikaz("seber pudink");
        assertEquals(false, hra.getHerniPlan().getInventar().obsahujeItem("pudink"));
    }
}
