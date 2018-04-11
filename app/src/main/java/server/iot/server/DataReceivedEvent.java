package server.iot.server;

/**
 * Created by aleks on 31.3.2018..
 */

public class DataReceivedEvent {
    private LogModel logModel;

    public DataReceivedEvent(LogModel model)
    {
        this.logModel = model;
    }

    public LogModel getMessage()
    {
        return logModel;
    }
}
