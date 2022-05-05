package logika;

public class PrikazSeber implements IPrikaz{

    private static final String NAZEV = "seber";
    private HerniPlan plan;

    public PrikazSeber(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {

        if (parametry.length == 0) return "Zadej parametr, co mám sebrat.";

        String nazevSbiranehoItemu = parametry[0];
        Item sbirany = plan.getAktualniProstor().removeItem(nazevSbiranehoItemu);
        // pokud chci pudink
        if (parametry[0].equals("pudink")) {
            if (plan.getInventar().obsahujeItem("pudink")) return "Už máš pudink v inventáři";
            //Pokud jsem ve skartovne
            if (plan.getAktualniProstor().containsPostava("sekretarka")) {
                if (plan.getAktualniProstor().getPostava("sekretarka").hasItem("pudink")) {
                    sbirany = plan.getAktualniProstor().getPostava("sekretarka").odeberItem("pudink");
                    Inventar.vlozItem(sbirany);
                    return "Sebral jsi sekretářce pudink.";
                }
                else return "To tady není.";
            }
            // pokud jsem v lanech
            if (plan.getAktualniProstor().containsPostava("zeman")) {
                if (plan.getAktualniProstor().getPostava("zeman").hasItem("pudink")) {
                    sbirany = plan.getAktualniProstor().getPostava("zeman").odeberItem("pudink");
                    Inventar.vlozItem(sbirany);
                    return "Sebral jsi Milošovi pudink.";
                } else return "To tady není.";
            }
        }
        if (sbirany == null) return "To tady není.";
        if (sbirany.isMovable()) {
            Inventar.vlozItem(sbirany);
            return "Vzal jsi předmět";          //Věc zmizí z prostoru
            //TODO peroutkuv clanek sebrat az po prohledani
        } else {
            plan.getAktualniProstor().addItem(sbirany);
            return "To si asi do kapsy úplně nedám...";
        }
    }


    @Override
    public String getNazev() {
        return NAZEV;
    }
}