package logika;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HraTest {
    IHra hra;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        hra = new Hra();
    }

    @Test
    void testHry() {
        hra.zpracujPrikaz("jdi les");
        assertEquals("les", hra.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra.konecHry());
    }
}
