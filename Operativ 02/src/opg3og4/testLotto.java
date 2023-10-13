package opg3og4;

public class testLotto {
    public static void main(String[] args) {
        Lottoraek[] lottoRaak = new Lottoraek[10000000];
        for (int i = 0; i < lottoRaak.length; i++) {
            lottoRaak[i] = new Lottoraek();
        }
        Lottoraek rigtigt = new Lottoraek();
        int[] antalRigte = new int[8];
        long l1 = System.nanoTime();
        for (int i = 0; i < lottoRaak.length; i++) {
            antalRigte[lottoRaak[i].antalrigtige(rigtigt)]++;
        }
        long l2 = System.nanoTime();
        System.out.println("Køretiden for lottorække sortering var " + (l2 - l1) / 1000000
                + " millisekunder");
        for (int i = 0; i < 8; i++) {
            System.out.println("Antal der havde " + i + " rigtige var " + antalRigte[i] + ".");
        }
        int samletTal = 0;
        for (int i = 0; i < 8; i++) {
            samletTal += antalRigte[i];
        }
        System.out.println("Samlet antal er " + samletTal);
    }
}
