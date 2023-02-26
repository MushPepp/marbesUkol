import java.io.*;
import java.util.*;

public class Marbes {

    public static String MAX(Integer[] x) {

        int max = Collections.max(Arrays.asList(x));
        int pocet = 0;

        for(int i = 1;i<x.length;i++) {
            if(x[i]==max) {
                pocet++;
            }
        }
        int[] pole = new int[pocet];
        for(int j = 0;j<pocet;j++) {
            pole[j] = max;
        }
        return Arrays.toString(pole);
    }

    public static float AVG(Integer[] x,int y) {
        float h = 0;
        for(int pole : x) {
            h = h+pole;
        }
        float prumer = h/y;
        return prumer;
    }
    public static void WRITE(String hodnota, String ns) throws IOException {
        File file = new File(ns);
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter br = new BufferedWriter(fr);
        br.write("\n"+hodnota);

        br.close();
        fr.close();

    }
    public static void EXIT() { //konec programu
        System.exit(25);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Zadejte nazev souboru");
        String cestaSouboru = sc.nextLine();
        BufferedReader reader;

            File file = new File(cestaSouboru);
        List<Integer> list = new ArrayList<Integer>();

if(file.exists())

    {
        try (LineNumberReader lnr = new LineNumberReader(new FileReader(file))) {

            while (lnr.readLine() != null) ;

            int pocetRadku = lnr.getLineNumber();
            reader = new BufferedReader(new FileReader(file));
            String radek = reader.readLine();
            while (radek != null) {
                list.add(Integer.parseInt(radek));
                radek = reader.readLine();
            }
            Integer[] cisla = list.toArray(new Integer[0]);
            for (int pole : cisla) {
                System.out.println(pole);
            }
            lnr.close();

            System.out.println("zadej prikaz(max, avg, write, exit)");
            String prikaz = sc.next();
            prikaz = prikaz.toLowerCase();
            boolean podminka;
            if(prikaz.equals("max")||prikaz.equals("avg")||prikaz.equals("write")||prikaz.equals("exit")) {
            } else {
                podminka = false;

                while (!podminka) {
                    System.out.println("chyba, zadej spravny prikaz(max, avg, write, exit)");
                    prikaz = sc.next();
                    prikaz = prikaz.toLowerCase();
                    podminka=true;
                }
            }
            while(!"exit".equals(prikaz)) {
                if (prikaz.equals("max")) {
                    System.out.println(MAX(cisla));
                } else if (prikaz.equals("avg")) {
                    System.out.println(AVG(cisla, pocetRadku));
                } else if (prikaz.equals("write")) {
                    System.out.println("zadej hodnotu pro zapsani do souboru");
                    String hSoubor = sc.next();
                    WRITE(hSoubor, cestaSouboru);
                    System.out.println("hodnota byla zapsana");
                }
                System.out.println("zadej prikaz(max, avg, write, exit)");
                prikaz = sc.next();
                prikaz = prikaz.toLowerCase();
            }
                EXIT();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }else {
    System.out.println("soubor neexistuje");
    EXIT();
}

    }
}

