import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Odbior extends Thread
{
    Socket sock;
    BufferedReader sockReader;
    Boolean alive;

    public Odbior(Socket sock) throws IOException
    {
        this.sock=sock;
        this.sockReader=new BufferedReader(new InputStreamReader(sock.getInputStream()));
        this.alive = true;
    }

    public void run()
    {
        String str;
        while (this.alive){
            try {
                str = sockReader.readLine();
                System.out.println("<Nadeszlo:> " + str);
                if(str.equals("end")){
                    this.alive=false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void end(){
        this.alive = false;
        this.interrupt();
    }
}
