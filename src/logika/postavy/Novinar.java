package logika.postavy;

import logika.HerniPlan;
import logika.Postava;

public class Novinar extends Postava {
    public Novinar(String fullJmeno, String jmeno, HerniPlan plan) {
        super(fullJmeno, jmeno, plan);
    }

    @Override
    public String dej(String coDavam) {
        switch (coDavam){
            case "pudink":
                return getFullJmeno().toUpperCase() + ": No to jsem ještě nezažil... Já od vás žádnej pudink nechci.";
            case "zprava_o_vrbeticich":
                getHerniPlan().ukonciHru();
                return "Jen blázen by dal kompromitující materiál do rukou novináře.\n" +
                        "Prohrál jsi.";
            case "peroutkuv_clanek":
                getHerniPlan().getInventar().odeberItem(coDavam);
                return "Podařilo se ti očistit Pánovo jméno. Teď ještě vyřeš tu Zprávu...";
            default:
                return "error na straně postavy";
        }
    }

    @Override
    public String mluvit() {
        return "Zbláznil ses? S novináři přece nemluvíš.";
    }
}
