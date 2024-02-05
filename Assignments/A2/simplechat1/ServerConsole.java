import java.io.BufferedReader;
import java.io.InputStreamReader;
import ocsf.server.*;

//****Change for E50: new class built for making the server UI -JY
public class ServerConsole {
    final static int DEFAULT_PORT = 5555;
    private final EchoServer server;
    public ServerConsole(int port)throws Exception{
        server=new EchoServer(port);
        server.listen();
    }
//accept command from server console
    public void accept()
    {
        try
        {
            BufferedReader fromConsole =
                    new BufferedReader(new InputStreamReader(System.in));
            String message;

            while (true)
            {
                message = fromConsole.readLine();
                server.handleMessageFromServer(message);

            }
        }
        catch (Exception ex)
        {
            System.out.println
                    ("Unexpected error while reading from console!");
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 0; //Port to listen on

        try
        {
            port = Integer.parseInt(args[0]); //Get port from command line
        }
        catch(Throwable t)
        {
            port = DEFAULT_PORT; //Set port to 5555
        }

        ServerConsole sv = new ServerConsole(port);

        sv.accept();

    }
}
