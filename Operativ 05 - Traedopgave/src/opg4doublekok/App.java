package opg4doublekok;

public class App {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Kok kok = new Kok("Bob", counter);
        Kok kok2 = new Kok("Jens", counter);
        Tjener tjener1 = new Tjener(counter, "Louise");
        Tjener tjener2 = new Tjener(counter, "Peter");
        // start

        kok.start();
        kok2.start();
        tjener1.start();
        tjener2.start();
        try {
            kok.join();
            kok2.join();
            tjener1.join();
            tjener2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
