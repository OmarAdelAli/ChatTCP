package javaps;

import java.io.*;
import java.net.*;

public class TCPServer {

    public static void main(String[] args) throws Exception {

        TCPServer myS = new TCPServer();
        myS.run();

    }

    public void run() throws Exception {

        ServerSocket mySS = new ServerSocket(9876);
        Socket SS_accept = mySS.accept();

        InputStreamReader mySR = new InputStreamReader(SS_accept.getInputStream());
        BufferedReader myBR = new BufferedReader(mySR);

        String temp = myBR.readLine();
        System.out.println(temp);


    }

}
