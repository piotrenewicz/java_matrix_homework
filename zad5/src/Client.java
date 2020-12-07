import java.io.*;
import java.net.*;

public class Client {
    public static final int PORT = 50007;
    public static final String HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        try {
            //nawiazanie polaczenia z serwerem
            Socket sock;
            sock = new Socket(HOST, PORT);
            System.out.println("Nawiazalem polaczenie: " + sock);

            //tworzenie strumieni danych pobieranych z klawiatury i dostarczanych do socketu
            BufferedReader klaw;
            klaw = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter outp;
            outp = new PrintWriter(sock.getOutputStream());
            BufferedReader inp;
            inp = new BufferedReader(new InputStreamReader(sock.getInputStream()));

            String str = "";
            do {
                //komunikacja - czytanie danych z klawiatury i przekazywanie ich do strumienia
                System.out.print("<Wysylamy:> ");
                str = klaw.readLine();
                outp.println(str);
                outp.flush();
                str = inp.readLine();
                System.out.println("<Nadeszlo:> " + str);
            } while (!str.equals("end"));
            //zamykanie polaczenia
            klaw.close();
            outp.close();
            sock.close();
        } catch (ConnectException e) {
            System.out.println("Blad polaczenia z serwerem"); //5.3
        } catch (SocketException e) {
            System.out.println("Polaczenie zerwane przez serwer"); //5.4
        } finally {
            System.out.println("Klient sie wysypal");
        }
    }
}