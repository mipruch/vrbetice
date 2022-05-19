package logika;

import java.util.Random;

public class Heslo {
    private String hesloSlovo;
    private int hesloCislo;
    private String heslo;

    public Heslo() {


        String[] heslaSlova={"cuckari", "aligator", "moskva", "krtecek", "panda", "vladimir", "clun"};
        Random random = new Random();
        int randomNumber = random.nextInt(heslaSlova.length);
        this.hesloSlovo = heslaSlova[randomNumber];


        this.hesloCislo = new Random().nextInt(1000);
        this.heslo = hesloSlovo + hesloCislo;
    }

    public String getHeslo() {
        return heslo;
    }
}
