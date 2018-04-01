import edu.princeton.cs.algs4.StdOut;

/**
 * Created by 87057 on 2018/3/26.
 */
public class DemoThread1 implements Runnable{
    @Override
    public void run(){
            StdOut.println("hello from Runnable");
        }
    public static void main(String[] args){
        Thread[] thread = new Thread[8];
        DemoThread1 demo = new DemoThread1();
        for(int i =0;i<thread.length;i++){
                thread[i] = new Thread(demo,"hah");
                StdOut.println(i+":");
            thread[i].start();
        }
    }
}
