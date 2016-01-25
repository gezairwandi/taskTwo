package com.task.tasktwo.simpleapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnC,btnDel;
    EditText income,outcome;
    TextView result;
    String tempIncome,tempOutcome;
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btn1 = (Button)findViewById(R.id.btn_one);
        btn2 = (Button)findViewById(R.id.btn_two);
        btn3 = (Button)findViewById(R.id.btn_three);
        btn4 = (Button)findViewById(R.id.btn_four);
        btn5 = (Button)findViewById(R.id.btn_five);
        btn6 = (Button)findViewById(R.id.btn_six);
        btn7 = (Button)findViewById(R.id.btn_seven);
        btn8 = (Button)findViewById(R.id.btn_eight);
        btn9 = (Button)findViewById(R.id.btn_nine);
        btn0 = (Button)findViewById(R.id.btn_zero);
        btnC = (Button)findViewById(R.id.btn_clear);
        btnDel = (Button)findViewById(R.id.btn_del);


        income = (EditText)findViewById(R.id.inputIncome);
        outcome = (EditText)findViewById(R.id.inputOutcome);

        result = (TextView)findViewById(R.id.textViewHasil);

        try {
            btn1.setOnClickListener(MainActivity.this);
            btn2.setOnClickListener(MainActivity.this);
            btn3.setOnClickListener(MainActivity.this);
            btn4.setOnClickListener(MainActivity.this);
            btn5.setOnClickListener(MainActivity.this);
            btn6.setOnClickListener(MainActivity.this);
            btn7.setOnClickListener(MainActivity.this);
            btn8.setOnClickListener(MainActivity.this);
            btn9.setOnClickListener(MainActivity.this);
            btn0.setOnClickListener(MainActivity.this);
            btnC.setOnClickListener(MainActivity.this);
            btnDel.setOnClickListener(MainActivity.this);
        }catch (Exception e){

        }
    }

    @Override
    public void onClick(View v) {
        income.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View arg0, MotionEvent arg1)
               {
                   value=1;
                   return false;
               }
        });
        outcome.setOnTouchListener(new View.OnTouchListener(){
           public boolean onTouch(View arg0, MotionEvent arg1)
           {
               value=2;
               return false;
           }
        });

       switch (v.getId()) {
           case R.id.btn_one:
               if(value==1){
                   if(income.getText().toString().equals("")){
                       income.setText(btn1.getText().toString());
                   }else{
                       tempIncome = income.getText().toString();
                       income.setText(tempIncome+btn1.getText().toString());
                   }
               }

               if(value==2){
                   tempOutcome = outcome.getText().toString();
                   if(tempOutcome.isEmpty()){
                       outcome.setText(btn1.getText().toString());
                   }else{
                       if(outcome.getSelectionStart()!= tempOutcome.length()){
                            outcome.setText(outcome.getSelectionEnd());
                       }else{
                           outcome.setText(tempOutcome+btn1.getText().toString());
                       }

                   }
               }
           break;

           case R.id.btn_two:
               if(income.getText().toString()==""){
                   income.setText(btn2.getText().toString());
               }else{
                   tempIncome = income.getText().toString();
                   income.setText(tempIncome+btn2.getText().toString());
               }
               break;

           case R.id.btn_clear:
               income.setText("");
               outcome.setText("");
               result.setText("");
               break;
       }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
