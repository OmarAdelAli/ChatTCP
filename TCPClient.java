package javaps;
import java.io.*;
import java.net.*;

public class TCPClient {

    public static void main(String[] args) throws Exception {

        TCPClient myC = new TCPClient();
        myC.run();

    }

    public void run() throws Exception {

        Socket mySkt = new Socket("localhost", 9876);
        PrintStream myPS = new PrintStream(mySkt.getOutputStream());

        myPS.println("I received your message");

    }

}
