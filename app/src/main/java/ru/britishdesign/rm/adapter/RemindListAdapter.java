package ru.britishdesign.rm.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import ru.britishdesign.rm.R;
import ru.britishdesign.rm.dto.RemindDTO;

public class RemindListAdapter extends RecyclerView.Adapter<RemindListAdapter.RemindViewHolder> {
    private static final int LAYOUT = R.layout.fragment_reminders;

    private List<RemindDTO> data;
    private RemindListAdapter adapter;

    public RemindListAdapter(List<RemindDTO> data) {
        this.data = data;
    }

    @Override
    public RemindViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.remind_item, parent, false);

        return new RemindViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RemindViewHolder holder, int position) {
        RemindDTO item = data.get(position);

        holder.title.setText(item.getTitle());
        holder.remindTitleItem.setText(item.getRemindDetail());

        Date dateRemind = new java.util.Date(Long.parseLong(item.getRemindDate(), 10));
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");//formating according to my need
        String dateRemindSring = formatter.format(dateRemind);
        holder.remindDateItem.setText(dateRemindSring);
    }

    @Override
    public int getItemCount() {
        if(data==null) return 0;
        return data.size();
    }

    public void setData(List<RemindDTO> data) {
        this.data = data;
    }

    public static class RemindViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView title;
        TextView remindDateItem;
        TextView remindTitleItem;

        public RemindViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardView);
            title = (TextView) itemView.findViewById(R.id.title);
            remindDateItem = (TextView) itemView.findViewById(R.id.dateItem);
            remindTitleItem = (TextView) itemView.findViewById(R.id.textItem);
        }
    }

}