package it.polimi.ingsw.network.server;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import it.polimi.ingsw.controller.GameController;

/**
 * This class extends the Server class by Socket network technology.
 */
public class SocketServer extends Server {

    public SocketServer () {
        super(new GameController());

    }

    public void ServerSocket(int portNumber) throws IOException {
        try (ServerSocket sc = new ServerSocket(portNumber)){
        System.out.println("Server socket ready on port: " + portNumber);

            while (true) {
                //Accepting connection from a Client on portNumber
                Socket s = sc.accept();
                System.out.println("Received client connection");
                //Read data from the client via an InputStream obtained from the client socket
                Scanner in = new Scanner(s.getInputStream());
                //Send data to the client via the client socket’s OutputStream
                PrintWriter out = new PrintWriter(s.getOutputStream());
                String line = in.nextLine();
                if (line.equals("quit")) break;
                else {
                    out.println("Received: " + line);
                    out.flush();
                }
                //closing connection
                in.close();
                out.close();
                s.close();
                sc.close();
            }
        } catch (IOException ex) {
        System.out.println("Server exception: " + ex.getMessage());
        ex.printStackTrace();
        }
        System.out.println("Closing sockets");

    }


}
