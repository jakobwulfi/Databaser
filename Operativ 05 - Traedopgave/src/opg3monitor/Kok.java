package opg3monitor;

import java.util.Random;

public class Kok extends Thread {
    private Counter c;
    private String navn;

    public Kok(String navn, Counter c) {
        this.navn = navn;
        this.c = c;
    }

    public void run() {
        while (1 == 1) {
            //if (c.getKokketæller() < c.getTjenerTæller()) {
                c.updateKokketæller();
            //}
            try {
                Random random = new Random();
                int randomNumber = random.nextInt(4501) + 2000;
                this.sleep(randomNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
