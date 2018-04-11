package server.iot.server;

/**
 * Created by aleks on 1.4.2018..
 */

public class LogModel {
    private String sender;
    private String data;

    public LogModel(String sender, String data)
    {
        this.sender=sender;
        this.data=data;
    }

    public String getSender()
    {
        return sender;
    }

    public String getData()
    {
        return data;
    }
}
