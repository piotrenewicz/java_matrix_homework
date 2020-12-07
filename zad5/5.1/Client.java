import java.io.*;
import java.net.*;

public class Client
{
    public static final int PORT=50007;
    public static final String HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException
    {
        //nawiazanie polaczenia z serwerem
        Socket sock;
        sock=new Socket(HOST,PORT);
        System.out.println("Nawiazalem polaczenie: "+sock);

        //tworzenie strumieni danych pobieranych z klawiatury i dostarczanych do socketu
        BufferedReader klaw;
        klaw=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter outp;
        outp=new PrintWriter(sock.getOutputStream());

        String str = "";
        do {
            //komunikacja - czytanie danych z klawiatury i przekazywanie ich do strumienia
            System.out.print("<Wysylamy:> ");
            str = klaw.readLine();
            outp.println(str);
            outp.flush();
        }while (!str.equals("end"));
        //zamykanie polaczenia
        klaw.close();
        outp.close();
        sock.close();
    }
}