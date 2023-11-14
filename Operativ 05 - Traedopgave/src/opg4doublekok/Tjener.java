package opg4doublekok;

public class Tjener extends Thread {
    private Counter c;
    private String navn;

    public Tjener(Counter c, String navn) {
        this.c = c;
        this.navn = navn;
    }

    public void run() {
        while (1 == 1) {
            c.updateTjenerTæller();
            try {
                this.sleep(4500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
