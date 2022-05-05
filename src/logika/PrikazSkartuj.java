package logika;

public class PrikazSkartuj implements IPrikaz{

    private static final String NAZEV = "skartuj";
    private HerniPlan plan;


    public PrikazSkartuj(HerniPlan plan) {
        this.plan = plan;
    }


    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length > 2) return "Uveď pouze dva parametry. Co chceš skartovat a heslo ke skartovačce";
        if (parametry.length == 0) return "Uveď, co chceš skartovat a heslo ke skartovačce.";
        if (parametry.length == 1) return "Uveď dva parametry. Co chceš skartovat a heslo ke skartovačce.";
        String wantedItem = parametry[0];
        String hesloZadane = parametry[1];
        String hesloSpravne = plan.getHeslo();
        if (plan.getInventar().obsahujeItem(wantedItem)) {
            if (plan.getAktualniProstor().containsItem("skartovacka")) {
                if (hesloZadane.equals(hesloSpravne)) {
                    plan.getInventar().odeberItem(wantedItem);
                    plan.ukonciHru();
                    switch (wantedItem) {
                        case "pudink":
                            return "Rozbil jsi skartovačku, prohrál jsi.";
                        case "zprava_o_vrbeticich":
                            return "Zničil jsi přísně utajovaný dokument.\n" +
                                    "Tvůj Pán se tak nikdy nedozví, co v něm stálo.\n" +
                                    "Úspěšně jsi dokončil hru, gratuluji.";
                        case "peroutkuv_clanek":
                            return "Tvůj pán bude již navždy lhářem. Za to ti nepoděkuje, prohrál jsi.";
                    }
                }
                return "Špatné heslo";
            }
            return "Bez skartovačky to těžko skartuješ";
        }
        return "Tuhle věc nemáš u sebe";
    }


    @Override
    public String getNazev() {
        return NAZEV;
    }
}