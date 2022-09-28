package ndoja;

import java.io.*;
import java.net.*;

public class Server {
    ServerSocket server = null;
    Socket client = null;
    String strRicevuta;
    String strModificata;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;

    public Socket connetti() {
        try {
            System.out.println("server partito");
            server = new ServerSocket(8080);
            client = server.accept();
            System.out.println("socket connesso");
            server.close();
            inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outVersoClient = new DataOutputStream(client.getOutputStream());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("errore durante l'istanza del server");
            System.exit(1);
        }
        return client;
    }

    public void comunica() {
        try {
            strRicevuta = inDalClient.readLine();
            System.out.println("stringa ricevuta: " + strRicevuta);
            strModificata = strRicevuta.toUpperCase();
            outVersoClient.writeBytes(strModificata + '\n');
            System.out.println("stringa inviata");
            client.close();
        } catch (Exception e) {
            System.out.println("fai hahare");
        }
    }
}
