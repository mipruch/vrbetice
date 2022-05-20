package logika;
/**
 *  Třída implementuje rozhraní IPrikaz.
 *  Má za úkol prohledat místnost
 * @author Michal Průcha
 */
public class PrikazProhledej implements IPrikaz{

    private static final String NAZEV = "prohledej";
    private HerniPlan plan;

    /**
     * Konstruktor třídy
     * @param plan herní plán
     */
    public PrikazProhledej(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Metoda prohledá místnost a odkryje schované věci
     * @param parametry nepotřebuje žádný parametr.
     * @return vrací výpis věcí v místnosti.
     */
    @Override
    public String provedPrikaz(String... parametry) {
        plan.getAktualniProstor().setProhledano(true);
        return plan.getAktualniProstor().popisVeci();
    }


    @Override
    public String getNazev() {
        return NAZEV;
    }
}