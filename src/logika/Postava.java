package logika;

import java.util.HashSet;
import java.util.Set;

/**
 * Třída pomocí které se tvoří jednostlivé postavy
 * @author Michal Průcha
 */
public class Postava implements IPostava{

    private String fullJmeno;
    private String jmeno;
    private Set<Item> items;   // obsahuje itemyě
    private HerniPlan plan;

    /**
     * Konstruktor vytváří postavu
     * @param fullJmeno jméno, které se objevuje v příkazové řádce
     * @param jmeno jméno používané pro psaní
     * @param plan
     */
    public Postava(String fullJmeno, String jmeno, HerniPlan plan) {
        this.fullJmeno = fullJmeno;
        this.jmeno = jmeno;
        items = new HashSet<>();
        this.plan = plan;
    }

    /**
     * @return vrací krátké jméno
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * @return vrací celé jméno
     */
    public String getFullJmeno() {
        return fullJmeno;
    }

    /**
     * @return vrací jmenovku k dialogům
     */
    public String getDialogJmenovka(){
        return getFullJmeno().toUpperCase() + ": ";
    }

    /**
     * Metoda dává postavě věc
     */
    public void giveItem(Item item){
        items.add(item);
    }

    /**
     * Metoda odebírá postavě věc
     */
    public Item odeberItem(String nazevVeci){
        for(Item wantedItem: items){
            if(wantedItem.getNazev().equals(nazevVeci)) {
                items.remove(wantedItem);
                return wantedItem;
            }
        }
        return null;
    }

    /**
     * metoda kontroluje, zda má postava dotazovanou věc
     * @param nazevVeci dotazovaná věc
     * @return  true = má věc, false = nemá věc
     */
    public boolean hasItem(String nazevVeci){
        for (Item wantedItem : items){
            if(wantedItem.getNazev().equals(nazevVeci)) return true;
        }
        return false;
    }

    /**
     * @return vrací herní plán
     */
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
