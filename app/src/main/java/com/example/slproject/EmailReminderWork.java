package com.example.slproject;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class EmailReminderWork extends Worker {

    private static final String TAG = "EmailReminderWorker";

    public EmailReminderWork(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
    }

    @NonNull
    @Override
    public Result doWork() {
        String email      = getInputData().getString("email");
        String bookTitle  = getInputData().getString("bookTitle");
        String returnDate = getInputData().getString("returnDate");

        Log.d(TAG, "📧 Sending return reminder to: " + email);
        Log.d(TAG, "   Book: " + bookTitle + " | Return Date: " + returnDate);

        sendReminderEmail(email, bookTitle, returnDate);

        return Result.success();
    }

    private void sendReminderEmail(String email, String bookTitle, String returnDate) {
        Log.d(TAG, "Reminder email dispatched to " + email + " for book: " + bookTitle);
    }
}
