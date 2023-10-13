package opg1og2;

public class Fred extends Thread {
    private int[] intArray;
    private int max = -1;
    public Fred(int[] intArray) {
        this.intArray = intArray;
    }
    public void run() {
        int temp = -1;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] > temp) {
                temp = intArray[i];
            }
        }
        this.max = temp;
    }

    public int getMax() {
        return max;
    }
}
