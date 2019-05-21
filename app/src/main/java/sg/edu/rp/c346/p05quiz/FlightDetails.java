package sg.edu.rp.c346.p05quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FlightDetails extends AppCompatActivity {
TextView fTv;
TextView sTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_details);
        fTv=findViewById(R.id.textView3);
        sTv=findViewById(R.id.textView4);

        Intent intentReceived = getIntent();
        int finale=Integer.parseInt( intentReceived.getStringExtra("Pax"));
        if(intentReceived.getStringExtra("Trip").contains("One")){
            finale=finale*100;
        }else{
            finale=finale*100*2;
        }

        fTv.setText("You have selected "+intentReceived.getStringExtra("Trip"));
        sTv.setText("Your air ticket costs $"+finale);






    }
}
