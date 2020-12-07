import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Odbior extends Thread
{
    Socket sock;
    BufferedReader sockReader;

    public Odbior(Socket sock) throws IOException
    {
        this.sock=sock;
        this.sockReader=new BufferedReader(new InputStreamReader(sock.getInputStream()));
    }

    public void run()
    {

    }
}
