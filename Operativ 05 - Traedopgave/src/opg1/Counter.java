package opg1;

public class Counter {
    private int tjenerTæller = 0;
    private int kokketæller = 0;

    public Counter() {
    }
    public int getTjenerTæller() {
        return tjenerTæller;
    }
    public void updateTjenerTæller() {
        ++this.tjenerTæller;
        System.out.println("Bestilling nr " + tjenerTæller + " modtaget.");
    }
    public int getKokketæller() {
        return kokketæller;
    }
    public void updateKokketæller() {
        ++this.kokketæller;
        System.out.println("Kok gået igang med bestilling nr " + kokketæller + ".");
    }
}
