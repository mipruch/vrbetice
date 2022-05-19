package logika;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*******************************************************************************
 * Testovací třída ProstorTest slouží ke komplexnímu otestování
 * třídy Prostor
 *
 * @author    Jarmila Pavlíčková, Michal Průcha
 * @version   pro skolní rok 2021/2022
 */
public class ProstorTest
{
    //== Datové atributy (statické i instancí)======================================

    //== Konstruktory a tovární metody =============================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    //== Příprava a úklid přípravku ================================================


    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @Before
    public void setUp() {
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /**
     * Testuje, zda jsou správně nastaveny průchody mezi prostory hry. Prostory
     * nemusí odpovídat vlastní hře, 
     */

    @Test
    public void testLzeProjit()
    {
        Prostor prostor1 = new Prostor("prostor1", "toto je prostor 1");
        Prostor prostor2 = new Prostor("prostor2", "toto je prostor 2");
        prostor1.setVychod(prostor2);
        prostor2.setVychod(prostor1);
        assertEquals(prostor2, prostor1.vratSousedniProstor("prostor2"));
        assertEquals(null, prostor2.vratSousedniProstor("prostor 3"));
    }

    @Test
    public void testItemu()
    {
        Prostor prostor1 = new Prostor("prostor1", "toto je prostor 1");
        Item vec1 = new Item("pudink", true, "Pudink nelze přečíst", false);
        prostor1.addItem(vec1);
        assertEquals(true, prostor1.containsItem("pudink"));
        assertEquals(false, prostor1.containsItem("skartovacka"));
    }




}
