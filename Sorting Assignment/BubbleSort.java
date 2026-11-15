public class BubbleSort {
    public static void sort(int[] array){
        if (array == null || array.length < 2) {
            return;
        }

        int n = array.length;
        for (int pass = 0 ; pass < n -1; pass++){
            boolean swapped = false ;
            for (int i = 0; i < n -1 - pass; i++){
                if(array[i] > array [i +1]){
                    int temp = array [i];
                    array[i] = array [i + 1];
                    array[i + 1]= temp;
                    swapped = true;
                }
            }
            if (!swapped){
                return;
            }
        }
    }

    public static void sort(long[] array){
        if (array == null || array.length < 2) {
            return;
        }

        int n = array.length;
        for (int pass = 0 ; pass < n -1; pass++){
            boolean swapped = false ;
            for (int i = 0; i < n -1 - pass; i++){
                if(array[i] > array [i +1]){
                    long temp = array [i];
                    array[i] = array [i + 1];
                    array[i + 1]= temp;
                    swapped = true;
                }
            }
            if (!swapped){
                return;
            }
        }
    }

    public static void sort(double[] array){
        if (array == null || array.length < 2) {
            return;
        }

        int n = array.length;
        for (int pass = 0 ; pass < n -1; pass++){
            boolean swapped = false ;
            for (int i = 0; i < n -1 - pass; i++){
                if(array[i] > array [i +1]){
                    double temp = array [i];
                    array[i] = array [i + 1];
                    array[i + 1]= temp;
                    swapped = true;
                }
            }
            if (!swapped){
                return;
            }
        }
    }

    public static void sort(float[] array){
        if (array == null || array.length < 2) {
            return;
        }

        int n = array.length;
        for (int pass = 0 ; pass < n -1; pass++){
            boolean swapped = false ;
            for (int i = 0; i < n -1 - pass; i++){
                if(array[i] > array [i +1]){
                    float temp = array [i];
                    array[i] = array [i + 1];
                    array[i + 1]= temp;
                    swapped = true;
                }
            }
            if (!swapped){
                return;
            }
        }
    }
}

