package logika;

import logika.postavy.Novinar;
import logika.postavy.Ovcacek;
import logika.postavy.Sekretarka;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testovací třída PostavaTest slouží k otestování příkazu mluvit jednotlivých postav.
 *
 * @author    Jarmila Pavlíčková, Michal Průcha
 * @version   pro skolní rok 2021/2022
 */
public class PostavaTest {

    @Test
    public void testPostava()
    {
        Novinar novinar = new Novinar("novinář", "novinar", null);
        Sekretarka sekretarka = new Sekretarka("sekretářka Vlasta", "sekretarka", null);
        Ovcacek ovcacek = new Ovcacek("Ovčáček", "ovcacek", null);

        assertEquals("Zbláznil ses? S novináři přece nemluvíš.", novinar.mluvit());
        assertEquals("SEKRETÁŘKA VLASTA: Neviděl jste můj pudink? Těd tu ležel na stole!", sekretarka.mluvit());
        assertEquals("MYNÁŘ: Ahoj Jiří, co to děláš?\n" +
                "OVČÁČEK: Hledám ten proklatej článek. Někde jsem ho tu viděl...", ovcacek.mluvit());

        // Zeman otestovat nelze, protože závisí na vývoji hry.
    }
}