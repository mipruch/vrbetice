package logika;

import java.util.Random;

/**
 * Třída heslo na začátku hry náhodně vytvoří heslo ke skartovačce.
 *
 * @author     Michal Průcha
 * @version    pro školní rok 2021/2022
 */
public class Heslo {
    private final String heslo;

    /**
     * Konstruktor vytváří heslo
     */
    public Heslo() {

        String[] heslaSlova={"cuckari", "aligator", "moskva", "krtecek", "panda", "vladimir", "clun"};
        Random random = new Random();
        int randomNumber = random.nextInt(heslaSlova.length);
        String hesloSlovo = heslaSlova[randomNumber];


        int hesloCislo = new Random().nextInt(1000);
        this.heslo = hesloSlovo + hesloCislo;
    }

    /**
     * Metoda vrací heslo
     * @return heslo
     */
    public String getHeslo() {
        return heslo;
    }
}
