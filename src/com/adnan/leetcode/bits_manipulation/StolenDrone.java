// "static void main" must be defined in a public class.
public class StolenDrone {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] ids = new int[]{1, 2, 3, 1, 2};
        int id = getStolenDrone(ids);
        System.out.println(id);
    }

    private static int getStolenDrone(int[] ids) {
        int a = ids[0];
        for (int i = 1; i < ids.length; i++) {
            a = a ^ ids[i];
        }
        return a;
    }
}