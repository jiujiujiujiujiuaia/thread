;

import edu.princeton.cs.algs4.StdOut;


/**
 * Created by 87057 on 2018/3/26.
 */
public class Saler implements Runnable{
    private String name;
    private Server_ticket serve;

    public  Saler(String name,Server_ticket serve){
        this.name = name;
        this.serve = serve;
    }

    @Override
    public void run()  {
        while(serve.getRemaining()>0){
            synchronized (this){
                StdOut.print(Thread.currentThread().getName()+"出售第"+serve.getRemaining());
                int remains = serve.sale(1);
                if(remains>0){
                    StdOut.println("成功出售 剩余"+serve.getRemaining());
                }
                else {
                    StdOut.println("已经全部售空");
                }

            }
        }


    }
    public static void main(String[] args){
        Server_ticket serve = new Server_ticket("黄石",500);
        Saler sale = new Saler("售票程序",serve);
        Thread threads[] = new Thread[8];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(sale, "窗口" + (i + 1));
            System.out.println("窗口" + (i + 1) + "开始出售 " + serve.getTicketName() + " 的票...");
            threads[i].start();
        }
    }


}
