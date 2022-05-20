package logika;

import java.util.Objects;

/**
 * Třída Item implementuje konstruktor a metody.
 * @author Michal Průcha
 */
public class Item {

    private String nazev;
    private String text;
    private boolean movable;
    private boolean hidden;

    /**
     * Konstruktor vytváří věc.
     * @param nazev
     * @param movable
     * @param text
     * @param hidden
     */
    public Item(String nazev, boolean movable, String text, boolean hidden) {
        this.nazev = nazev;
        this.movable = movable;
        this.text = text;
        this.hidden = hidden;
    }

    /**
     * Metoda vrací název věci.
     * @return
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Metoda vrací, zda se dá objekt přemístit.
     * @return
     */
    public boolean isMovable() {
        return movable;
    }

    /**
     * Metoda vrací, zda je objekt schovaný.
     * @return
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * Metoda vrací text objektu.
     * @return
     */
    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return nazev.equals(item.nazev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazev);
    }
}
