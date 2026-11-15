public class ShellSort {
    public static void sort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int key = array[i];
                int j = i - gap;
                while (j >= 0 && array[j] > key) {
                    array[j + gap] = array[j];
                    j -= gap;
                }
                array[j + gap] = key;
            }
        }
    }

    public static void sort(long[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                long key = array[i];
                int j = i - gap;
                while (j >= 0 && array[j] > key) {
                    array[j + gap] = array[j];
                    j -= gap;
                }
                array[j + gap] = key;
            }
        }
    }

    public static void sort(float[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                float key = array[i];
                int j = i - gap;
                while (j >= 0 && array[j] > key) {
                    array[j + gap] = array[j];
                    j -= gap;
                }
                array[j + gap] = key;
            }
        }
    }

    public static void sort(double[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                double key = array[i];
                int j = i - gap;
                while (j >= 0 && array[j] > key) {
                    array[j + gap] = array[j];
                    j -= gap;
                }
                array[j + gap] = key;
            }
        }
    }
}
