# 📚 RBU Library Management System — Android App

A complete Android Studio project for **Rashtrasant Tukadoji Maharaj Nagpur University (RBU)**
library management, built in Java.

---

## 📁 Project Structure

```
RBULibrary/
├── app/
│   ├── src/main/
│   │   ├── java/com/rbu/library/
│   │   │   ├── MainActivity.java          ← Page 1: Home / Landing
│   │   │   ├── RegistrationActivity.java  ← Page 2: Student Registration
│   │   │   ├── BookCategoryActivity.java  ← Page 3: Book Categories
│   │   │   ├── BookListActivity.java      ← Page 4: Books in a category
│   │   │   ├── BookDetailActivity.java    ← Page 5: Book info + borrow form
│   │   │   ├── ReceiptActivity.java       ← Page 6: Auto-generated receipt
│   │   │   ├── Book.java                  ← Book data model
│   │   │   ├── BookDataSource.java        ← 60 books (10 per category)
│   │   │   ├── BookAdapter.java           ← RecyclerView adapter
│   │   │   └── EmailReminderWorker.java   ← WorkManager email reminder
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   ├── activity_main.xml
│   │   │   │   ├── activity_registration.xml
│   │   │   │   ├── activity_book_category.xml
│   │   │   │   ├── activity_book_list.xml
│   │   │   │   ├── activity_book_detail.xml
│   │   │   │   ├── activity_receipt.xml
│   │   │   │   └── item_book.xml
│   │   │   ├── drawable/
│   │   │   │   └── ic_book.xml
│   │   │   └── values/
│   │   │       ├── strings.xml
│   │   │       └── themes.xml
│   │   └── AndroidManifest.xml
│   └── build.gradle
├── build.gradle
└── settings.gradle
```

---

## 🚀 How to Set Up in Android Studio

### Step 1 — Create a New Project
1. Open Android Studio → **New Project**
2. Choose **Empty Activity**
3. Set:
   - **Name:** RBU Library
   - **Package name:** `com.rbu.library`
   - **Language:** Java
   - **Min SDK:** API 24
4. Click **Finish**

### Step 2 — Replace Files
Copy all files from this project into your Android Studio project at the matching paths.

### Step 3 — Update `build.gradle` (app level)
Make sure these dependencies are in your app-level `build.gradle`:

```groovy
dependencies {
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.11.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    implementation 'androidx.recyclerview:recyclerview:1.3.2'
    implementation 'androidx.cardview:cardview:1.0.0'
    implementation 'androidx.work:work-runtime:2.9.0'
}
```

### Step 4 — Sync & Run
Click **Sync Now** → then **Run ▶**

---

## 📱 App Flow (Screen by Screen)

| Screen | Activity | Description |
|--------|----------|-------------|
| Page 1 | `MainActivity` | RBU Library home with stats and Register button |
| Page 2 | `RegistrationActivity` | Name, College Email (@rbunagpur.in validated), Branch, Section, Year, Phone |
| Page 3 | `BookCategoryActivity` | 6 category buttons |
| Page 4 | `BookListActivity` | RecyclerView list of 10 books per category |
| Page 5 | `BookDetailActivity` | Book info + borrow form (name, take date, return date) |
| Page 6 | `ReceiptActivity` | Auto-numbered receipt with all details |

---

## 📚 Book Categories (10 books each = 60 total)

| # | Category | Example Books |
|---|----------|---------------|
| 1 | Novel | The Alchemist, 1984, Harry Potter, Kite Runner... |
| 2 | Autobiography | Gandhi, Kalam (Wings of Fire), Dhoni, Sachin... |
| 3 | Engineering College | DS&A, DBMS, OS Concepts, Computer Networks... |
| 4 | NEET Books | NCERT Bio/Chem/Phy, HC Verma, MTG Fingertips... |
| 5 | JEE Books | Irodov, HC Verma, SL Loney, OP Tandon... |
| 6 | Motivational | Atomic Habits, Rich Dad, Ikigai, Deep Work... |

---

## ✉️ Email Reminder System

The app uses **Android WorkManager** to schedule a reminder.

- When a student submits the borrow form, `BookDetailActivity` calculates:
  `reminderTime = returnDate − 1 day`
- A `OneTimeWorkRequest` is enqueued with that delay
- `EmailReminderWorker.doWork()` fires at the right time

### To actually send the email, choose one:

**Option A — Firebase Cloud Functions (Recommended)**
```javascript
// In your Firebase Function (Node.js):
const nodemailer = require('nodemailer');
exports.sendReminder = functions.https.onRequest(async (req, res) => {
  const { to, bookTitle, returnDate } = req.body;
  await transporter.sendMail({
    from: 'library@rbunagpur.in',
    to,
    subject: 'RBU Library — Return Reminder',
    text: `Please return "${bookTitle}" by ${returnDate}.`
  });
  res.send('OK');
});
```

**Option B — Your own REST backend**
Make a POST request in `EmailReminderWorker.sendReminderEmail()` to your server endpoint.

**Option C — JavaMail (on-device SMTP)**
Add the `jakarta.mail` Android dependency and configure SMTP credentials.

---

## 🔑 Key Features

- ✅ **@rbunagpur.in email validation** — invalid emails are rejected instantly
- ✅ **6 categories × 10 books = 60 books** with author + description
- ✅ **Auto-incrementing receipt numbers** stored via `SharedPreferences`
- ✅ **Date picker dialogs** — take date & return date with min-date enforcement
- ✅ **WorkManager reminder** — scheduled 1 day before return, survives app restarts
- ✅ **Material Design UI** — dark blue (#1A237E) theme throughout

---

## 🛠 Tech Stack

- **Language:** Java
- **Min SDK:** API 24 (Android 7.0)
- **UI:** XML Layouts + RecyclerView + CardView + Material Components
- **Scheduling:** AndroidX WorkManager
- **Storage:** SharedPreferences (receipt counter)
- **IDE:** Android Studio Hedgehog / Iguana or newer
