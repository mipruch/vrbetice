package logika;

import java.util.HashMap;
import java.util.Map;

/**
 * Třída Inventář implementuje metody k chování inventáře.
 * @author Michal Průcha
 */
public final class Inventar {

    private static Map<String, Item> veci = new HashMap<>();

    /**
     * Metoda vloží zadanou věc do inventáře
     * @param item
     * @return
     */
    public static Item vlozItem(Item item){
        veci.put(item.getNazev(), item);
        return item;
    }

    /**
     * Metoda vypíše obsah inventáře
     * @return
     */
    public static String zobrazitInventar(){
        if (veci.isEmpty()) return "nic";
        String vracenyText = "Obsah inventáře je: ";
        for (Map.Entry<String, Item> item : veci.entrySet()){
            vracenyText += item.getKey() + " ";
        }
        return vracenyText;
    }

    /**
     * Metoda kontroluje, zda inventář obsahuje zadanou věc.
     * @param nazev
     * @return
     */
    public Boolean obsahujeItem(String nazev){
        return veci.containsKey(nazev);
    }

    /**
     * Metoda vrací zadanou věc.
     * @param nazev
     * @return
     */
    public Item getItem(String nazev){
        return veci.get(nazev);
    }

    /**
     * Metoda odebere věc z inventáře a vrácí ji.
     * @param nazev
     * @return
     */
    public Item odeberItem(String nazev) {
       Item item = veci.get(nazev);
       veci.remove(nazev);
       return item;
    }

    /**
     * Metoda kontroluje, zda je inventář plný.
     * @return
     */
    public boolean jePlny(){
        return veci.size() >= 2;
    }

}
