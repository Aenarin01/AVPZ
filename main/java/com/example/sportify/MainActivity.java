package com.example.sportify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText newName, newAge, newPassword;
    private TextView  profileName, profileAge;
    private Button editProfile, edit, startTrain;
    public String password = "000";
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit();
    }
    public void edit(){
        profileName = (TextView)findViewById(R.id.profile_name);
        profileAge = (TextView)findViewById(R.id.profile_age);
        newName = (EditText)findViewById(R.id.new_name);
        newAge = (EditText)findViewById(R.id.new_age);
        edit = (Button)findViewById(R.id.edit);
        startTrain = (Button)findViewById(R.id.start_train);
        editProfile = (Button)findViewById(R.id.edit_profile);
        edit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        profileName.setText(newName.getText());
                        profileAge.setText(newAge.getText());
                        newName.setVisibility(View.INVISIBLE);
                        newAge.setVisibility(View.INVISIBLE);

                    }
                }
        );
        startTrain.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent Choice_train = new Intent(".TrainList");
                        startActivity(Choice_train);
                    }
                }
        );
        editProfile.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        newName.setVisibility(View.VISIBLE);
                        newAge.setVisibility(View.VISIBLE);
                        edit.setVisibility(View.VISIBLE);

                    }
                }
        );
    }
}