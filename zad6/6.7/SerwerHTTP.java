import java.io.*;
import java.net.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;


class ObslugaZadania extends Thread
{
    Socket client;
    InputStream in;
    OutputStream out;
    BufferedReader Receiver;
    DataOutputStream Sender;

    ObslugaZadania(Socket clientSocket) throws IOException
    {
        this.client=clientSocket;
        //Strumien
        this.in = this.client.getInputStream();
        this.out = this.client.getOutputStream();
        this.Receiver = new BufferedReader(new InputStreamReader(in));
        this.Sender = new DataOutputStream(out);
    }

    public void run()
    {
        try {
            String request = this.Receiver.readLine();

            synchronized (SerwerHTTP.LogWriter) {
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(Calendar.getInstance().getTime());
                SerwerHTTP.LogWriter.printf("[%s] %s %s\n", timeStamp, request, this.client.getRemoteSocketAddress().toString());
                SerwerHTTP.LogWriter.flush();
            }
            String[] splitted = request.split("\\s+");
//            System.out.println(splitted[1]);
            String fn  = splitted[1];
//            String fn = splitted[1].replace("/", "");

            if (fn.equals("/")) {
                this.get_file("5image.html");
            } else {
                this.get_file(fn);
            }

        }
        catch (IOException e){
            System.out.println(e);
        }
    }
    static String getExtension(String fn){
        int dotIdx = fn.lastIndexOf('.');
        String extension = "";
        if (dotIdx > 0){
            extension = fn.substring(dotIdx + 1);
        }
        return extension;
    }
    void httpHeader(String type, String length) throws IOException{
        this.Sender.writeBytes("HTTP/1.0 200 OK\r\n");
        this.Sender.writeBytes("Content-Type: " + type + "\r\n");
        this.Sender.writeBytes("Content-Length: " + length + "\r\n");
        this.Sender.writeBytes("\r\n");
    }
    void  get_file(String fn) throws IOException{
        FileInputStream file;
        try{
            file = new FileInputStream(fn);
            System.out.println("sending file: "+ fn);
            int contentLength = file.available();
            String extension = getExtension(fn);
            String contentType = "";
            if (extension.equals("html") || extension.equals("htm")){
                contentType = "text/html";
            }
            httpHeader(contentType, Integer.toString(contentLength));

            byte[] buffer = new byte[1024];
            int n = 0;
            while ((n = file.read(buffer)) != -1){
                this.Sender.write(buffer, 0, n);
            }
            file.close();
        }
        catch (FileNotFoundException e){
            this.Sender.writeBytes("HTTP/1.1 404 Not Found\r\n");
        }
    }

}

public class SerwerHTTP
{
    public static String log = "log.txt";
    public static PrintWriter LogWriter;

    static{
        try{
            LogWriter = new PrintWriter(new BufferedWriter(new FileWriter(log, true)));
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
    public  static void main(String[] args) throws IOException{
        int port;
        boolean accepted = false;
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        ServerSocket server = null;
        Socket clientSocket;

        if (args.length == 0){
            System.out.println("Specify port number");
            System.out.print("PORT: ");
        }
        else{
            try{
                port = Integer.parseInt(args[0]);
                server = new ServerSocket(port);
                System.out.println("Server started " + server);
                accepted = true;
            }
            catch (BindException e){
                System.out.println("Port is already in use");
                System.out.print("PORT: ");
            }
        }

        while (!accepted){
            if (keyboard.ready()){
                try{
                    port = Integer.parseInt(keyboard.readLine());
                    server = new ServerSocket(port);
                    System.out.println("Server started: " + server);
                    accepted = true;
                }
                catch (BindException e){
                    System.out.println("Port is already in use");
                    System.out.print("PORT: ");
                }
            }
        }

        while(true){
//            System.out.println("Waiting for connection...");
            clientSocket=server.accept();
            new ObslugaZadania(clientSocket).start();
        }
    }
}