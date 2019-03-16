import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        List<List<Integer>> tabel1 = Main.failistLugemine("tabel1.txt");
        List<List<Integer>> tabel2 = Main.failistLugemine("tabel2.txt");
        Tehe tehe1 = new Tehe(tabel1);
        Tehe tehe2 = new Tehe(tabel2);
        System.out.println("kas tehe1 on kommutatiivne: " + tehe1.onKommutatiivne());
        System.out.println("kas tehe1 on assotsiatiivne: " + tehe1.onAssotsiatiivne());
        System.out.println("kas tehe2 on kommutatiivne: " + tehe2.onKommutatiivne());
        System.out.println("kas tehe2 on assotsiatiivne: " + tehe2.onAssotsiatiivne());
        System.out.println("kas kehtib distributiivsus: " + tehe1.vasakpoolneDistributiivsus(tehe2));
    }
}
