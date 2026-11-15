public class MergeSort {
    public static IntNode sort(IntNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        IntNode right = split(head);
        IntNode left = sort(head);
        right = sort(right);
        return merge(left, right);
    }

    static IntNode split(IntNode head) {
        IntNode slow = head;
        IntNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        IntNode right = slow.next;
        slow.next = null;
        right.prev = null;
        return right;
    }

    static IntNode merge(IntNode a, IntNode b) {
        IntNode dummy = new IntNode(0);
        IntNode tail = dummy;

        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a.prev = tail;
                a = a.next;
            } else {
                tail.next = b;
                b.prev = tail;
                b = b.next;
            }
            tail = tail.next;
        }

        IntNode rest = (a != null) ? a : b;
        tail.next = rest;
        if (rest != null) {
            rest.prev = tail;
        }

        IntNode result = dummy.next;
        result.prev = null;
        return result;
    }

    public static LongNode sort(LongNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        LongNode right = split(head);
        LongNode left = sort(head);
        right = sort(right);
        return merge(left, right);
    }

    static LongNode split(LongNode head) {
        LongNode slow = head;
        LongNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        LongNode right = slow.next;
        slow.next = null;
        right.prev = null;
        return right;
    }

    static LongNode merge(LongNode a, LongNode b) {
        LongNode dummy = new LongNode(0L);
        LongNode tail = dummy;

        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a.prev = tail;
                a = a.next;
            } else {
                tail.next = b;
                b.prev = tail;
                b = b.next;
            }
            tail = tail.next;
        }

        LongNode rest = (a != null) ? a : b;
        tail.next = rest;
        if (rest != null) {
            rest.prev = tail;
        }

        LongNode result = dummy.next;
        result.prev = null;
        return result;
    }

    public static FloatNode sort(FloatNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        FloatNode right = split(head);
        FloatNode left = sort(head);
        right = sort(right);
        return merge(left, right);
    }

    static FloatNode split(FloatNode head) {
        FloatNode slow = head;
        FloatNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        FloatNode right = slow.next;
        slow.next = null;
        right.prev = null;
        return right;
    }

    static FloatNode merge(FloatNode a, FloatNode b) {
        FloatNode dummy = new FloatNode(0f);
        FloatNode tail = dummy;

        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a.prev = tail;
                a = a.next;
            } else {
                tail.next = b;
                b.prev = tail;
                b = b.next;
            }
            tail = tail.next;
        }

        FloatNode rest = (a != null) ? a : b;
        tail.next = rest;
        if (rest != null) {
            rest.prev = tail;
        }

        FloatNode result = dummy.next;
        result.prev = null;
        return result;
    }

    public static DoubleNode sort(DoubleNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        DoubleNode right = split(head);
        DoubleNode left = sort(head);
        right = sort(right);
        return merge(left, right);
    }

    static DoubleNode split(DoubleNode head) {
        DoubleNode slow = head;
        DoubleNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        DoubleNode right = slow.next;
        slow.next = null;
        right.prev = null;
        return right;
    }

    static DoubleNode merge(DoubleNode a, DoubleNode b) {
        DoubleNode dummy = new DoubleNode(0.0);
        DoubleNode tail = dummy;

        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a.prev = tail;
                a = a.next;
            } else {
                tail.next = b;
                b.prev = tail;
                b = b.next;
            }
            tail = tail.next;
        }

        DoubleNode rest = (a != null) ? a : b;
        tail.next = rest;
        if (rest != null) {
            rest.prev = tail;
        }

        DoubleNode result = dummy.next;
        result.prev = null;
        return result;
    }
}
