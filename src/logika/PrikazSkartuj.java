package logika;

/**
 *  Třída implementuje rozhraní IPrikaz.
 *  Má za úkol skartovat věc
 * @author Michal Průcha
 */
public class PrikazSkartuj implements IPrikaz{

    private static final String NAZEV = "skartuj";
    private HerniPlan plan;

    /**
     * Konstruktor třídy
     * @param plan herní plán
     */
    public PrikazSkartuj(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Metoda kontroluje správnost zadaných výrazů
     * Kontroluje, zda hráč drží danou věc a zda je skartovačka v místnosti.
     * Po použití hra končí buď prohrou nebo výhrou
     * @param parametry potřebuje 2 parametry. Věc a heslo.
     * @return vrací potvrzovací nebo chybovou hlášku.
     */
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
                            plan.setVyhra();
                            return """
                                    Zničil jsi přísně utajovaný dokument.
                                    Tvůj Pán se tak nikdy nedozví, co v něm stálo.
                                    Úspěšně jsi dokončil hru, gratuluji.""";
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