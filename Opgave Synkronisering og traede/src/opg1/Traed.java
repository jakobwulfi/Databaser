package opg1;

/**
 * Tråd med et navn og en run metode, der
 * anvender den kritiske sektion.
 */
public class Traed extends Thread {
        private Faelles fa;
        private String navn;
        public Traed(String navn, Faelles fa) {
            this.navn = navn;
            this.fa = fa;
        }

    /**
     * run-metode for tråden. Metoden har et for-loop,
     * der tilgår den kritiske metode i fællesklassen og fyldemetoden.
     */
    public void run() {
             for (int j=0; j<100;j++) {
                 fa.kritiskSection();
                 fa.tagerRandomTid(2);
             }
            System.out.println(this.navn + ": " + fa.getGlobal());
    }

}
