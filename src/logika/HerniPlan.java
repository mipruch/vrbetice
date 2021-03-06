package logika;


import logika.postavy.Novinar;
import logika.postavy.Ovcacek;
import logika.postavy.Sekretarka;
import logika.postavy.Zeman;

/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  vytváří všechny postavy,
 *  vytváří všechny věci,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *  Pamatuje si, zda Mynář zná kód.
 *  Vytváří inventář a heslo.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2021/2022
 */
public class HerniPlan {
    private Hra hra;
    private Prostor aktualniProstor;
    private Inventar inventar = new Inventar();
    private Heslo heslo = new Heslo();
    private boolean znaKod;
    boolean vyhra;


    /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan(Hra hra) {
        this.hra = hra;
        zalozProstoryHry();

    }
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví Mynářovu kancelář.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor hradni_nadvori = new Prostor("hradni_nadvori", "hradní nádvoří, prázdné od turistů, kvůli turniketům u vchodu");
        Prostor mynarova_kancelar = new Prostor("mynarova_kancelar", "Mynářova kancelář zdobená jeho vlastním portrétem přes celou stěnu a výhledem na Jelenní příkop – to je ta zanedbaná džungle");
        Prostor skartovaci_mistnost = new Prostor("skartovaci_mistnost", "skartovací místnost. V temné místnosti bez oken a naleštěnou skartovačkou uprostřed místnosti");
        Prostor archiv = new Prostor("archiv", "archiv, tady něco najít, to bude trvat věčnost..");
        Prostor lany = new Prostor("lany", "Lány – zámeček jak z pohádky");

        // přiřazují se průchody mezi prostory (sousedící prostory)
        hradni_nadvori.setVychod(lany);
        hradni_nadvori.setVychod(archiv);
        hradni_nadvori.setVychod(mynarova_kancelar);
        lany.setVychod(hradni_nadvori);
        mynarova_kancelar.setVychod(hradni_nadvori);
        archiv.setVychod(hradni_nadvori);
        archiv.setVychod(skartovaci_mistnost);
        skartovaci_mistnost.setVychod(archiv);

        // vytvářejí se jednotlivé věci do prostorů
        Item zprava_o_vrbeticich = new Item("zprava_o_vrbeticich", true, "GRU jednotka 29155 – Alexandr Miškin a Anatolij Čepiga. 16. října 2014. Vrbětice.", false);
        Item skartovacka = new Item("skartovacka", false, null, false);
        Item pudink = new Item("pudink", true, "Bych chtěl vidět tebe, jak čteš pudink...", false);
        Item peroutkuv_clanek = new Item("peroutkuv_clanek", true, "NADPIS: Hitler je gentleman", true);
        archiv.addItem(peroutkuv_clanek);
        skartovaci_mistnost.addItem(skartovacka);
        mynarova_kancelar.addItem(zprava_o_vrbeticich);

        // vytvářejí se postavy
        Zeman zeman = new Zeman("Zeman", "zeman", this);
        Novinar novinar = new Novinar("novinář", "novinar", this);
        Sekretarka sekretarka = new Sekretarka("sekretářka Vlasta", "sekretarka", this);
        Ovcacek ovcacek = new Ovcacek("Ovčáček", "ovcacek", this);
        archiv.addPostava(ovcacek);
        lany.addPostava(zeman);
        skartovaci_mistnost.addPostava(sekretarka);
        hradni_nadvori.addPostava(novinar);

        // vytvářejí se jednotlivé věci postavám
        sekretarka.giveItem(pudink);
                
        aktualniProstor = mynarova_kancelar;  // hra začíná v kanceláři

    }
    
    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }

    /**
     * Metoda vrací odkaz na inventář
     * @return inventář
     */
    public Inventar getInventar() {
        return inventar;
    }

    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
    }

    /**
     * @return vrací hodnotu, zda Mynář zná heslo
     */
    public boolean znaKod() {
        return znaKod;
    }

    /**
     * metoda nastavuje, zda Mynář zná heslo
     * @param znaKod true = zná heslo, false = nezná heslo
     */
    public void setZnaKod(boolean znaKod) {
        this.znaKod = znaKod;
    }

    /**
     * @return Metoda vrací heslo
     */
    public String getHeslo (){
        return heslo.getHeslo();
    }

    /**
     * Metoda nastavuje výhru.
     */
    public void setVyhra() {
        this.vyhra = true;
    }

    /**
     * Metoda ukončuje hru.
     */
    public void ukonciHru() {
        hra.setKonecHry(true);
    }

}
