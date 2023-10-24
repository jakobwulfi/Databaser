package opg3;

public class Traed extends Thread {
        private Faelles fa;
        private String navn;
        public Traed(String navn, Faelles fa) {
            this.navn = navn;
            this.fa = fa;
        }
        public void run() {
             for (int j=0; j<100;j++) {
                 fa.kritiskSection();
                 fa.tagerRandomTid(2);
             }
            System.out.println(this.navn + ": " + fa.getGlobal());
    }

}
