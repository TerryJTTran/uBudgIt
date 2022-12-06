package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    //Variable for readability purposes
    protected static final String ACTIVITY_NAME = "MainActivity";

//    private Button one ;
    private Button monthlyBudgetButton ;
    private Button goalsButt ;
    private Button motivationButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(ACTIVITY_NAME, "In onCreate()");

//         one = findViewById(R.id.button1);
         monthlyBudgetButton = findViewById(R.id.monthlyBud);
         goalsButt = findViewById(R.id.goalsButton);
         motivationButton = findViewById(R.id.motiButton);

         motivationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(ACTIVITY_NAME, "Motivation Time");
                Intent intent = new Intent(MainActivity.this, Motivation.class);
                startActivityForResult(intent,10);

//                startActivity(intent);
            }
        });
        
//Uncomment once Other pages are made
        goalsButt.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.i(ACTIVITY_NAME, "Goals Time");

            //In _ InsertActivityWeAreGoingTo
            Intent intent = new Intent(MainActivity.this, GoalActivity.class);

            startActivityForResult(intent,10);
//                startActivity(intent);
        }
    });

        monthlyBudgetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(ACTIVITY_NAME, "In Monthly Budget");

                //In _ InsertActivityWeAreGoingTo
                Intent intent = new Intent(MainActivity.this, MonthlyBudget.class);

                startActivityForResult(intent,10);
//                startActivity(intent);
            }
        });

//        three.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //In _ InsertActivityWeAreGoingTo
//                Intent intent = new Intent(MainActivity.this, _.class);
//
//                startActivityForResult(intent,10);
////                startActivity(intent);
//            }
//        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem mi){
        int id = mi.getItemId();
        View view = findViewById(android.R.id.content);
        Intent intent = new Intent();
        switch(id){
            case R.id.monthly:
                Log.d("Toolbar", "monthly budget selected");
                intent = new Intent(MainActivity.this, MonthlyBudget.class);

            case R.id.goals:
                Log.d("Toolbar", "goals selected");
                intent = new Intent(MainActivity.this, GoalActivity.class);

            case R.id.motivation:
                Log.d("Toolbar", "motivation selected");
                intent = new Intent(MainActivity.this, Motivation.class);

            default:
                Log.d("Toolbar", "no item selected");
        }
        startActivity(intent);
        return true;
    }



    @Override
    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }
}
