package com.example.project;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;


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
        //create action bar
        Objects.requireNonNull(getSupportActionBar()).setTitle("Main Page");
        Log.i(ACTIVITY_NAME, "In onCreate()");

//         one = findViewById(R.id.button1);
         monthlyBudgetButton = findViewById(R.id.monthlyBud);
         goalsButt = findViewById(R.id.goalsButton);
         motivationButton = findViewById(R.id.motiButton);
         //buttons to navigate app
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
    //inflates mainmenu xml
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    //options for actionbar
    public boolean onOptionsItemSelected(MenuItem mi){
        int id = mi.getItemId();
        Intent intent;
        //could use switch but studio suggests if else if
        //moves to whatever activity
        if(id == R.id.monthly) {
            Log.d("Toolbar", "monthly budget selected");
            intent = new Intent(MainActivity.this, MonthlyBudget.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.goals) {
            Log.d("Toolbar", "goals selected");
            intent = new Intent(MainActivity.this, GoalActivity.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.motivation) {
            Log.d("Toolbar", "motivation selected");
            intent = new Intent(MainActivity.this, Motivation.class);
            startActivity(intent);
            return true;
        }
        //information button that shows authors and version
        else if(id == R.id.info) {
            Log.d("Toolbar", "information selected");
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(R.string.infoTitle);
            builder.setMessage(Html.fromHtml("<b>Authors: </b>Jagveer Sangha, Terry Tran, Adrian Vuong, Talha Safi, Karan Singh\n<b>Version:</b> 1.0", 0));
            builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //do nothing
                }
            });
            //instructions button, setmessage has space limit so its all in four lines
            builder.setNeutralButton(R.string.instruction, new DialogInterface.OnClickListener() {
                @Override
                //make another alert dialog
                public void onClick(DialogInterface dialogInterface, int i) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                    builder1.setTitle(R.string.instruction);
                    builder1.setMessage(Html.fromHtml("<b>Monthly Budget: </b> Displays your monthly budget and expenses.\n<b>Goals: </b> Shows goals, able to add and remove.\n<b>Motivation: </b> Displays motivational quotes.\n", 0));

                    builder1.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //do nothing
                        }
                    });
                    AlertDialog dialog1 = builder1.create();
                    dialog1.show();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
            return true;
        }
        //nothing selected
        else{
            Log.d("Toolbar", "no item selected");
            return false;
        }
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
