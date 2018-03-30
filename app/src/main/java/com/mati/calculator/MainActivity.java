package com.mati.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{//

    private static final int[] idArrray = {R.id.b0,R.id.b1,R.id.b2,R.id.b3,R.id.b4,R.id.b5,R.id.b6,R.id.b7,
            R.id.b8,R.id.b9,R.id.bplus,R.id.bminus,R.id.bdivide,R.id.bmultiple,R.id.bequals,R.id.bclear,R.id.bcoma};

    private Button[] buttons= new Button[idArrray.length];
    private TextView calculation,history;

    private static int counter= 0;
    Calculator calculator = new Calculator();

    ButtonsClickControl commaClickControl =new ButtonsClickControl();
    //ButtonsClickControl plusClickControl = new ButtonsClickControl();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        initializeButtons();
        initializeViews();

        for(int i=0;i<idArrray.length;i++){
            buttons[i].setOnClickListener(this);
        }


    }

    private void initializeButtons(){
        for(int i = 0; i < idArrray.length; i++){

            buttons[i]=(Button)findViewById(idArrray[i]);

        }
    }

    private void initializeViews(){
        calculation = (TextView) findViewById(R.id.calculationView);
        history = (TextView) findViewById(R.id.historyView);
        calculation.setText("0");
    }



    @Override
    public void onClick(View view) {

       switch(view.getId()) {
           case R.id.b0: case R.id.b1: case R.id.b2: case R.id.b3: case R.id.b4: case R.id.b5: case R.id.b6: case R.id.b7: case R.id.b8: case R.id.b9:
               Button b = (Button) view;
               String s = b.getText().toString();
               if(counter==0){
                   calculation.setText(s);
                   counter++;
               }
               else {
                   calculation.setText(calculation.getText().toString() + s);
               }
               break;
           case R.id.bclear:
               calculation.setText(null);
               commaClickControl.setClickCounter(true);
               counter = 0;
               calculator.resetWork();
               history.setText(null);
               break;
           case R.id.bcoma:
               if(commaClickControl.getClickCounter()){
                   String s_comma = ".";
                   commaClickControl.setClickCounter(false);
                   calculation.setText(calculation.getText().toString()+s_comma);
                   counter++;
               }
               break;
           case R.id.bplus:case R.id.bequals:case R.id.bminus:case R.id.bmultiple:case R.id.bdivide:
               counter = 0;
               Button btn = (Button) view;
               double w = calculator.cCalculation(Double.parseDouble(calculation.getText().toString()), btn.getText().toString().charAt(0));
               history.setText(history.getText().toString()+btn.getText().toString()+calculation.getText().toString());
               calculation.setText(Double.toString(w));
               commaClickControl.setClickCounter(true);
               break;
       }
    }

    public void comaButtonClick(View view){
    }
}
