package logika.postavy;

import logika.HerniPlan;
import logika.Item;
import logika.Postava;

/**
 *  Třída rozšiřuje třídu Postava.
 * @author Michal Průcha
 */
public class Sekretarka extends Postava {
    public Sekretarka(String fullJmeno, String jmeno, HerniPlan plan) {
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
                getHerniPlan().getAktualniProstor().getPostava("sekretarka").giveItem(odebranyItem);
                return getDialogJmenovka() + "No to je dost, takhle mi ho brát... Že se nestydíte!";
            case "zprava_o_vrbeticich":
                getHerniPlan().ukonciHru();
                return "Dal jsi kompromitující zprávu sekretářce. Ta to při první příležitosi u kadeřnice vykecala.\n" +
                        "Prohrál jsi.";
            case "peroutkuv_clanek":
                return getDialogJmenovka() + "Tak vy jste našli ten článek, jo? To byste měl dát spáš někomu jinému, pane.";
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
        if (hasItem("pudink")){
            return "MYNÁŘ: Dobré ráno Vlastičko. Akorát snídáme?\n" +
                    getDialogJmenovka() + "Dobré ráno pane. Ano, doma jsem to nestihla, tak teď rychle hltám pudink.";
        } else {
            return getDialogJmenovka() + "Neviděl jste můj pudink? Těd tu ležel na stole!";
        }
    }
}
