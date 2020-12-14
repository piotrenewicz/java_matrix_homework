import java.io.*;
import java.net.*;


public class duplexSerwer
{
    public static final int PORT=50007;

    public static void main(String args[]) throws IOException
    {
        //tworzenie gniazda serwerowego
        ServerSocket serv;
        serv=new ServerSocket(PORT);

        //oczekiwanie na polaczenie i tworzenie gniazda sieciowego
        System.out.println("Nasluchuje: "+serv);
        Socket sock;
        sock=serv.accept();
        System.out.println("Jest polaczenie: "+sock);

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
        serv.close();
        sock.close();
    }
}