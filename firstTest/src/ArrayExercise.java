import java.util.Arrays;

public class ArrayExercise {
    int[][] rotateArr(int[][] intArr) {
        int[][] rotatedArr = new int[intArr[0].length][intArr.length];
        for (int i = 0; i < intArr.length; ++i) {
            for (int j = 0; j < intArr[0].length; ++j) {
                rotatedArr[j][intArr.length - 1 - i] = intArr[i][j];
            }
        }
        return rotatedArr;
    }

    void fillArr(int[][] intArr) {
        for (int i = 0; i < intArr.length; ++i) {
            for (int j = 0; j < intArr[i].length; ++j) {
                intArr[i][j] = j + intArr[i].length * i;
            }
        }
    }

    void printArr(int[][] intArr) {
        System.out.println();
        System.out.println(Arrays.deepToString(intArr).replace("], ", "]\n")
                .replace("[[", "[").replace("]]", "]"));
    }
}
