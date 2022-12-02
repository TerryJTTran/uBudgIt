package com.example.project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class GoalActivity extends AppCompatActivity {

    ArrayList <String> goalsListStrg = new ArrayList<>();
    private static final String ACTIVITY_NAME = "GoalsWindow";

    GoalsDatabaseHelper goalsDB;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);


        EditText inputBox = findViewById(R.id.inputBox);
        Button goalEnter = findViewById(R.id.goalsenter);
        ListView goalsList = findViewById(R.id.goalsList);
        goalsDB = new GoalsDatabaseHelper(this);
        database = goalsDB.getWritableDatabase();


        GoalAdapter goalAdapter = new GoalAdapter(this);
        goalsList.setAdapter(goalAdapter);

        Cursor c = database.rawQuery("select * from "+ GoalsDatabaseHelper.TABLE_OF_GOALS_ITEMS + ";", null);
        c.moveToFirst();

        while(!c.isAfterLast()){
            String str = c.getString((c.getColumnIndexOrThrow(GoalsDatabaseHelper.KEY_MESSAGE)));
            goalsListStrg.add(str);
            Log.i(ACTIVITY_NAME, "SQL MESSAGE: " + c.getString(c.getColumnIndexOrThrow(GoalsDatabaseHelper.KEY_MESSAGE)));
            Log.i(ACTIVITY_NAME, "Cursor Column Count =" + c.getColumnCount());
            c.moveToNext();
        }

        for(int i = 0; i < c.getColumnCount(); i++){
            c.getColumnName(i);
            System.out.println(c.getColumnName(i));
        }

        goalEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String goalVal = inputBox.getText().toString();
                goalsListStrg.add(goalVal);

                ContentValues val = new ContentValues();
                val.put(GoalsDatabaseHelper.KEY_MESSAGE, inputBox.getText().toString());
                long insertId = database.insert(GoalsDatabaseHelper.TABLE_OF_GOALS_ITEMS, null, val);
                Cursor c2 = database.query(GoalsDatabaseHelper.TABLE_OF_GOALS_ITEMS, null, GoalsDatabaseHelper.KEY_ID + "=" + insertId, null, null, null, null);
                c2.moveToFirst();
                c2.close();

                goalAdapter.notifyDataSetChanged();
                inputBox.setText("");

            }


        });

    }

    @Override
    protected void onDestroy() {
        goalsDB.close();
        super.onDestroy();
    }

    private class GoalAdapter extends ArrayAdapter<String>{
        public GoalAdapter(Context ctx){
            super(ctx, 0);
        }
        public int getCount(){
            return goalsListStrg.size();
        }

        @Nullable
        @Override
        public String getItem(int position) {
            return (goalsListStrg.get(position));
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = GoalActivity.this.getLayoutInflater();

            View result = null;
            result = inflater.inflate(R.layout.activity_goals_list_items, null);

            TextView goalStr = (TextView) result.findViewById(R.id.goalText);
            goalStr.setText(getItem(position));
            return result;
        }
    }
}