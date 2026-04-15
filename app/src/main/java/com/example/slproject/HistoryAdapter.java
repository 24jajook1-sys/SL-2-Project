package com.example.slproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    Context context;
    List<String> historyList;

    public HistoryAdapter(Context context, List<String> historyList) {
        this.context = context;
        this.historyList = historyList;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_history, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        String entry = historyList.get(position);
        // Format: ID|Title|Name|Email|TakeDate|ReturnDate|Author
        String[] parts = entry.split("\\|");

        if (parts.length >= 7) {
            holder.tvId.setText("Receipt #" + parts[0]);
            holder.tvTitle.setText(parts[1]);
            holder.tvStudent.setText("Student: " + parts[2] + " (" + parts[3] + ")");
            holder.tvDate.setText("Due: " + parts[5]);
            holder.tvAuthor.setText("By " + parts[6]);
        }
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    static class HistoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvTitle, tvAuthor, tvStudent, tvDate;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvHistoryId);
            tvTitle = itemView.findViewById(R.id.tvHistoryTitle);
            tvAuthor = itemView.findViewById(R.id.tvHistoryAuthor);
            tvStudent = itemView.findViewById(R.id.tvHistoryStudent);
            tvDate = itemView.findViewById(R.id.tvHistoryDate);
        }
    }
}
