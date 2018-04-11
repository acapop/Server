package server.iot.server;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import de.greenrobot.event.EventBus;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //Toast.makeText(context,"test",Toast.LENGTH_SHORT).show();
        String sender = intent.getStringExtra("sender");
        String type = intent.getStringExtra("type");
        String extra = null;
        if (type != null) {
            switch (type) {
                case Constants.UPDATE:
                    String image = intent.getStringExtra("image");
                    String address = intent.getStringExtra("address");
                    if (image!=null &&address!=null)
                    {
                        extra = "Update: " + address;
                    }
                    break;
                case Constants.FALL_DETECTED:
                    float fall = intent.getFloatExtra("fall", -1);
                    if (fall != -1)
                    {
                        extra = "Fall detected";
                    }
                    break;
                case Constants.HEARTH_RATE:
                    int beats = intent.getIntExtra("beats", -1);
                    if (beats != -1) {
                        extra = "Beats: " + intent.getIntExtra("beats", -1);
                    }
                    break;
                case Constants.PRESSURE:
                    float sys = intent.getFloatExtra("sys", -1.0f);
                    float dias = intent.getFloatExtra("dias", -1.0f);
                    if (sys != -1.0f && dias != -1.0f) {
                        extra = "Pressure: " + String.valueOf(sys) + "/" + String.valueOf(dias);
                    }
                    break;
                case Constants.TEMPERATURE:
                    float temp = intent.getFloatExtra("temp", -1.0f);
                    if (temp != -1.0f) {
                        extra = "Temperature: " + String.valueOf(temp);
                    }
                    break;
                case Constants.MESSAGE:
                    String msg = intent.getStringExtra("message");
                    if (msg != null && !msg.isEmpty()) {
                        extra = "Message: " + msg;
                    }
                    break;
            }

            if (extra != null) {
                EventBus.getDefault().post(new DataReceivedEvent(new LogModel(sender, extra)));
            }
        }
    }
}
