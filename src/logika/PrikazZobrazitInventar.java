package logika;

/**
 * Třída PrikazZobrazInventar vypíše to terminálu obsah inventáře
 * @author Michal Průcha
 */
public class PrikazZobrazitInventar implements IPrikaz{

    private static final String NAZEV = "inventar";
    private HerniPlan plan;

    /**
     * Konstruktor třídy
     * @param plan herní plán
     */
    public PrikazZobrazitInventar(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Metoda zobrazí inventář
     * @param parametry nezáleží na parametrech.
     * @return vrací obsah inventáře.
     */
    @Override
    public String provedPrikaz(String... parametry) {

        return plan.getInventar().zobrazitInventar();
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
