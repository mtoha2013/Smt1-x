package ambil.rumus;

public class ambilRumus {

    public int panjang;
    public int lebar;
    public int luas;
    public int keliling;

    public void luas1() {
        luas = panjang * lebar;
        System.out.print("nilai luas = " + luas);

    }

    public void keliling1() {
        keliling = 2 * panjang * lebar;
    }
}
