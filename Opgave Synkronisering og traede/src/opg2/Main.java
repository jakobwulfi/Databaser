package opg2;
/**
 * Main klasse indeholdene Main-metoden, turn feltet og
 * flag felt-arrayen, samt get- og set-metoder.
 */
public class Main {
    private static int turn;
    private static boolean[] flag;
    public static void main(String[] args) {
        flag = new boolean[2];
        flag[0] = false;
        flag[1] = false;
        turn = 1;
        Faelles faelles = new Faelles();
        Traed traed1 = new Traed("Tråd 1", faelles, 0);
        Traed traed2 = new Traed("Tråd 2", faelles, 1);
        traed1.start();
        traed2.start();
        try {
            traed1.join();
            traed2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Endeligt: " + faelles.getGlobal());
    }

    /**
     * Returnerer boolean værdien for den pågældende tråd.
     * @param index == 0 || 1
     * @return boolean
     */
    public static boolean getFlag(int index) {
        return flag[index];
    }

    /**
     * Setter flagget for en tråd til true eller false.
     * @param index 0 || 1
     * @param boo boolean
     */
    public static void setFlag(int index, boolean boo) {
        flag[index] = boo;
    }
    public static int getTurn() {
        return turn;
    }
    public static void setTurn(int i) {
        turn = i;
    }
}
