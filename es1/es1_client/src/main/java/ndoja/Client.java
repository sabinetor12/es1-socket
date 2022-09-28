package ndoja;

import java.io.*;
import java.net.*;

public class Client {
    BufferedReader tastiera;
    String ipServer = "127.0.0.1";
    int portaServer = 8080;
    DataOutputStream out;
    BufferedReader in;
    Socket socket;
    String stringaUtente;
    String stringaServer;
    
    protected void connetti(){
        try {
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            socket= new Socket(ipServer,portaServer);

            out= new DataOutputStream(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
        } catch (Exception e) {
            System.out.println("errore");
            System.exit(0);
        }
    }

    public void comunica(){
        try {
            System.out.println("scrivi muoviti");
            stringaUtente = tastiera.readLine();
            System.out.println("mando");
            out.writeBytes(stringaUtente+'\n');
            stringaServer = in.readLine();
            System.out.println("risposta: "+ stringaServer);
            System.out.println("chiudo");
            socket.close();
        } catch (Exception e) {
            System.out.println("errore");
            System.exit(0);
        }
        
    }
}
