package logika;

import java.util.HashMap;
import java.util.Map;

public final class Inventar {

    private static Map<String, Item> veci = new HashMap<>();


    public static Item vlozItem(Item item){
        veci.put(item.getNazev(), item);
        return item;
    }

    public static String zobrazitInventar(){
        if (veci.isEmpty()) return "nic";
        String vracenyText = "Obsah inventáře je: ";
        for (Map.Entry<String, Item> item : veci.entrySet()){
            vracenyText += item.getKey() + " ";
        }
        return vracenyText;
    }

   public Boolean obsahujeItem(String nazev){
        return veci.containsKey(nazev);
   }

   public Item getItem(String nazev){
        return veci.get(nazev);
   }

   public Item odeberItem(String nazev) {
       Item item = veci.get(nazev);
       veci.remove(nazev);
       return item;
   }

   public boolean jePlny(){
        return veci.size() >= 2;
   }

}
