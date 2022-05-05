package logika;

public class PrikazDej extends Prikaz{

    private static final String NAZEV = "dej";

    public PrikazDej(HerniPlan plan) {
        super(NAZEV, plan);
    }

    @Override
    public String provedPrikaz(String... parametry) {

        if (parametry.length > 2) return "Napiš pouze dva parametry";
        if (parametry.length != 2) return "Příkaz DEJ potřebuje dva parametry. KOMU chceš něco dát a CO mu chceš dát.";
        // Kontroluje, jestli postava v prostoru existuje
        String komuDavam;
        if (getHerniPlan().getAktualniProstor().containsPostava(parametry[0])) {
            komuDavam = parametry[0];
        } else {
            return "Tuto postavu tu nevidím";
        }
        // Kontroluje, zda předmět mám v inventáři
        if (parametry[1] == null) return "Zadej, co mám dát";
        if (getHerniPlan().getInventar().obsahujeItem(parametry[1])) {
            String coDavam = parametry[1];
            return (getHerniPlan().getAktualniProstor().getPostava(komuDavam).dej(coDavam));
        }
        return "Tento předmět nemáš u sebe.";
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}