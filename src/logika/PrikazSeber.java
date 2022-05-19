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

        // kontroluje, jestli není vec už v inventari
        if (plan.getInventar().obsahujeItem(nazevSbiranehoItemu)) return "Tuhle věc už máš v inventáři.";

        Item sbirany = plan.getAktualniProstor().removeItem(nazevSbiranehoItemu);
        // pokud chci pudink
        if (nazevSbiranehoItemu.equals("pudink")) {
            //Pokud jsem ve skartovne
            if (plan.getAktualniProstor().containsPostava("sekretarka")) {
                if (plan.getAktualniProstor().getPostava("sekretarka").hasItem("pudink")) {
                    if (plan.getInventar().jePlny()) return "Další věc už neuneseš.";
                    else {
                        sbirany = plan.getAktualniProstor().getPostava("sekretarka").odeberItem("pudink");
                        Inventar.vlozItem(sbirany);
                        return "Sebral jsi sekretářce pudink.";
                    }
                }
                else return "To tady nevidím.";
            }
            // pokud jsem v lanech
            if (plan.getAktualniProstor().containsPostava("zeman")) {
                if (plan.getAktualniProstor().getPostava("zeman").hasItem("pudink")) {
                    if (plan.getInventar().jePlny()) return "Další věc už neuneseš.";
                    else {
                        sbirany = plan.getAktualniProstor().getPostava("zeman").odeberItem("pudink");
                        Inventar.vlozItem(sbirany);
                        return "Sebral jsi Milošovi pudink.";
                    }
                }
                else return "To tady nevidím.";
            }
        }

        // pokud chci Peroutkuv clanek
        if (nazevSbiranehoItemu.equals("peroutkuv_clanek")){
            if (plan.getAktualniProstor().containsPostava("ovcacek")) {
                if (!plan.getAktualniProstor().isProhledano()) {
                    plan.getAktualniProstor().addItem(sbirany);
                    return "To tady nevidím.";
                }
            }
            else return "To tady nevidím.";
        }

        if (sbirany == null) return "To tady nevidím.";
        if (sbirany.isMovable()) {
            if (plan.getInventar().jePlny()) {
                plan.getAktualniProstor().addItem(sbirany);
                return "Další věc už neuneseš.";
            } else {
                Inventar.vlozItem(sbirany);
                return "Vzal jsi předmět.";          //Věc zmizí z prostoru
            }
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