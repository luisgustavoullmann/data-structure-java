package greedy;

public class Scarecrow {
    public static int minimumScarecrows(int numField, String field) {
        int resp = 0;
        for (int i = 0; i < numField; i++) {
            if (field.charAt(i) == '.') {
                i += 2;
                resp++;
            }
        }
        return resp;
    }

    public static void main(String[] args) {
        System.out.println(minimumScarecrows(3, ".#."));
        System.out.println(minimumScarecrows(11, "...##....##"));
        System.out.println(minimumScarecrows(2, "##"));
    }
}
