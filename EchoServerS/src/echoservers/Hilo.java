/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoservers;

import java.io.*;
import java.net.*;
import java.lang.Thread;
import java.util.ArrayList;

public class Hilo extends Thread {

    long threadID;
    Socket client;

    Hilo(Socket client) {
        this.client = client;
    }

    public void run() {

        try {
            ArrayList<String> listaDeMensajes = new ArrayList<String>();
            int identificadorDestinatario;
           
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
            writer.println("Ingrese el Id del destino");
            
            threadID = currentThread().getId();
            /*writer.println("Ingrese el ID del destinatario\n");
            BufferedReader readerID = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    String lineaID = readerID.readLine();
                    
                    
                    identificadorDestinatario= Integer.parseInt(lineaID);
                
                    System.out.println(identificadorDestinatario);*/
            do{
                String line = reader.readLine();
                if (line.trim().equals("chao")) {
                    writer.println("chao mijin");
                    break;
                } 
                //reader.readLine();
                
                
                //listaDeMensajes.add(identificadorDestinatario, line);
                
                System.out.println(threadID + ": " + line);
                writer.println(threadID + " " + line);
                /*writer.println("Escriba el ID del destinatario");
                String destinatarioID = readerID.readLine();
                if (destinatarioID.trim().equals("10")) {
                System.out.println("DEstinatario ID:" + threadID);
                writer.println("bye!");
                break;
                }*/
               
            }while (true) ;
        } catch (Exception e) {
            System.err.println("Exception caught: client disconnected.");
        } finally {
            try {
                client.close();
            } catch (Exception e) {;
            }
        }
    }
}
