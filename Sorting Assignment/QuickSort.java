public class QuickSort {
    public static IntNode sort(IntNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        sort(head, last(head));
        return head;
    }

    static void sort(IntNode first, IntNode last) {
        while (first != null && last != null && first != last && first.prev != last) {
            IntNode p = partition(first, last);

            int leftSize = 0;
            for (IntNode n = first; n != p; n = n.next) {
                leftSize++;
            }

            int rightSize = 0;
            for (IntNode n = last; n != p; n = n.prev) {
                rightSize++;
            }

            if (leftSize < rightSize) {
                sort(first, p.prev);
                first = p.next;
            } else {
                sort(p.next, last);
                last = p.prev;
            }
        }
    }

    static IntNode partition(IntNode first, IntNode last) {
        int pivot = last.data;
        IntNode i = first;

        for (IntNode j = first; j != last; j = j.next) {
            if (j.data < pivot) {
                int temp = i.data;
                i.data = j.data;
                j.data = temp;
                i = i.next;
            }
        }

        int temp = i.data;
        i.data = last.data;
        last.data = temp;
        return i;
    }

    static IntNode last(IntNode head) {
        IntNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    public static LongNode sort(LongNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        sort(head, last(head));
        return head;
    }

    static void sort(LongNode first, LongNode last) {
        while (first != null && last != null && first != last && first.prev != last) {
            LongNode p = partition(first, last);

            int leftSize = 0;
            for (LongNode n = first; n != p; n = n.next) {
                leftSize++;
            }

            int rightSize = 0;
            for (LongNode n = last; n != p; n = n.prev) {
                rightSize++;
            }

            if (leftSize < rightSize) {
                sort(first, p.prev);
                first = p.next;
            } else {
                sort(p.next, last);
                last = p.prev;
            }
        }
    }

    static LongNode partition(LongNode first, LongNode last) {
        long pivot = last.data;
        LongNode i = first;

        for (LongNode j = first; j != last; j = j.next) {
            if (j.data < pivot) {
                long temp = i.data;
                i.data = j.data;
                j.data = temp;
                i = i.next;
            }
        }

        long temp = i.data;
        i.data = last.data;
        last.data = temp;
        return i;
    }

    static LongNode last(LongNode head) {
        LongNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    public static FloatNode sort(FloatNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        sort(head, last(head));
        return head;
    }

    static void sort(FloatNode first, FloatNode last) {
        while (first != null && last != null && first != last && first.prev != last) {
            FloatNode p = partition(first, last);

            int leftSize = 0;
            for (FloatNode n = first; n != p; n = n.next) {
                leftSize++;
            }

            int rightSize = 0;
            for (FloatNode n = last; n != p; n = n.prev) {
                rightSize++;
            }

            if (leftSize < rightSize) {
                sort(first, p.prev);
                first = p.next;
            } else {
                sort(p.next, last);
                last = p.prev;
            }
        }
    }

    static FloatNode partition(FloatNode first, FloatNode last) {
        float pivot = last.data;
        FloatNode i = first;

        for (FloatNode j = first; j != last; j = j.next) {
            if (j.data < pivot) {
                float temp = i.data;
                i.data = j.data;
                j.data = temp;
                i = i.next;
            }
        }

        float temp = i.data;
        i.data = last.data;
        last.data = temp;
        return i;
    }

    static FloatNode last(FloatNode head) {
        FloatNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    public static DoubleNode sort(DoubleNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        sort(head, last(head));
        return head;
    }

    static void sort(DoubleNode first, DoubleNode last) {
        while (first != null && last != null && first != last && first.prev != last) {
            DoubleNode p = partition(first, last);

            int leftSize = 0;
            for (DoubleNode n = first; n != p; n = n.next) {
                leftSize++;
            }

            int rightSize = 0;
            for (DoubleNode n = last; n != p; n = n.prev) {
                rightSize++;
            }

            if (leftSize < rightSize) {
                sort(first, p.prev);
                first = p.next;
            } else {
                sort(p.next, last);
                last = p.prev;
            }
        }
    }

    static DoubleNode partition(DoubleNode first, DoubleNode last) {
        double pivot = last.data;
        DoubleNode i = first;

        for (DoubleNode j = first; j != last; j = j.next) {
            if (j.data < pivot) {
                double temp = i.data;
                i.data = j.data;
                j.data = temp;
                i = i.next;
            }
        }

        double temp = i.data;
        i.data = last.data;
        last.data = temp;
        return i;
    }

    static DoubleNode last(DoubleNode head) {
        DoubleNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }
}
