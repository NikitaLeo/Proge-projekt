import java.util.*;
import java.io.File;
import javax.swing.JOptionPane;

//comment
// Dialoogid nüüd kõik hüpikaknas. Veel üks mure on sellega, et kas peaks äkki tegema nii,
//et kui ta vastab, kas tehe on nt kommutatiivne, siis ta  ei ütle true või false vaid
//jah või ei. Mis sa arvad?
public class Main {
    public static void main(String[] args) throws Exception {
        JOptionPane.showMessageDialog(null, "Tere tulemast! See programm kontrollib etteantud " +
                "tehte assotsiatiivsust, kommutatiivsust ja distributiivsust. Alustada programmi tööd?");

        boolean jätka = true;
        while (jätka) {
            int a = 1;

            //küsin kasutajalt tehte faili
            String tehe = JOptionPane.showInputDialog(null,
                    "Sisesta tehte faili nimi", "Fail", JOptionPane.QUESTION_MESSAGE);

            //küsib kasutajalt tehte tüüpi
            String[] tehted = {"kommutatiivsus", "assotsiatiivsus", "distributiivsus"};
            String sisestatakse = (String) JOptionPane.showInputDialog(null,
                    "Vali tehte tüüp", "Tehe", JOptionPane.QUESTION_MESSAGE,
                    null, tehted, tehted[0]);

            //loeb tehte failist listi
            List<List<Integer>> tabel1 = Main.failistLugemine(tehe);
            Tehe tehe1 = new Tehe(tabel1);

            //vastavalt vastatud tehte tüübile teostatakse kontroll ja väljastatakse tulemus
            if (sisestatakse.equals("kommutatiivsus")){
                JOptionPane.showMessageDialog(null,
                        "Kas tehe on kommutatiivne: "+ tehe1.onKommutatiivne());
            }

            else if (sisestatakse.equals("assotsiatiivsus")){
                JOptionPane.showMessageDialog(null,
                        "Kas tehe on assotsiatiivne: " + tehe1.onAssotsiatiivne());
            }

            else if (sisestatakse.equals("distributiivsus")){
                String teheTeine = JOptionPane.showInputDialog(null,
                        "Sisesta teise tehte faili nimi", "Fail", JOptionPane.QUESTION_MESSAGE);
                List<List<Integer>> tabel2 = Main.failistLugemine(teheTeine);
                Tehe tehe2 = new Tehe(tabel2);

                JOptionPane.showMessageDialog(null,
                        "Kas kehtib distributiivsus: " + tehe1.onDistributiivne(tehe2));
            }

            //küsib kasutajalt, kas jätkata programmi tööd või lõpetada
            String[] valikud = {"Jah", "Ei"};
            String jätkata =(String) JOptionPane.showInputDialog(null,
                    "Kas soovid jätkata?", "Jätkamine", JOptionPane.QUESTION_MESSAGE,
                    null, valikud, valikud[0]);

            if (jätkata.equals("Ei")){
                jätka = false; //lõpetab programmi töö
            }

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
