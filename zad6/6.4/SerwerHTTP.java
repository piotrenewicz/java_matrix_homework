import java.io.*;
import java.net.*;

public class SerwerHTTP
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket serv=new ServerSocket(8080);

        while(true)
        {
            //przyjecie polaczenia
            System.out.println("Oczekiwanie na polaczenie...");
            Socket sock=serv.accept();

            //strumienie danych
            InputStream is=sock.getInputStream();
            OutputStream os=sock.getOutputStream();
            BufferedReader inp=new BufferedReader(new InputStreamReader(is));
            DataOutputStream outp=new DataOutputStream(os);

            //przyjecie zadania (request)
            String request=inp.readLine();

            String[] splittable = request.split("\\s+");
            if (splittable.length>2) {
                System.out.println("Get strona: "+splittable[splittable.length - 2].substring(1));
            }

            
            //wyslanie odpowiedzi (response)
            if(request.startsWith("GET"))
            {
                //response header
                outp.writeBytes("HTTP/1.0 200 OK\r\n");
                outp.writeBytes("Content-Type: text/html\r\n");
                outp.writeBytes("Content-Length: \r\n");
                outp.writeBytes("\r\n");

                //response body
                try{
                    FileInputStream fis = new FileInputStream(splittable[splittable.length - 2].substring(1));

                    byte[] bufor;
                    bufor=new byte[1024];
                    int n=0;

                    while ((n = fis.read(bufor)) != -1 ){
                        outp.write(bufor, 0, n);
                    }
                }
                catch(FileNotFoundException e){
                    outp.writeBytes("HTTP/1.0 404 Not Found\r\n");
                }
            }
            else
            {
                outp.writeBytes("HTTP/1.1 501 Not supported.\r\n");
            }

            System.out.println(request);
            while(inp.ready()){
                request = inp.readLine();
                System.out.println(request);
            }

            //zamykanie strumieni
            inp.close();
            outp.close();
            sock.close();
        }
    }
}