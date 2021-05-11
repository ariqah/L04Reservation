package sg.edu.rp.c346.id20023243.l04reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView tvName, tvTelephone, tvSize;
    EditText etName, etTelephone, etSize;
    CheckBox cbEnvironment;
    DatePicker dp;
    TimePicker tp;
    Button btnReserve, btnReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvName = findViewById(R.id.textViewName);
        tvTelephone = findViewById(R.id.textViewTelephone);
        tvSize = findViewById(R.id.textViewSize);
        etName = findViewById(R.id.editTextPersonName);
        etTelephone = findViewById(R.id.editTextPhone);
        etSize = findViewById(R.id.editTextNumberSize);
        cbEnvironment = findViewById(R.id.checkBoxSmokingArea);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnReserve = findViewById(R.id.buttonReserve);
        btnReset = findViewById(R.id.buttonReset);

        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                if(hourOfDay < 8 || hourOfDay > 20) {
                }
                else{
                    tp.setCurrentHour(hourOfDay);
                }
            }
        });

        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etName.getText().toString().length()!=0 && etTelephone.getText().toString().length()!=0 &&
                        etSize.getText().toString().length()!=0 ) {
                    String area = "smoking area";
                    if(cbEnvironment.isChecked()==false) {
                        area = "non-smoking area";
                    }
                    String output = "You have successfully booked a reservation for "+etSize.getText().toString()+" at "+
                            tp.getCurrentHour()+":"+String.format("%02d",tp.getCurrentMinute())+" on "+dp.getDayOfMonth()+
                            "/"+dp.getMonth()+"/"+dp.getYear()+" in a "+area+".";
                    Toast.makeText(MainActivity.this, output, Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Please fill in all the fields",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName.setText("");
                etTelephone.setText("");
                etSize.setText("");

                dp.updateDate(2021,5,1);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
            }
        });
    }
}