package logika;

import java.util.Objects;

public class Item {

    private String nazev;
    private String text;
    private boolean movable;
    private boolean hidden;

    public Item(String nazev, boolean movable, String text, boolean hidden) {
        this.nazev = nazev;
        this.movable = movable;
        this.text = text;
        this.hidden = hidden;
    }

    public String getNazev() {
        return nazev;
    }

    public boolean isMovable() {
        return movable;
    }
    public boolean isHidden() {
        return hidden;
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

    public String getText() {
        return text;
    }
}
