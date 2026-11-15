public class BubbleSort {
    public static IntNode sort(IntNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        boolean swapped;
        IntNode end = null;
        do {
            swapped = false;
            IntNode cur = head;
            while (cur.next != end) {
                if (cur.data > cur.next.data) {
                    int temp = cur.data;
                    cur.data = cur.next.data;
                    cur.next.data = temp;
                    swapped = true;
                }
                cur = cur.next;
            }
            end = cur;
        } while (swapped);

        return head;
    }

    public static LongNode sort(LongNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        boolean swapped;
        LongNode end = null;
        do {
            swapped = false;
            LongNode cur = head;
            while (cur.next != end) {
                if (cur.data > cur.next.data) {
                    long temp = cur.data;
                    cur.data = cur.next.data;
                    cur.next.data = temp;
                    swapped = true;
                }
                cur = cur.next;
            }
            end = cur;
        } while (swapped);

        return head;
    }

    public static FloatNode sort(FloatNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        boolean swapped;
        FloatNode end = null;
        do {
            swapped = false;
            FloatNode cur = head;
            while (cur.next != end) {
                if (cur.data > cur.next.data) {
                    float temp = cur.data;
                    cur.data = cur.next.data;
                    cur.next.data = temp;
                    swapped = true;
                }
                cur = cur.next;
            }
            end = cur;
        } while (swapped);

        return head;
    }

    public static DoubleNode sort(DoubleNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        boolean swapped;
        DoubleNode end = null;
        do {
            swapped = false;
            DoubleNode cur = head;
            while (cur.next != end) {
                if (cur.data > cur.next.data) {
                    double temp = cur.data;
                    cur.data = cur.next.data;
                    cur.next.data = temp;
                    swapped = true;
                }
                cur = cur.next;
            }
            end = cur;
        } while (swapped);

        return head;
    }
}
