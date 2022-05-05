package logika;

public class PrikazProhledej implements IPrikaz{

    private static final String NAZEV = "prohledej";
    private HerniPlan plan;

    public PrikazProhledej(HerniPlan plan) {
        this.plan = plan;
    }

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