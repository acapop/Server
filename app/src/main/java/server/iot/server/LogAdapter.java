package server.iot.server;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aleks on 1.4.2018..
 */

public class LogAdapter extends RecyclerView.Adapter<LogAdapter.ViewHolder> {

    List<LogModel> logs;
    Context context;

    public LogAdapter(Context context, List<LogModel> list)
    {
        this.context=context;
        logs=list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.log_list_view, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.sender.setText(logs.get(position).getSender());
        holder.data.setText(logs.get(position).getData());
    }

    @Override
    public int getItemCount() {
        return logs.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView sender;
        TextView data;

        public ViewHolder(View itemView) {
            super(itemView);
            sender=(TextView)itemView.findViewById(R.id.textViewSender);
            data=(TextView)itemView.findViewById(R.id.textViewData);
        }
    }
}

