package logika;

/**
 *  Třída implementuje rozhraní IPrikaz.
 *  Má za úkol dát nějaké postavě nějakou věc
 * @author Michal Průcha
 */
public class PrikazDej implements IPrikaz{

    private static final String NAZEV = "dej";
    private HerniPlan plan;

    /**
     * Konstruktor třídy
     * @param plan herní plán
     */
    public PrikazDej(HerniPlan plan) {
        this.plan = plan;
    }


    /**
     * Metoda kontroluje správnost zadaných výrazů
     * Kontroluje, zda hráč drží danou věc a zda je postava v místnosti.
     * @param parametry potřebuje 2 parametry.
     * @return vrací potvrzovací nebo chybovou hlášku.
     */
    @Override
    public String provedPrikaz(String... parametry) {

        if (parametry.length > 2) return "Napiš pouze dva parametry";
        if (parametry.length != 2) return "Příkaz DEJ potřebuje dva parametry. KOMU chceš něco dát a CO mu chceš dát.";
        // Kontroluje, jestli postava v prostoru existuje
        String komuDavam;
        if (plan.getAktualniProstor().containsPostava(parametry[0])) {
            komuDavam = parametry[0];
        } else {
            return "Tuto postavu tu nevidím";
        }
        // Kontroluje, zda předmět mám v inventáři
        if (parametry[1] == null) return "Zadej, co mám dát";
        if (plan.getInventar().obsahujeItem(parametry[1])) {
            String coDavam = parametry[1];
            return plan.getAktualniProstor().getPostava(komuDavam).dej(coDavam);
        }
        return "Tento předmět nemáš u sebe.";
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}