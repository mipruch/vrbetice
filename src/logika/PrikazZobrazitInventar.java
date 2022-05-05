package logika;

/**
 * Class PrikazZobrazInventar vypíše to terminálu obsah inventáře
 * @author Michal Průcha
 * @version pro školní rok 2021/22
 */
public class PrikazZobrazitInventar implements IPrikaz{

    private static final String NAZEV = "inventar";
    private HerniPlan plan;

    public PrikazZobrazitInventar(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {

        return plan.getInventar().zobrazitInventar();
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
