package com.mycompany.s04_socket;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(5000);
        System.out.println("Servidor con hilos escucha puerto "+5000);
        
        while(true){
            Socket cliente = servidor.accept();
            Thread hilo = new Thread(new Hilo(cliente));
            hilo.start();
        }
    }
}
