import java.util.*;
import java.io.File;
import javax.swing.JOptionPane;

// comment
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Info");

        boolean jätka = true;
        while (jätka == true) {

            //küsin kasutajalt tehte faili
            String tehe = JOptionPane.showInputDialog(null,
                    "Sisesta tehte faili nimi", "Fail", JOptionPane.QUESTION_MESSAGE);

            //küsib kasutajalt tehte tüüpi, pmst saab seda ka ilma rippmenüüta aga nii
            //vist parem
            String[] tehted = {"kommutatiivsus", "assotsiatiivsus", "distributiivsus"};
            String sisestatakse = (String) JOptionPane.showInputDialog(null,
                    "Vali tehte tüüp", "Tehe", JOptionPane.QUESTION_MESSAGE,
                    null, tehted, tehted[0]);

            //loeb tehte tüübi failist listi
            List<List<Integer>> tabel1 = Main.failistLugemine(tehe);
            Tehe tehe1 = new Tehe(tabel1);

            //vastavalt vastatud tehte tüübile teostatakse tehe ja väljastatakse tulemus
            if (sisestatakse.equals("kommutatiivsus")){
                System.out.println("Kas tehe on kommutatiivne: " + tehe1.onKommutatiivne());
            }

            else if (sisestatakse.equals("assotsiatiivsus")){
                System.out.println("Kas tehe on assotsiatiivne: " + tehe1.onAssotsiatiivne());
            }

            else if (sisestatakse.equals("distributiivsus")){
                String teheTeine = JOptionPane.showInputDialog(null,
                        "Sisesta teise tehte faili nimi", "Fail", JOptionPane.QUESTION_MESSAGE);
                List<List<Integer>> tabel2 = Main.failistLugemine(teheTeine);
                Tehe tehe2 = new Tehe(tabel2);

                System.out.println("Kas kehtib distributiivsus: " + tehe1.onDistributiivne(tehe1, tehe2));
            }

            else {
                System.out.println("Sellist tehet meil ei ole.");
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
