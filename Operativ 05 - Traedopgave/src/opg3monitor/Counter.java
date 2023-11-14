package opg3monitor;

public class Counter {
    private int tjenerTæller = 0;
    private int kokketæller = 0;

    public Counter() {
    }
    public int getTjenerTæller() {
        return tjenerTæller;
    }
    public synchronized void updateTjenerTæller() {
        ++this.tjenerTæller;
        System.out.println("Bestilling nr " + tjenerTæller + " modtaget.");
        notify();
    }
    public int getKokketæller() {
        return kokketæller;
    }
    public synchronized void updateKokketæller() {
        try {
            if (tjenerTæller == kokketæller) {
                System.out.println("Kok venter.");
                wait();
            }
            ++this.kokketæller;
            System.out.println("Kok tilbereder bestilling nr " + kokketæller + ".");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
