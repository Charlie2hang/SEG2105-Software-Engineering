// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

package client;


import common.Message;
import common.ChatIF;
import ocsf.client.AbstractClient;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class overrides some of the methods defined in the abstract
 * superclass in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */
public class ChatClient extends AbstractClient
{
  //Instance variables **********************************************
  
  /**
   * The interface type variable.  It allows the implementation of 
   * the display method in the client.
   */
  ChatIF clientUI; 

  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the chat client.
   *
   * @param host The server to connect to.
   * @param port The port number to connect on.
   * @param clientUI The interface type variable.
   */
  
  public ChatClient(String host, int port, ChatIF clientUI) 
    throws IOException 
  {
    super(host, port); //Call the superclass constructor
    this.clientUI = clientUI;
    openConnection();
  }

  
  //Instance methods ************************************************
    
  /**
   * This method handles all data that comes in from the server.
   *
   * @param msg The message from the server.
   */
  public void handleMessageFromServer(Object msg) 
  {
    //****change for E50: update for handling the message from server -JY
    if(msg instanceof Message){
      clientUI.display( ((Message) msg).getMsg()+" from:"+((Message) msg).getServer());
    }else{
      clientUI.display(msg.toString());
    }

  }

  /**
   * This method handles all data coming from the UI            
   *
   * @param message The message from the UI.    
   */
  //****Change for E50: If statement and switch added for apply E50 requirement -JY
  public void handleMessageFromClientUI(String message) throws IOException {
    if(message.startsWith("#")){
      message=message.toLowerCase();
      switch (message){
        case "#quit":
          clientUI.display("You quited the system. Goodbye");
          quit();
          break;
        case "#logoff":
          clientUI.display("You logged off the system. Goodbye");
          closeConnection();
          break;
        case "#sethost":
          if (isConnected()){
            clientUI.display("You still connected to the server, please logoff for setting the host");
          }else{
            clientUI.display("Please enter the host:");
            Scanner in=new Scanner(System.in);
            String host=in.nextLine();
            setHost(host);
            clientUI.display("Your host now is:"+host);
          }
          break;
        case "#setport":
          if (isConnected()){
            clientUI.display("You still connected to the server, please logoff for setting the port");
          }else{
            clientUI.display("Please enter the port#:");
            Scanner in=new Scanner(System.in);
            int port=Integer.parseInt(in.nextLine());
            setPort(port);
            clientUI.display("Your port# now is:"+port);
          }
          break;
        case "#login":
          if (isConnected()) {
            clientUI.display("You still connected to the server, please logoff for login");
          }else{
            openConnection();
            clientUI.display("You logged in as "+this.getHost()+". port#:"+this.getPort());
          }
          break;
        case "#gethost":
          clientUI.display("Your host is:"+getHost());
          break;
        case "#getport":
          clientUI.display("Your port# is:"+getPort());
          break;
        default:
          clientUI.display("Invalid command: '" + message+ "'");
          break;
      }
    }
    else{
      try
      {
        sendToServer(message);
      }
      catch(IOException e)
      {
        clientUI.display
                ("Could not send message to server.  Terminating client.");
        quit();
      }
    }

  }
  
  /**
   * This method terminates the client.
   */
  public void quit()
  {
    try
    {
      closeConnection();
    }
    catch(IOException e) {}
    System.exit(0);
  }

  //****Change for E49: override from AbstractClient for handle the server shutdown cases -JY



  protected void connectionException(Exception exception) {
    clientUI.display("Server has shutdown, system terminated, Goodbye");
    quit();
  }


}
//End of ChatClient class
