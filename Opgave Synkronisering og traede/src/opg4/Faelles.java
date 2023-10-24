package opg4;

import java.util.Random;
import java.util.concurrent.Semaphore;
/**
 * Fælles klasse for trådene. Indeholder den globale
 * tæller og en fylde metode, tagerRandomTid, der
 * fylder tid, den kritiske sektion, der tæller
 * global op, og en Semaphore, der sørger for at
 * der kun er ét objekt, der anvender diverse metoder.
 */
public class Faelles {
    private int global = 0;
    private Semaphore sema = new Semaphore(1);
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
     * til temp + 1. Hele metodekroppen er omringet af en try- catch. Try-delen starter
     * med at bruge Semaphorens acquire-metode, til at modtage en tilladelse og blockere
     * adgang til metoden for andre objekter.
     */
    public void kritiskSection() {
        try {
            sema.acquire();
            int temp;
            temp = global;
            tagerRandomTid(2);
            global = temp + 1;
            sema.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
