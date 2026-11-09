public class Main {
    public static void main(String[] args) {
        HirsyaQueue<String> q = new HirsyaQueue<>();

        q.add("A");
        q.add("B");
        q.add("C");

        System.out.println("Isi queue : " + q);
        System.out.println("Size      : " + q.size());
        System.out.println("Front     : " + q.getFront());
        System.out.println("Empty     : " + q.isEmpty());

        System.out.println("Remove    : " + q.remove());
        System.out.println("Remove    : " + q.remove());
        System.out.println("Front     : " + q.getFront());
        System.out.println("Sisa      : " + q);

        q.clear();
        System.out.println("Setelah clear: size=" + q.size() + " empty=" + q.isEmpty());

        q.add("X");
        System.out.println("Tambah lagi  : " + q + " size=" + q.size());

        q.remove();
        System.out.println("Kosong       : size=" + q.size() + " empty=" + q.isEmpty());
    }
}
