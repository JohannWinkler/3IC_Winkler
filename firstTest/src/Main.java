public class Main {
    public static void main(String[] args) {
        int[][] intArr = new int[3][5];

        ArrayExercise arrayExercise = new ArrayExercise();

        arrayExercise.fillArr(intArr);
        arrayExercise.printArr(intArr);
        intArr = arrayExercise.rotateArr(intArr);
        arrayExercise.printArr(intArr);
    }
}
