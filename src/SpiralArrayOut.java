import java.util.Arrays;
import java.util.Scanner;

public class SpiralArrayOut {
    private static final String START_MESSAGE = "Введите размер квадрата(3 <= размер <= 10):";
    private static final String BAD_REQUEST_MESSAGE = "Проверьте корректность введенных данных";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(START_MESSAGE);
        int size = scanner.nextInt();
        if(validate(size)) {
            soutArray(getSpiralArray(size));
        } else {
            System.out.println(BAD_REQUEST_MESSAGE);
        }
    }

    private static void soutArray(int[][] array){
        for(int[] row : array){
            System.out.println(Arrays.toString(row));
        }
    }

    private static int[][] getSpiralArray(int size) {
        int[][] result = new int[size][size];

        int leftSide = 0;
        int rightSide = result[0].length - 1;
        int topSide = 0;
        int downSide = result.length - 1;

        int countStep = 0;

        while (downSide >= topSide && rightSide >= leftSide) {
            for (int a = leftSide; a <= rightSide; a++) {
                result[topSide][a] = countStep;
                countStep++;
            }
            topSide++;

            for (int b = topSide; b <= downSide; b++) {
                result[b][rightSide] = countStep;
                countStep++;
            }
            rightSide--;


            if (topSide <= downSide) {
                for (int c = rightSide; c >= leftSide; c--) {
                    result[downSide][c] = countStep;
                    countStep++;
                }
                downSide--;
            }
            if (leftSide <= rightSide) {
                for (int d = downSide; d >= topSide; d--) {
                    result[d][leftSide] = countStep;
                    countStep++;
                }
                leftSide++;
            }
        }
        return result;
    }

    private static boolean validate(int size){
        return size >= 3 && size <= 10;
    }
}