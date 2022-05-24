package logika;
/**
 *  Třída implementuje rozhraní IPrikaz.
 *  Má za úkol přečíst ve hře dokument
 * @author Michal Průcha
 * @version pro školní rok 2021/2022
 */
public class PrikazPrecist implements IPrikaz{

    private static final String NAZEV = "precist";
    private HerniPlan plan;

    /**
     * Konstruktor třídy
     * @param plan herní plán
     */
    public PrikazPrecist(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Metoda kontroluje správnost zadaných výrazů
     * Kontroluje, zda hráč drží danou věc.
     * @param parametry potřebuje 1 parametr toho, co chci přečíst.
     * @return vrací text nebo chybovou hlášku.
     */
    @Override
    public String provedPrikaz(String... parametry) {

        if(parametry.length == 0) return "Zadej parametr, co mám přečíst.";
        String nazevCtenehoItemu = parametry[0];
        Item cteny = plan.getInventar().getItem(nazevCtenehoItemu);
        if (cteny == null) return "To u sebe nemám";
        else return cteny.getText();
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}