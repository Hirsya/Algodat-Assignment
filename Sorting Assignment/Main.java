import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] data = {5, 2, 9, 1, 5, 6};
        System.out.println("Acak         : " + Arrays.toString(data));
        runAll(data);

        System.out.println();
        int[] reversed = {5, 4, 3, 2, 1};
        System.out.println("Terbalik     : " + Arrays.toString(reversed));
        runAll(reversed);

        System.out.println();
        int[] sorted = {1, 2, 3, 4, 5};
        System.out.println("Sudah urut   : " + Arrays.toString(sorted));
        runAll(sorted);

        System.out.println();
        int[] negative = {-3, 0, -10, 7, -3};
        System.out.println("Negatif      : " + Arrays.toString(negative));
        runAll(negative);

        System.out.println();
        System.out.println("== Tipe primitif lain ==");

        long[] longs = {5000000000L, 12L, 750L};
        System.out.println("Long awal    : " + Arrays.toString(longs));
        InsertionSort.sort(longs);
        System.out.println("Insertion    : " + Arrays.toString(longs));

        double[] doubles = {3.5, 1.2, 9.9, 2.0};
        System.out.println("Double awal  : " + Arrays.toString(doubles));
        MergeSort.sort(doubles);
        System.out.println("Merge        : " + Arrays.toString(doubles));

        float[] floats = {2.5f, 0.5f, 4.0f};
        System.out.println("Float awal   : " + Arrays.toString(floats));
        ShellSort.sort(floats);
        System.out.println("Shell        : " + Arrays.toString(floats));

        System.out.println();
        System.out.println("== Kasus tepi ==");

        int[] empty = {};
        BubbleSort.sort(empty);
        SelectionSort.sort(empty);
        InsertionSort.sort(empty);
        ShellSort.sort(empty);
        MergeSort.sort(empty);
        QuickSort.sort(empty);
        System.out.println("Array kosong : " + Arrays.toString(empty));

        int[] single = {7};
        BubbleSort.sort(single);
        SelectionSort.sort(single);
        InsertionSort.sort(single);
        ShellSort.sort(single);
        MergeSort.sort(single);
        QuickSort.sort(single);
        System.out.println("Satu elemen  : " + Arrays.toString(single));

        int[] nullArray = null;
        BubbleSort.sort(nullArray);
        SelectionSort.sort(nullArray);
        InsertionSort.sort(nullArray);
        ShellSort.sort(nullArray);
        MergeSort.sort(nullArray);
        QuickSort.sort(nullArray);
        System.out.println("Array null   : tidak error");
    }

    private static void runAll(int[] data) {
        int[] bubble = data.clone();
        BubbleSort.sort(bubble);
        System.out.println("  Bubble     : " + Arrays.toString(bubble));

        int[] selection = data.clone();
        SelectionSort.sort(selection);
        System.out.println("  Selection  : " + Arrays.toString(selection));

        int[] insertion = data.clone();
        InsertionSort.sort(insertion);
        System.out.println("  Insertion  : " + Arrays.toString(insertion));

        int[] shell = data.clone();
        ShellSort.sort(shell);
        System.out.println("  Shell      : " + Arrays.toString(shell));

        int[] merge = data.clone();
        MergeSort.sort(merge);
        System.out.println("  Merge      : " + Arrays.toString(merge));

        int[] quick = data.clone();
        QuickSort.sort(quick);
        System.out.println("  Quick      : " + Arrays.toString(quick));
    }
}
