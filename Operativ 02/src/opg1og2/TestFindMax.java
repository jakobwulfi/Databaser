package opg1og2;

import java.util.Random;
public class TestFindMax {
    private static final int rowindex = 2;
    private static final int colindex = 200000000;
    private static int[][] board = new int[rowindex][colindex];
    public static void main(String[] args) {
        fillBoard();
        //printBoard();
        long l1 = System.nanoTime();
        System.out.println("Max: " + findMax());
        long l2 = System.nanoTime();
        System.out.println("Køretiden for findMax() var " + (l2 - l1) / 1000000
                + " millisekunder");
        long l3 = System.nanoTime();
        try {
            System.out.println("Max: " +
                    findMaxThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long l4 = System.nanoTime();
        System.out.println("Køretiden for findMaxThread() var " + (l4 - l3) / 1000000
                + " millisekunder");
    }
    public static int findMax() {
        int max = -1;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] > max) {
                    max = board[row][col];
                }
            }
        }
        return max;
    }
    public static int findMaxThread() throws InterruptedException {
        int max = -1;
        Fred fred1 = new Fred(board[0]);
        Fred fred2 = new Fred(board[1]);
        fred1.start();
        fred2.start();
        fred1.join();
        fred2.join();
        if (fred1.getMax() > fred2.getMax()) {
            max = fred1.getMax();
        } else {
            max = fred2.getMax();
        }
        return max;
    }
    public static void fillBoard() {
        Random rand = new Random();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length;
                 col++) {
                board[row][col] = rand.nextInt(1000);
            }
        }
    }
    public static void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
