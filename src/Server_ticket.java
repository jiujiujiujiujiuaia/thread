import edu.princeton.cs.algs4.StdOut;

/**
 * Created by 87057 on 2018/3/26.
 */
public class Server_ticket {
    private String ticketname;
    private int totalcount;
    private int remaincount  ;
    public Server_ticket(String name, int number){
        this.ticketname = name;
        this.totalcount = number;
        this.remaincount = number;
    }
    public synchronized int sale(int number) {

        if(remaincount>0){
            remaincount -=number;
            try{
                Thread.sleep(100);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            if(remaincount>=0){
                return remaincount;
            }
            else{
                remaincount+=number;
                return -1;
            }
        }
        else return -1;
    }

    public  int getRemaining() {
        return remaincount;
    }

    public String getTicketName() {
        return this.ticketname;
    }
}
