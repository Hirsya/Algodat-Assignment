public class SelectionSort {
    public static IntNode sort(IntNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        for (IntNode i = head; i != null; i = i.next) {
            IntNode min = i;
            for (IntNode j = i.next; j != null; j = j.next) {
                if (j.data < min.data) {
                    min = j;
                }
            }

            if (min != i) {
                int temp = i.data;
                i.data = min.data;
                min.data = temp;
            }
        }

        return head;
    }

    public static LongNode sort(LongNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        for (LongNode i = head; i != null; i = i.next) {
            LongNode min = i;
            for (LongNode j = i.next; j != null; j = j.next) {
                if (j.data < min.data) {
                    min = j;
                }
            }

            if (min != i) {
                long temp = i.data;
                i.data = min.data;
                min.data = temp;
            }
        }

        return head;
    }

    public static FloatNode sort(FloatNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        for (FloatNode i = head; i != null; i = i.next) {
            FloatNode min = i;
            for (FloatNode j = i.next; j != null; j = j.next) {
                if (j.data < min.data) {
                    min = j;
                }
            }

            if (min != i) {
                float temp = i.data;
                i.data = min.data;
                min.data = temp;
            }
        }

        return head;
    }

    public static DoubleNode sort(DoubleNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        for (DoubleNode i = head; i != null; i = i.next) {
            DoubleNode min = i;
            for (DoubleNode j = i.next; j != null; j = j.next) {
                if (j.data < min.data) {
                    min = j;
                }
            }

            if (min != i) {
                double temp = i.data;
                i.data = min.data;
                min.data = temp;
            }
        }

        return head;
    }
}
