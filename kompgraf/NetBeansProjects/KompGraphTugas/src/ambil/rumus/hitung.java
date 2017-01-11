package ambil.rumus;

import java.util.Scanner;

public class hitung {

    public static void main(String[] xya) {
        Scanner s = new Scanner(System.in);
        System.out.print("Masukan panjang = ");
        int panjang = s.nextInt();
        System.out.print("Masukan lebar = ");
        int lebar = s.nextInt();

        ambilRumus aR = new ambilRumus();
        aR.panjang = panjang;
        aR.lebar = lebar;
        aR.luas1();
        //System.out.print("nilai luas"+luas);

    }

}
