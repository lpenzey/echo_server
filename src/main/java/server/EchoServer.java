package main.java.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class EchoServer extends Thread {

    Socket clientSocket = null;
    BufferedReader inFromClient = null;
    PrintWriter outToClient = null;

    public EchoServer(Socket client) {
        clientSocket = client;
    }

    public void run() {

        try {

            System.out.println( "The Client "+
                    clientSocket.getInetAddress() + ":" + clientSocket.getPort() + " is connected");

            inFromClient = new BufferedReader(new InputStreamReader (clientSocket.getInputStream()));
            outToClient = new PrintWriter(clientSocket.getOutputStream(), true);

            String requestString = inFromClient.readLine();
            String headerLine = requestString;


            StringTokenizer tokenizer = new StringTokenizer(headerLine);
            String httpMethod = null;
            String httpQueryString = null;

            if (requestString.contains("GET")) {
                httpMethod = tokenizer.nextToken();
                httpQueryString = tokenizer.nextToken();
            } else {
                while (true) {
                    outToClient.println("server: " + requestString);
                    requestString = inFromClient.readLine();
                }
            }

            sendResponse(200, httpQueryString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendResponse (int statusCode, String responseString) throws Exception {

        String statusLine = "HTTP/1.1 " + statusCode + " OK" + "\r\n";

        outToClient.println(statusLine);
        outToClient.println(responseString);
        outToClient.close();
    }

    public static void main (String args[]) throws Exception {

        ServerSocket Server = new ServerSocket (5000, 10, InetAddress.getByName("127.0.0.1"));
        System.out.println ("TCPServer Waiting for client on port 5000");

        while(true) {
            Socket connected = Server.accept();
            (new EchoServer(connected)).start();
        }
    }
}