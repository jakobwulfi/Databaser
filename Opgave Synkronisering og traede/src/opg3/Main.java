package opg3;

public class Main {
    public static void main(String[] args) {
        Faelles faelles = new Faelles();
        Traed traed1 = new Traed("Tråd 1", faelles);
        Traed traed2 = new Traed("Tråd 2", faelles);
        traed1.start();
        traed2.start();
        try {
            traed1.join();
            traed2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Endeligt: " + faelles.getGlobal());
        // prøvede randomTid værdier på 10, 5 og 2, fik varierende resultater
    }
}
