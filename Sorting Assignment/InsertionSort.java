public class InsertionSort {
    public static IntNode sort(IntNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        for (IntNode cur = head.next; cur != null; cur = cur.next) {
            int key = cur.data;
            IntNode j = cur.prev;

            while (j != null && j.data > key) {
                j.next.data = j.data;
                j = j.prev;
            }

            if (j == null) {
                head.data = key;
            } else {
                j.next.data = key;
            }
        }

        return head;
    }

    public static LongNode sort(LongNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        for (LongNode cur = head.next; cur != null; cur = cur.next) {
            long key = cur.data;
            LongNode j = cur.prev;

            while (j != null && j.data > key) {
                j.next.data = j.data;
                j = j.prev;
            }

            if (j == null) {
                head.data = key;
            } else {
                j.next.data = key;
            }
        }

        return head;
    }

    public static FloatNode sort(FloatNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        for (FloatNode cur = head.next; cur != null; cur = cur.next) {
            float key = cur.data;
            FloatNode j = cur.prev;

            while (j != null && j.data > key) {
                j.next.data = j.data;
                j = j.prev;
            }

            if (j == null) {
                head.data = key;
            } else {
                j.next.data = key;
            }
        }

        return head;
    }

    public static DoubleNode sort(DoubleNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        for (DoubleNode cur = head.next; cur != null; cur = cur.next) {
            double key = cur.data;
            DoubleNode j = cur.prev;

            while (j != null && j.data > key) {
                j.next.data = j.data;
                j = j.prev;
            }

            if (j == null) {
                head.data = key;
            } else {
                j.next.data = key;
            }
        }

        return head;
    }
}
