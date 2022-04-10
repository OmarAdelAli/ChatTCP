package javap;

import java.awt.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;
class ServerChat extends JFrame implements Runnable,ActionListener
{

JLabel l1 , l2 ;
TextArea msgArea;
Thread recieveThread;
TextField msgText;
Button sendButton;
DatagramSocket ds;
int cport=10,sport=11;
ServerChat() throws Exception
{
   msgArea=new TextArea(10,10);
   msgText=new TextField(10);
   l1=new JLabel(" Server Machine ",SwingConstants.CENTER);
   l2=new JLabel(" Type your Message Here : ",SwingConstants.CENTER);
   sendButton=new Button("send");
   setTitle("Omar Chat Program");
   setLayout( new GridLayout(5,1));
   add(l1);
   add(msgArea);
   add(l2);
   add(msgText);
   add(sendButton);

   sendButton.addActionListener(this);
   setBounds(10,10,200,200);
   setVisible(true);
   ds=new DatagramSocket(sport);
    recieveThread=new Thread(this);
    recieveThread.start();
}
public void actionPerformed(ActionEvent e)
{

     try
{
     String message=msgText.getText();
     DatagramPacket dp=new DatagramPacket(message.getBytes(),message.length(),InetAddress.getLocalHost(),cport);

     ds.send(dp);
     msgArea.append("Omar Adel:"+message+"\n");
}
     catch(Exception e1){}

}
public void run()
{

      byte b[]=new byte[1000];
      while(true)
{
       try
{
       DatagramPacket dp=new DatagramPacket(b,b.length);
       ds.receive(dp);
       String data=new String(dp.getData(),0,dp.getLength());
       msgArea.append("Dr Omer :"+data+"\n");
}
       catch(Exception e){}
}

}
public static void main(String x[]) throws Exception
{
     new ServerChat();
}


}
