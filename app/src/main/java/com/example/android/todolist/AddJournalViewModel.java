package com.example.android.todolist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.todolist.database.AppDatabase;
import com.example.android.todolist.database.JournalEntry;

// COMPLETED (5) Make this class extend ViewModel
public class AddJournalViewModel extends ViewModel {

    // COMPLETED (6) Add a task member variable for the TaskEntry object wrapped in a LiveData
    private LiveData<JournalEntry> journal;

    // COMPLETED (8) Create a constructor where you call loadTaskById of the taskDao to initialize the tasks variable
    // Note: The constructor should receive the database and the taskId
    public AddJournalViewModel(AppDatabase database, int journalId) {
        journal = database.journalDao().loadJournalById(journalId);
    }

    // COMPLETED (7) Create a getter for the task variable
    public LiveData<JournalEntry> getJournal() {
        return journal;
    }

    public static class AddJournalActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add_journal);
        }
    }
}
