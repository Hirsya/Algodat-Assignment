public class ShellSort {
    public static IntNode sort(IntNode head) {
        int n = size(head);
        if (n < 2) {
            return head;
        }

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (IntNode cur = stepForward(head, gap); cur != null; cur = cur.next) {
                int key = cur.data;
                IntNode write = cur;
                IntNode j = stepBack(cur, gap);

                while (j != null && j.data > key) {
                    write.data = j.data;
                    write = j;
                    j = stepBack(j, gap);
                }

                write.data = key;
            }
        }

        return head;
    }

    static int size(IntNode head) {
        int n = 0;
        for (IntNode cur = head; cur != null; cur = cur.next) {
            n++;
        }
        return n;
    }

    static IntNode stepForward(IntNode node, int steps) {
        while (steps > 0 && node != null) {
            node = node.next;
            steps--;
        }
        return node;
    }

    static IntNode stepBack(IntNode node, int steps) {
        while (steps > 0 && node != null) {
            node = node.prev;
            steps--;
        }
        return node;
    }

    public static LongNode sort(LongNode head) {
        int n = size(head);
        if (n < 2) {
            return head;
        }

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (LongNode cur = stepForward(head, gap); cur != null; cur = cur.next) {
                long key = cur.data;
                LongNode write = cur;
                LongNode j = stepBack(cur, gap);

                while (j != null && j.data > key) {
                    write.data = j.data;
                    write = j;
                    j = stepBack(j, gap);
                }

                write.data = key;
            }
        }

        return head;
    }

    static int size(LongNode head) {
        int n = 0;
        for (LongNode cur = head; cur != null; cur = cur.next) {
            n++;
        }
        return n;
    }

    static LongNode stepForward(LongNode node, int steps) {
        while (steps > 0 && node != null) {
            node = node.next;
            steps--;
        }
        return node;
    }

    static LongNode stepBack(LongNode node, int steps) {
        while (steps > 0 && node != null) {
            node = node.prev;
            steps--;
        }
        return node;
    }

    public static FloatNode sort(FloatNode head) {
        int n = size(head);
        if (n < 2) {
            return head;
        }

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (FloatNode cur = stepForward(head, gap); cur != null; cur = cur.next) {
                float key = cur.data;
                FloatNode write = cur;
                FloatNode j = stepBack(cur, gap);

                while (j != null && j.data > key) {
                    write.data = j.data;
                    write = j;
                    j = stepBack(j, gap);
                }

                write.data = key;
            }
        }

        return head;
    }

    static int size(FloatNode head) {
        int n = 0;
        for (FloatNode cur = head; cur != null; cur = cur.next) {
            n++;
        }
        return n;
    }

    static FloatNode stepForward(FloatNode node, int steps) {
        while (steps > 0 && node != null) {
            node = node.next;
            steps--;
        }
        return node;
    }

    static FloatNode stepBack(FloatNode node, int steps) {
        while (steps > 0 && node != null) {
            node = node.prev;
            steps--;
        }
        return node;
    }

    public static DoubleNode sort(DoubleNode head) {
        int n = size(head);
        if (n < 2) {
            return head;
        }

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (DoubleNode cur = stepForward(head, gap); cur != null; cur = cur.next) {
                double key = cur.data;
                DoubleNode write = cur;
                DoubleNode j = stepBack(cur, gap);

                while (j != null && j.data > key) {
                    write.data = j.data;
                    write = j;
                    j = stepBack(j, gap);
                }

                write.data = key;
            }
        }

        return head;
    }

    static int size(DoubleNode head) {
        int n = 0;
        for (DoubleNode cur = head; cur != null; cur = cur.next) {
            n++;
        }
        return n;
    }

    static DoubleNode stepForward(DoubleNode node, int steps) {
        while (steps > 0 && node != null) {
            node = node.next;
            steps--;
        }
        return node;
    }

    static DoubleNode stepBack(DoubleNode node, int steps) {
        while (steps > 0 && node != null) {
            node = node.prev;
            steps--;
        }
        return node;
    }
}
