package logika;

public class PrikazPrecist implements IPrikaz{

    private static final String NAZEV = "precist";
    private HerniPlan plan;

    public PrikazPrecist(HerniPlan plan) {
        this.plan = plan;
    }

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