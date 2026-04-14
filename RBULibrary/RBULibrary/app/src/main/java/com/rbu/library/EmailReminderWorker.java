package com.rbu.library;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/**
 * EmailReminderWorker
 * -------------------
 * This WorkManager Worker fires 1 day before the book return date.
 * In a production app, replace the Log statement below with a real
 * email API call (e.g. SendGrid, JavaMail via a backend, Firebase Functions, etc.)
 *
 * HOW TO SCHEDULE (call this from BookDetailActivity after submit):
 *
 *   long delayMillis = returnDateMillis - System.currentTimeMillis() - 86_400_000L; // 1 day before
 *   if (delayMillis > 0) {
 *       Data inputData = new Data.Builder()
 *           .putString("email",     studentEmail)
 *           .putString("bookTitle", bookTitle)
 *           .putString("returnDate", returnDate)
 *           .build();
 *
 *       OneTimeWorkRequest reminderWork = new OneTimeWorkRequest.Builder(EmailReminderWorker.class)
 *           .setInitialDelay(delayMillis, TimeUnit.MILLISECONDS)
 *           .setInputData(inputData)
 *           .addTag("reminder_" + bookTitle)
 *           .build();
 *
 *       WorkManager.getInstance(context).enqueue(reminderWork);
 *   }
 */
public class EmailReminderWorker extends Worker {

    private static final String TAG = "EmailReminderWorker";

    public EmailReminderWorker(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
    }

    @NonNull
    @Override
    public Result doWork() {
        String email      = getInputData().getString("email");
        String bookTitle  = getInputData().getString("bookTitle");
        String returnDate = getInputData().getString("returnDate");

        // -----------------------------------------------------------------------
        // TODO: Replace this with a real email-sending API call.
        //
        // Option 1 — Firebase Cloud Functions:
        //   Call your Firebase HTTPS function that uses Nodemailer/SendGrid.
        //
        // Option 2 — Retrofit + your own backend:
        //   POST to /api/sendReminder with { email, bookTitle, returnDate }
        //
        // Option 3 — JavaMail (simple SMTP, runs on device — needs credentials):
        //   Use the JavaMail Android port library.
        // -----------------------------------------------------------------------

        Log.d(TAG, "📧 Sending return reminder to: " + email);
        Log.d(TAG, "   Book: " + bookTitle + " | Return Date: " + returnDate);

        // Simulate success
        sendReminderEmail(email, bookTitle, returnDate);

        return Result.success();
    }

    /**
     * Sends a reminder email.
     * Replace this stub with your actual email sending logic.
     */
    private void sendReminderEmail(String email, String bookTitle, String returnDate) {
        // --- STUB ---
        // In production, make an HTTP POST to your backend or Firebase Function:
        //
        // String body = "Dear Student,\n\n"
        //     + "This is a reminder from RBU Library.\n"
        //     + "Your book \"" + bookTitle + "\" is due for return tomorrow on " + returnDate + ".\n"
        //     + "Please return it on time to avoid a fine.\n\n"
        //     + "Thank you,\nRBU Library Team";
        //
        // OkHttpClient client = new OkHttpClient();
        // RequestBody reqBody = new FormBody.Builder()
        //     .add("to", email)
        //     .add("subject", "RBU Library — Return Reminder")
        //     .add("body", body)
        //     .build();
        // Request request = new Request.Builder()
        //     .url("https://your-backend.com/api/sendReminder")
        //     .post(reqBody)
        //     .build();
        // client.newCall(request).execute();

        Log.d(TAG, "Reminder email dispatched to " + email + " for book: " + bookTitle);
    }
}
