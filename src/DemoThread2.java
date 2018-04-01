import edu.princeton.cs.algs4.StdOut;

/**
 * Created by 87057 on 2018/3/26.
 */
public class DemoThread2 extends Thread{
    public void run(){
        StdOut.println("hello from Thread");
    }
    public static void main(String[] args){
        DemoThread2 thread = new DemoThread2();
        thread.start();
    }
}
