public class MergeSort {
    public static void sort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        int mid = array.length / 2;
        int[] left = new int[mid];
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }

        int[] right = new int[array.length - mid];
        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }

        sort(left);
        sort(right);
        merge(array, left, right);
    }

    static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length)  array[k++] = left[i++];
        while (j < right.length) array[k++] = right[j++];
    }

    public static void sort(long[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        int mid = array.length / 2;
        long[] left = new long[mid];
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }

        long[] right = new long[array.length - mid];
        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }

        sort(left);
        sort(right);
        merge(array, left, right);
    }

    static void merge(long[] array, long[] left, long[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length)  array[k++] = left[i++];
        while (j < right.length) array[k++] = right[j++];
    }

    public static void sort(float[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        int mid = array.length / 2;
        float[] left = new float[mid];
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }

        float[] right = new float[array.length - mid];
        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }

        sort(left);
        sort(right);
        merge(array, left, right);
    }

    static void merge(float[] array, float[] left, float[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length)  array[k++] = left[i++];
        while (j < right.length) array[k++] = right[j++];
    }

    public static void sort(double[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        int mid = array.length / 2;
        double[] left = new double[mid];
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }

        double[] right = new double[array.length - mid];
        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }

        sort(left);
        sort(right);
        merge(array, left, right);
    }

    static void merge(double[] array, double[] left, double[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length)  array[k++] = left[i++];
        while (j < right.length) array[k++] = right[j++];
    }
}
