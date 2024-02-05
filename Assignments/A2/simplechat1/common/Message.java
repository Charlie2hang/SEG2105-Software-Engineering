package common;
import java.io.Serializable;
//****change for E50: new class built for make the instance of Message passed to sandToAll() in Echoserver -JY
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    private String msg;
    private int server;

    public Message(String msg, int port) {
        this.msg = msg;
        this.server = port;
    }

    public int getServer() {
        return server;
    }

    public String getMsg() {
        return msg;
    }
}
