package logika;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testuje vládání a odebírání itemů
 * @author Michal Průcha
 *    @version pro školní rok 2021/2022
 */

public class InventarTest {

    Inventar inventar = new Inventar();
    Item testovana = new Item("testovana", true, "true", false);

    @org.junit.jupiter.api.BeforeEach
    public void setUp()
    {
        inventar.vlozItem(new Item("testovana", true, "true", false));
    }

    @Test
    public void vlozVec() {
        assertEquals(testovana, inventar.vlozItem(testovana));
    }

    @Test
    public void obsahujeVec() {
        assertEquals(true, inventar.obsahujeItem("testovana"));
        assertEquals(false, inventar.obsahujeItem("divnaVec"));
    }
}