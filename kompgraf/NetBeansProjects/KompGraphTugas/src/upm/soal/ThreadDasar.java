package upm.soal;

public class ThreadDasar extends Thread{
    private int hitungMundur = 5;
    private static int jumlahThread = 0;
    
    public ThreadDasar(){
        super("Thread ke - "+ ++jumlahThread);
        start();
    }
    
    public void run(){
        while(true){
            System.out.println( getName()+ " : " + hitungMundur);
            if(--hitungMundur==0);
            return;
        }
    }
    
    public static void main(String[]args){
        for(int i=0; i<5; i++)
        new ThreadDasar();
    }
}