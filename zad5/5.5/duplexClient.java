import java.io.*;
import java.net.*;



public class duplexClient
{
    public static final int PORT=50007;
    public static final String HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException
    {
        //nawiazanie polaczenia z serwerem
        Socket sock;
        sock=new Socket(HOST,PORT);
        System.out.println("Nawiazalem polaczenie: "+sock);

        BufferedReader klaw;
        klaw=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter outp;
        outp=new PrintWriter(sock.getOutputStream());

        //tworzenie watka odbierajacego
        Odbior rcv = new Odbior(sock);
        rcv.start();
        String str;
        do{
            str = klaw.readLine();
            outp.println(str);
            outp.flush();
        }while(!str.equals("end") && rcv.alive);



        //zamykanie polaczenia
        rcv.end();
        sock.close();
    }
}