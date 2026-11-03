package com.mycompany.s04_socket;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class Cliente {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",5000);
        System.out.println("Conectando desde mi puerto");
        
        Scanner Entrada = new Scanner(socket.getInputStream());
        PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

        salida.println("hola");
        String respuesta = Entrada.nextLine();
        System.out.println(""+respuesta);
        
        socket.close();
    }
    
}
