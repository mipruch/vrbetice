package logika;

import java.util.HashSet;
import java.util.Set;

public class Postava implements IPostava{

    private String fullJmeno;
    private String jmeno;
    private Set<Item> items;   // obsahuje itemyě
    private HerniPlan plan;


    public Postava(String fullJmeno, String jmeno, HerniPlan plan) {
        this.fullJmeno = fullJmeno;
        this.jmeno = jmeno;
        items = new HashSet<>();
        this.plan = plan;
    }

    public String getJmeno() {
        return jmeno;
    }
    public String getFullJmeno() {
        return fullJmeno;
    }

    public String getDialogJmenovka(){
        return getFullJmeno().toUpperCase() + ": ";
    }


    public void giveItem(Item item){
        items.add(item);
    }

    public Item odeberItem(String nazevVeci){
        for(Item wantedItem: items){
            if(wantedItem.getNazev().equals(nazevVeci)) {
                items.remove(wantedItem);
                return wantedItem;
            }
        }
        return null;
    }

    public boolean hasItem(String nazevVeci){
        for (Item wantedItem : items){
            if(wantedItem.getNazev().equals(nazevVeci)) return true;
        }
        return false;
    }

    public HerniPlan getHerniPlan() {
        return this.plan;
    }



    @Override
    public String mluvit() {
        return null;
    }

    @Override
    public String dej(String vec) {
        return null;
    }


}
