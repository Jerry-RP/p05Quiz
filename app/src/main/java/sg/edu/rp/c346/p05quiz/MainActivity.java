package sg.edu.rp.c346.p05quiz;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btnAdd;
Button btnMinus;
Button btnSubmit;
TextView tvNum;
CheckBox cbOW;
CheckBox cbRT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvNum=findViewById(R.id.num);
        btnAdd=findViewById(R.id.btnP);
        btnMinus=findViewById(R.id.btnM);
        btnSubmit=findViewById(R.id.buttonSub);
        cbOW=findViewById(R.id.checkBox);
        cbRT=findViewById(R.id.checkBox2);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int valued=Integer.parseInt(tvNum.getText().toString());
                valued++;
                String sop=String.valueOf(valued);
                tvNum.setText(sop);
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int value=Integer.parseInt(tvNum.getText().toString());
                value--;
                String sos=String.valueOf(value);
                tvNum.setText(sos);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean cb=false;
                boolean vnum=false;
                if((cbOW.isChecked())&&(cbRT.isChecked())){
                    cb=true;
                }else if(cbOW.isChecked()){
                    if(Integer.parseInt(tvNum.getText().toString())>0){

                        Intent intent2 = new Intent(getBaseContext(), FlightDetails.class);
                        intent2.putExtra("Trip", "One Way Trip");
                        intent2.putExtra("Pax", tvNum.getText());



                        startActivity(intent2);

                    }else{
                       vnum=true;
                    }

                }else if(cbRT.isChecked()){
                    if(Integer.parseInt(tvNum.getText().toString())>0){

                        Intent intent3 = new Intent(getBaseContext(), FlightDetails.class);
                        intent3.putExtra("Trip", "Round Trip");
                        intent3.putExtra("Pax", tvNum.getText());



                        startActivity(intent3);

                    }else{
                 vnum=true;
                    }
                }
                if((cb==true)&&(vnum==true)){

                    Toast.makeText(MainActivity.this, "Invalid Input Both Checkboxes Selected", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override public void run() {
                            int delay=0;
                        }
                    }, 3000);

                    Toast.makeText(MainActivity.this, "Invalid input pax < 1", Toast.LENGTH_SHORT).show();
                }else if(cb==true){
                    Toast.makeText(MainActivity.this, "Invalid Input Both Checkboxes Selected", Toast.LENGTH_SHORT).show();


                }else if(vnum==true){
                    Toast.makeText(MainActivity.this, "Invalid input pax < 1", Toast.LENGTH_SHORT).show();
                }


            }
        });



    }
}
