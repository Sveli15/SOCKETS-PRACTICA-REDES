package com.mycompany.s04_socket;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class Hilo implements Runnable {
    private Socket cliente;
    
    public Hilo(Socket cliente){
        this.cliente = cliente;
    }
    public void run(){
        try{
            String hilo = Thread.currentThread().getName();
            System.out.println(hilo+"ate el cliente"+cliente.getPort());
            
            Scanner Entrada = new Scanner(cliente.getInputStream());
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
            
            while(Entrada.hasNextLine()){
                String mensaje = Entrada.nextLine();
                System.out.println(hilo+"-cliente"+cliente.getPort()+" -escribio>"+mensaje);
                salida.println("ECO>"+ mensaje);
            }
            System.out.println(hilo+"termino con el cliente del puerto"+cliente.getPort());
            cliente.close();
            
        } catch(Exception e){
            System.out.println("Error con un cliente"+e.getMessage());
        }
    }
    
    
}
