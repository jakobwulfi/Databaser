package opg4doublekok;

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
            System.out.println(navn);
            c.updateKokketæller();
            //}
            try {
                Random random = new Random();
                int randomNumber = random.nextInt(5501) + 4000;
                this.sleep(randomNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
