import java.util.*;
import java.io.File;
import javax.swing.JOptionPane;

// comment2
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Info");
        boolean jätka = true;
        while (jätka == true) {
            String sisestatakse = JOptionPane.showInputDialog(null, "Sisesta midagi ", "Andmete sisestamine",
                    JOptionPane.QUESTION_MESSAGE);
            jätka = false;
        }
    }

    public static  List<List<Integer>> failistLugemine(String failiNimi) throws Exception {
        File fail = new File(failiNimi);
        List<List<Integer>> tabel = new ArrayList<>();
        try(Scanner sc = new Scanner(fail, "UTF-8")){
            while (sc.hasNextLine()) {
                String rida = sc.nextLine();
                String[] tükid = rida.split(" ");
                List<Integer> arvud = new ArrayList<>();
                for (String arv : tükid) {
                    arvud.add(Integer.parseInt(arv));
                }
                tabel.add(arvud);
            }
        }
        return tabel;
    }
}
