package logika.postavy;

import logika.HerniPlan;
import logika.Item;
import logika.Postava;

/**
 *  Třída rozšiřuje třídu Postava.
 * @author Michal Průcha
 */
public class Ovcacek extends Postava {
    public Ovcacek(String fullJmeno, String jmeno, HerniPlan plan) {
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
                return getDialogJmenovka() + "Já ten pudink nechci. Ale Miloš si stěžoval, že jsem mu už dlouho žádný nedal...";
            case "peroutkuv_clanek":
                Item odebranyItem = getHerniPlan().getInventar().odeberItem(coDavam);
                getHerniPlan().getAktualniProstor().getPostava("ovcacek").giveItem(odebranyItem);

                return getDialogJmenovka() + "No Vráťo! Ty jsi moje záchrana! *Muck*";
            case "zprava_o_vrbeticich":
                return getDialogJmenovka() + "Co to je?\n" +
                        "MYNÁŘ: Biska nám poslala dopis. Přišla na ty Vrbětice.\n" +
                        getDialogJmenovka() + "Tak s tím já nechci mít nic společného, nech si to.";
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
        if (hasItem("peroutkuv_clanek"))
            return "MYNÁŘ: Čteš to?\n" +
                    getDialogJmenovka() + "Jo, neruš.";
        else
            return "MYNÁŘ: Ahoj Jiří, co to děláš?\n" +
                    getDialogJmenovka() + "Hledám ten proklatej článek. Někde jsem ho tu viděl...";

    }
}
