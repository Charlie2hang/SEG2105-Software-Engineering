// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;
import java.util.Scanner;
import common.Message;
import ocsf.server.*;

/**
 * This class overrides some of the methods in the abstract 
 * superclass in order to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */
public class EchoServer extends AbstractServer
{
  //Class variables *************************************************
  
  /**
   * The default port to listen on.
   */
  final public static int DEFAULT_PORT = 5555;
  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the echo server.
   *
   * @param port The port number to connect on.
   */
  public EchoServer(int port) 
  {
    super(port);
  }

  
  //Instance methods ************************************************

//****Change for E50: modified for taking and implement different Command from server console -JY
  public void handleMessageFromServer(String message)throws Exception{
    if (message.startsWith("#")){
      message=message.toLowerCase();
      switch(message){
        case"#quit":
          try {
            this.close();

          }catch (IOException e){
            System.exit(1);
          }
          System.out.println("System terminated");
          System.exit(0);
          break;
        case "#close":
          this.close();
          break;
        case "#stop":
          this.stopListening();
          break;
        case "#setport":
          if(this.isListening()){
            display("Please Stop listening then set port");
          }else{
            display("Please enter the port#:");
            Scanner in=new Scanner(System.in);
            int port=Integer.parseInt(in.nextLine());
            this.setPort(port);
          }
          break;
        case "#start":
          if(this.isListening()){
            display("Server is listening");
          }else{
            this.listen();
          }
          break;
        case "#getport":
          display("The Port# is:"+this.getPort());
          break;
        default:
          display("Invalid command: '" + message+ "'");
          break;
        }
    }else{
      Message msg = new Message(message, getPort());
      Thread[] clientList =getClientConnections();
      for (Thread c : clientList) {
        try {
          ConnectionToClient c1 = (ConnectionToClient) c;
          c1.sendToClient(msg);
        } catch (IOException e) {
          System.err.println("Error sending message");
        }
      }
      display("Message:"+msg.getMsg()+" is sent to all client");

    }

  }
  public void display(String message)
  {
    System.out.println("> " + message);
  }
  
  /**
   * This method handles any messages received from the client.
   *
   * @param msg The message received from the client.
   * @param client The connection from which the message originated.
   */
  public void handleMessageFromClient
    (Object msg, ConnectionToClient client)
  {
    System.out.println("Message received: " + msg + " from " + client);
    this.sendToAllClients(msg);
  }
    
  /**
   * This method overrides the one in the superclass.  Called
   * when the server starts listening for connections.
   */
  protected void serverStarted()
  {
    System.out.println
      ("Server listening for connections on port " + getPort());
  }
  
  /**
   * This method overrides the one in the superclass.  Called
   * when the server stops listening for connections.
   */
  protected void serverStopped()
  {
    System.out.println
      ("Server has stopped listening for connections.");
  }

  //****Change for E49: override for handling the displaying for client connected/disconnected -JY
  protected void clientConnected(ConnectionToClient client) {
    System.out.println("A Client is connected");
  }

  synchronized protected void clientException(ConnectionToClient client, Throwable exception) {
    System.out.println("A Client is disconnected");
  }


  //Class methods ***************************************************
  
  /**
   * This method is responsible for the creation of 
   * the server instance (there is no UI in this phase).
   *
   * @param args[0] The port number to listen on.  Defaults to 5555 
   *          if no argument is entered.
   */
  public static void main(String[] args) 
  {
    int port = 0; //Port to listen on

    try
    {
      port = Integer.parseInt(args[0]); //Get port from command line
    }
    catch(Throwable t)
    {
      port = DEFAULT_PORT; //Set port to 5555
    }
	
    EchoServer sv = new EchoServer(port);
    
    try 
    {
      sv.listen(); //Start listening for connections
    } 
    catch (Exception ex) 
    {
      System.out.println("ERROR - Could not listen for clients!");
    }
  }


}
//End of EchoServer class
