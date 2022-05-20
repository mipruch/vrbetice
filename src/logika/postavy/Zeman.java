package logika.postavy;

import logika.HerniPlan;
import logika.Item;
import logika.Postava;

/**
 *  Třída rozšiřuje třídu Postava.
 * @author Michal Průcha
 */
public class Zeman extends Postava {
    public Zeman(String fullJmeno, String jmeno, HerniPlan plan) {
        super(fullJmeno, jmeno, plan);
    }

    /**
     * Metoda se stará o příkaz dej.
     * @param coDavam věc, kterou chci dát
     * @return dialogy
     */
    @Override
    public String dej(String coDavam) {
        switch (coDavam){
            case "pudink":
                Item odebranyItem = getHerniPlan().getInventar().odeberItem("pudink");
                giveItem(odebranyItem);
                return getDialogJmenovka() + "Tys mi přinesl pudink! Děkuji mockrát Vráťo.";
            case "zprava_o_vrbeticich":
                getHerniPlan().ukonciHru();
                return "Dal jsi kompromitující zprávu Milošovi a tím jsi mu pokazil mínění o svých kamarádech.\n" +
                        "Prohrál jsi.";
            case "peroutkuv_clanek":
                Item odebiranyItem = getHerniPlan().getInventar().odeberItem("peroutkuv_clanek");
                giveItem(odebiranyItem);
                return getDialogJmenovka() + "Já to věděl! Kde byl?";
            default:
                return "error na straně postavy";
        }
    }

    /**
     * Metoda se stará o příkaz mluv.
     * @return dialogy
     */
    @Override
    public String mluvit() {
        if (hasItem("pudink")) {
            // Mynář zná heslo
            if (getHerniPlan().znaKod()) {
                return getDialogJmenovka() + "Ten pudink je opravdu výborný Vráťo.";
                // Mynář nezná heslo
            } else {
                getHerniPlan().setZnaKod(true);
                return getDialogJmenovka() + "Ten pudink je opravdu výborný Vráťo.\n" +
                        "MYNÁŘ: Potřeboval bych od tebe laskavost, Miloši.\n" +
                        getDialogJmenovka() + "Povídej. Hmm, mňam.\n" +
                        "MYNÁŘ: Neznáš náhodou kód ke skartovačce?\n" +
                        getDialogJmenovka() + "No to znám. Je to " + getHerniPlan().getHeslo() + ". Mňam, ten pudink je opravdu výborný.\n" +
                        "MYNÁŘ: Díky. A neboj, brzy ti donesu další.";
            }
        }
        // Zeman nemá pudink
        else {
            if (getHerniPlan().getInventar().obsahujeItem("zprava_o_vrbeticich")) {
                if (getHerniPlan().znaKod()){
                    getHerniPlan().ukonciHru();
                    return getDialogJmenovka() + "Něviděl jsi náhodou moje videokazety? Zabavili mi počítač a nemám na co koukat.\n" +
                            "MYNÁŘ: Promiň, neviděl.\n" +
                            getDialogJmenovka() + "A co to vůbec džíš za papíry?\n" +
                            "MYNÁŘ: Tohle? To nic není, toho si nevšímej, jen nějaký papíry. Tak můžu tě o něco poprosit?\n" +
                            getDialogJmenovka() + "Ale kuš, ukaž mi, co to máš za papíry.\n\n" +
                            "Dal jsi kompromitující zprávu Milošovi a tím jsi mu pokazil mínění o svých kamarádech.\n" +
                            "Prohrál jsi.";
                } else {
                    getHerniPlan().ukonciHru();
                    return getDialogJmenovka() + "Něviděl jsi náhodou moje videokazety? Zabavili mi počítač a nemám na co koukat.\n" +
                            "MYNÁŘ: Promiň, neviděl. Ale potřeboval bych od tebe laskavost.\n" +
                            getDialogJmenovka() + "Laskavost? A co mi to vůbec neseš za papíry?\n" +
                            "MYNÁŘ: Tohle? To nic není, toho si nevšímej, jen nějaký papíry. Tak můžu tě o něco poprosit?\n" +
                            getDialogJmenovka() + "Ale kuš, ukaž mi, co to máš za papíry.\n\n" +
                            "Dal jsi kompromitující zprávu Milošovi a tím jsi mu pokazil mínění o svých kamarádech.\n" +
                            "Prohrál jsi.";
                }

            } else {
                if (getHerniPlan().znaKod()){
                    return getDialogJmenovka() + "Něviděl jsi náhodou moje videokazety? Zabavili mi počítač a nemám na co koukat.\n" +
                            "MYNÁŘ: Promiň, neviděl.";
                } else {
                    return getDialogJmenovka() + "Něviděl jsi náhodou moje videokazety? Zabavili mi počítač a nemám na co koukat.\n" +
                            "MYNÁŘ: Promiň, neviděl. Ale potřeboval bych od tebe laskavost\n" +
                            getDialogJmenovka() + "Jakou laskavost?\n" +
                            "MYNÁŘ: Neznáš náhodou heslo ke skartovačce?\n" +
                            getDialogJmenovka() + "No to znám. A k čemu ho potřebuješ?\n" +
                            "MYNÁŘ: No je jedno, taková maličkost.\n" +
                            getDialogJmenovka() + "Neřeknu ti ho, pokud mi nepovíš, o co jde.\n";
                }

            }
        }
    }
}
