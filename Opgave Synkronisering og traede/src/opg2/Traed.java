package opg2;
/**
 * Tråd med et navn og en run metode, der
 * anvender den kritiske sektion. Indeholder også
 * sit eget index, samt indexet for den anden tråd.
 */
public class Traed extends Thread {
        private Faelles fa;
        private String navn;
        private int index;
        private int otherIndex = 0;

    /**
     * Konstruerer en tråd med et navn, en fællesklassen
     * og et index. Hvis indexet er 0, bliver indexet for den anden
     * tråd sat til 1, ellers sættes det andet index
     * @param index skal være enten 1 eller 2, og der skal eksistere en tråd,
     *              der har det andet index, altså skal der være én tråd med
     *              index == 0 og en anden tråd med index == 1.
     */
        public Traed(String navn, Faelles fa, int index) {
            this.navn = navn;
            this.fa = fa;
            this.index = index;
            if (this.index == 0) {
                this.otherIndex = 1;
            }
        }
    /**
     * run-metode for tråden. Metoden har et for-loop,
     * der tilgår den kritiske metode i fællesklassen og fyldemetoden.
     * Inden metoden anvender den kritiske metode i loopet, sætter den
     * sit eget flag til true og sætter turn til den anden tråd.
     * Herefter venter den indtil det bliver dens tur igen, hvorefter den
     * anvender den kritiske metode. Tråden slutter så sin tur ved at
     * sætte sit flag til false, og anvender så fyldemetoden.
     */
        public void run() {
             for (int j=0; j<100;j++) {
                 Main.setFlag(this.index, true);
                 Main.setTurn(this.otherIndex);
                 while (Main.getFlag(otherIndex) && Main.getTurn() == otherIndex) {}
                 fa.kritiskSection();
                 Main.setFlag(index, false);
                 fa.tagerRandomTid(2);
             }
            System.out.println(this.navn + ": " + fa.getGlobal());
    }

}
