public class QuickSort {
    public static void sort(int[] array) {
        if (array == null || array.length < 2) return;
    sort(array, 0, array.length - 1);
    }
    public static void sort(int[] array, int low, int high) {
        while (low < high) {
            int p = partition(array, low, high);
            if (p - low < high - p) {
                sort(array, low, p - 1);
                low = p + 1;
            } else {
                sort(array, p + 1, high);
                high = p - 1;
            }
        }
    }
    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];   
        int i = low;            

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        int temp = array[i];
        array[i] = array[high];
        array[high] = temp;
        return i;               
    }

    public static void sort(long[] array) {
        if (array == null || array.length < 2) return;
    sort(array, 0, array.length - 1);
    }
    public static void sort(long[] array, int low, int high) {
        while (low < high) {
            int p = partition(array, low, high);
            if (p - low < high - p) {
                sort(array, low, p - 1);
                low = p + 1;
            } else {
                sort(array, p + 1, high);
                high = p - 1;
            }
        }
    }
    public static int partition(long[] array, int low, int high) {
        long pivot = array[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                long temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        long temp = array[i];
        array[i] = array[high];
        array[high] = temp;
        return i;
    }

    public static void sort(float[] array) {
        if (array == null || array.length < 2) return;
    sort(array, 0, array.length - 1);
    }
    public static void sort(float[] array, int low, int high) {
        while (low < high) {
            int p = partition(array, low, high);
            if (p - low < high - p) {
                sort(array, low, p - 1);
                low = p + 1;
            } else {
                sort(array, p + 1, high);
                high = p - 1;
            }
        }
    }
    public static int partition(float[] array, int low, int high) {
        float pivot = array[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                float temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        float temp = array[i];
        array[i] = array[high];
        array[high] = temp;
        return i;
    }

    public static void sort(double[] array) {
        if (array == null || array.length < 2) return;
    sort(array, 0, array.length - 1);
    }
    public static void sort(double[] array, int low, int high) {
        while (low < high) {
            int p = partition(array, low, high);
            if (p - low < high - p) {
                sort(array, low, p - 1);
                low = p + 1;
            } else {
                sort(array, p + 1, high);
                high = p - 1;
            }
        }
    }
    public static int partition(double[] array, int low, int high) {
        double pivot = array[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                double temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        double temp = array[i];
        array[i] = array[high];
        array[high] = temp;
        return i;
    }
}
