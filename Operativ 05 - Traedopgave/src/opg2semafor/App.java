package opg2semafor;

public class App {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Kok kok = new Kok("Kok Bob", counter);
        Tjener tjener1 = new Tjener(counter, "Louise");
        Tjener tjener2 = new Tjener(counter, "Peter");
        // start

        kok.start();
        tjener1.start();
        tjener2.start();
        try {
            kok.join();
            tjener1.join();
            tjener2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
