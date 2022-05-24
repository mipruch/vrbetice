package logika;

import java.util.Random;

/**
 *  Třída implementuje rozhraní IPrikaz.
 *  Má za úkol vypisovat dialogy, podle toho, s kým mluvím.
 * @author Michal Průcha
 * @version pro školní rok 2021/2022
 */
public class PrikazMluv implements IPrikaz{

    private static final String NAZEV = "mluv";
    private HerniPlan plan;

    /**
     * Konstruktor třídy
     * @param plan herní plán
     */
    public PrikazMluv(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Metoda kontroluje správnost zadaných výrazů a zda se postava v místnostni nachází.
     * Pokud není parametr, Mynář si mumlá pod vousy.
     * @param parametry potřebuje 0 nebo 1 parametr.
     * @return dialog nebo chybovouu hlášku.
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if(parametry.length > 1) return "Zadej pouze jeden parametr.";
        //Mynářovy opakující se repliky (hráč nezadal, na koho mluvit)
        if (parametry.length == 0) {
            String[] repliky={
                    "MYNÁŘ: Co s tou Zprávou mám asi tak dělat...",
                    "MYNÁŘ: Mám si zažádat o prověrku, nemám si zažádat o prověrku, mám si zažádat o prověrku, nemám si zažádat o prověrku...",
                    "MYNÁŘ: To s tím Balákem, to jsem přehnal...",
                    "MYNÁŘ: Hehe, na to pálení trenek vzpomínám dodnes.",
                    "MYNÁŘ: Musím se líp naučit falšovat Pánův podpis..."
            };
            Random random = new Random();
            int randomNumber = random.nextInt(repliky.length);
            return repliky[randomNumber];
        }
        String komuMluvim = parametry[0];
        if (plan.getAktualniProstor().containsPostava(komuMluvim)){
            return plan.getAktualniProstor().getPostava(komuMluvim).mluvit();
        }
        return "Tato postava se zde nenachází.";
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}