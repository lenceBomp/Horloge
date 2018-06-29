package com.lbompard.horloge;

import android.app.TimePickerDialog;
import android.support.constraint.Group;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    AppCompatCheckBox lundi;
    AppCompatCheckBox mardi;
    AppCompatCheckBox mercredi;
    AppCompatCheckBox jeudi;
    AppCompatCheckBox vendredi;
    AppCompatCheckBox samedi;
    AppCompatCheckBox dimanche;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(this);
        View rootView = inflater.inflate(R.layout.activity_main, null);

        final TextView heureTextView = rootView.findViewById(R.id.heure);
        heureTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog horlogeDialog;
                horlogeDialog = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                                heureTextView.setText(selectedHour + ":" + selectedMinute) ;
                            }
                        },12,0,true);
                horlogeDialog.show();
            }

        });


        final Group groupeDesJours = rootView.findViewById(R.id.groupeJour);
        final TextView selectedDay = rootView.findViewById(R.id.jour);
        View.OnClickListener selectedDayListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if (groupeDesJours.getVisibility() == View.VISIBLE){
                  groupeDesJours.setVisibility(View.GONE);
              } else {
                  groupeDesJours.setVisibility(View.VISIBLE);
              }

            }
        };
        selectedDay.setOnClickListener(selectedDayListener);


        lundi = rootView.findViewById(R.id.lundi);
        mardi = rootView.findViewById(R.id.mardi);
        mercredi = rootView.findViewById(R.id.mercredi);
        jeudi = rootView.findViewById(R.id.jeudi);
        vendredi = rootView.findViewById(R.id.vendredi);
        samedi = rootView.findViewById(R.id.samedi);
        dimanche = rootView.findViewById(R.id.dimanche);

        selectedDay.setText(buildSelectedDaysString());

        CompoundButton.OnCheckedChangeListener onCheckedChangeListener =  new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                selectedDay.setText(buildSelectedDaysString());
            }
        };
        lundi.setOnCheckedChangeListener(onCheckedChangeListener);
        mardi.setOnCheckedChangeListener(onCheckedChangeListener);
        mercredi.setOnCheckedChangeListener(onCheckedChangeListener);
        jeudi.setOnCheckedChangeListener(onCheckedChangeListener);
        vendredi.setOnCheckedChangeListener(onCheckedChangeListener);
        samedi.setOnCheckedChangeListener(onCheckedChangeListener);
        dimanche.setOnCheckedChangeListener(onCheckedChangeListener);

        setContentView(rootView);

    }

    private String buildSelectedDaysString(){
        String finalStringName = "";
        if(lundi.isChecked()) {
            finalStringName = finalStringName + lundi.getText() + ",";
        }
        if(mardi.isChecked()) {
            finalStringName = finalStringName + mardi.getText() + ",";
        }
        if(mercredi.isChecked()) {
            finalStringName = finalStringName + mercredi.getText() + ",";
        }
        if (jeudi.isChecked()) {
            finalStringName = finalStringName + jeudi.getText() + ",";
        }
        if (vendredi.isChecked()) {
            finalStringName = finalStringName + vendredi.getText() + ",";
        }
        if (samedi.isChecked()) {
            finalStringName = finalStringName + samedi.getText() + ",";
        }
        if (dimanche.isChecked()) {
            finalStringName = finalStringName + dimanche.getText();
        }




        return finalStringName;
    }

}
