package opg1;

import java.util.Random;

/**
 * Fælles klasse for trådene. Indeholder den globale
 * tæller og en fylde metode, tagerRandomTid, der
 * fylder tid, samt den kritiske sektion, der tæller
 * global op.
 */
public class Faelles {
    private int global = 0;

    public Faelles() {
        this.global = global;
    }

    /**
     * Fyldemetode der inkrementerer og adderer to tal i to
     * for-loop.
     */
    public void tagerRandomTid(int max) {
        Random r = new Random();
        int nymax = Math.abs(r.nextInt())% max +1;
        for (int i = 0; i < nymax; i++) {
            int k = 0;
            int b = 0;
            for (int j = 0; j < nymax; j++) {
                k++;
                b++;
                k = k + b;
            }
        }
    }
    public int getGlobal() {
        return global;
    }

    /**
     * Metoden indeholdene den kritiske sektion. Metoden opsætter en
     * timp int-value og sætter den til global-parameteren. Herefter anvender
     * den fyldemetoden til at fylde tid ud, og derefter sætter den global
     * til temp + 1.
     */
    public void kritiskSection() {
        int temp;
        temp = global;
        tagerRandomTid(2);
        global = temp + 1;
    }
}
