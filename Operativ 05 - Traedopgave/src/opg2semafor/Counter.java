package opg2semafor;

import java.util.concurrent.Semaphore;

public class Counter {
    private int tjenerTæller = 0;
    private int kokketæller = 0;
    private Semaphore semaphore = new Semaphore(1);
    private Semaphore semaphore2 = new Semaphore(0);

    public Counter() {
    }
    public int getTjenerTæller() {
        return tjenerTæller;
    }
    public void updateTjenerTæller() {
        try {
            semaphore.acquire();
            ++this.tjenerTæller;
            System.out.println("Bestilling nr " + tjenerTæller + " modtaget.");
            semaphore.release();
            semaphore2.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public int getKokketæller() {
        return kokketæller;
    }
    public void updateKokketæller() {
        try {
            semaphore2.acquire();
            ++this.kokketæller;
            System.out.println("Kok gået igang med bestilling nr " + kokketæller + ".");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
