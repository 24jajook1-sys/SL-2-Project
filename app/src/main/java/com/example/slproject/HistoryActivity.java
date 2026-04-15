package com.example.slproject;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        RecyclerView recyclerView = findViewById(R.id.recyclerHistory);
        TextView tvHistoryStatus = findViewById(R.id.tvHistoryStatus);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SharedPreferences historyPrefs = getSharedPreferences("LibraryHistory", MODE_PRIVATE);
        Set<String> historySet = historyPrefs.getStringSet("history_list", new HashSet<>());

        if (historySet.isEmpty()) {
            tvHistoryStatus.setText("No history found.");
        } else {
            List<String> historyList = new ArrayList<>(historySet);
            // Sort history to show latest first based on ID (optional)
            Collections.sort(historyList, (a, b) -> {
                try {
                    int idA = Integer.parseInt(a.split("\\|")[0]);
                    int idB = Integer.parseInt(b.split("\\|")[0]);
                    return Integer.compare(idB, idA);
                } catch (Exception e) {
                    return 0;
                }
            });

            HistoryAdapter adapter = new HistoryAdapter(this, historyList);
            recyclerView.setAdapter(adapter);
            tvHistoryStatus.setText("Showing " + historyList.size() + " registrations");
        }
    }
}
