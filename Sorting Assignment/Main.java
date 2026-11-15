public class Main {
    public static void main(String[] args) {
        int[] data = {5, 2, 9, 1, 5, 6};
        System.out.println("Acak         : " + listToString(toList(data)));
        runAll(data);

        System.out.println();
        int[] reversed = {5, 4, 3, 2, 1};
        System.out.println("Terbalik     : " + listToString(toList(reversed)));
        runAll(reversed);

        System.out.println();
        int[] sorted = {1, 2, 3, 4, 5};
        System.out.println("Sudah urut   : " + listToString(toList(sorted)));
        runAll(sorted);

        System.out.println();
        int[] negative = {-3, 0, -10, 7, -3};
        System.out.println("Negatif      : " + listToString(toList(negative)));
        runAll(negative);

        System.out.println();
        System.out.println("== Tipe primitif lain ==");

        long[] longs = {5000000000L, 12L, 750L};
        System.out.println("Long awal    : " + listToString(toList(longs)));
        System.out.println("Insertion    : " + listToString(InsertionSort.sort(toList(longs))));

        double[] doubles = {3.5, 1.2, 9.9, 2.0};
        System.out.println("Double awal  : " + listToString(toList(doubles)));
        System.out.println("Merge        : " + listToString(MergeSort.sort(toList(doubles))));

        float[] floats = {2.5f, 0.5f, 4.0f};
        System.out.println("Float awal   : " + listToString(toList(floats)));
        System.out.println("Shell        : " + listToString(ShellSort.sort(toList(floats))));

        System.out.println();
        System.out.println("== Kasus tepi ==");

        System.out.println("List kosong  : " + listToString(toList(new int[]{})));
        runAll(new int[]{});

        System.out.println("Satu elemen  : " + listToString(toList(new int[]{7})));
        runAll(new int[]{7});

        System.out.println("List null    : tidak error");
        BubbleSort.sort((IntNode) null);
        SelectionSort.sort((IntNode) null);
        InsertionSort.sort((IntNode) null);
        ShellSort.sort((IntNode) null);
        MergeSort.sort((IntNode) null);
        QuickSort.sort((IntNode) null);
    }

    private static void runAll(int[] data) {
        System.out.println("  Bubble     : " + listToString(BubbleSort.sort(toList(data))));
        System.out.println("  Selection  : " + listToString(SelectionSort.sort(toList(data))));
        System.out.println("  Insertion  : " + listToString(InsertionSort.sort(toList(data))));
        System.out.println("  Shell      : " + listToString(ShellSort.sort(toList(data))));
        System.out.println("  Merge      : " + listToString(MergeSort.sort(toList(data))));
        System.out.println("  Quick      : " + listToString(QuickSort.sort(toList(data))));
    }

    private static IntNode toList(int[] array) {
        IntNode head = null;
        IntNode tail = null;
        for (int value : array) {
            IntNode node = new IntNode(value);
            if (head == null) {
                head = node;
            } else {
                node.prev = tail;
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }

    private static LongNode toList(long[] array) {
        LongNode head = null;
        LongNode tail = null;
        for (long value : array) {
            LongNode node = new LongNode(value);
            if (head == null) {
                head = node;
            } else {
                node.prev = tail;
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }

    private static FloatNode toList(float[] array) {
        FloatNode head = null;
        FloatNode tail = null;
        for (float value : array) {
            FloatNode node = new FloatNode(value);
            if (head == null) {
                head = node;
            } else {
                node.prev = tail;
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }

    private static DoubleNode toList(double[] array) {
        DoubleNode head = null;
        DoubleNode tail = null;
        for (double value : array) {
            DoubleNode node = new DoubleNode(value);
            if (head == null) {
                head = node;
            } else {
                node.prev = tail;
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }

    private static String listToString(IntNode head) {
        StringBuilder sb = new StringBuilder("[");
        for (IntNode cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data);
            if (cur.next != null) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }

    private static String listToString(LongNode head) {
        StringBuilder sb = new StringBuilder("[");
        for (LongNode cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data);
            if (cur.next != null) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }

    private static String listToString(FloatNode head) {
        StringBuilder sb = new StringBuilder("[");
        for (FloatNode cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data);
            if (cur.next != null) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }

    private static String listToString(DoubleNode head) {
        StringBuilder sb = new StringBuilder("[");
        for (DoubleNode cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data);
            if (cur.next != null) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }
}
