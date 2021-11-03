package com.example.android_app1_uni;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    protected Button mainMoscow;
    protected Button mainAustralia;
    protected Button mainNY;
    protected Button mainVlad;
    protected Button mainParis;
    protected Button mainTokyo;

    protected List<Button> buttonsList = new ArrayList<Button>();
    protected Map<Integer,String> instruction = new HashMap<Integer,String>();

    protected TextView outputData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init();
    }

    private void Init() {
        outputData = findViewById(R.id.main_textview);

        mainMoscow = findViewById(R.id.main_button_Moscow);
        instruction.put(R.id.main_button_Moscow, "+03");
        buttonsList.add(mainMoscow);

        mainAustralia = findViewById(R.id.main_button_Canberra);
        instruction.put(R.id.main_button_Canberra, "+11");
        buttonsList.add(mainAustralia);

        mainNY = findViewById(R.id.main_button_NY);
        instruction.put(R.id.main_button_NY, "-04");
        buttonsList.add(mainNY);

        mainVlad = findViewById(R.id.main_button_Vladivostok);
        instruction.put(R.id.main_button_Vladivostok, "+10");
        buttonsList.add(mainVlad);

        mainTokyo = findViewById(R.id.main_button_Tokyo);
        instruction.put(R.id.main_button_Tokyo, "+09");
        buttonsList.add(mainTokyo);

        mainParis = findViewById(R.id.main_button_Paris);
        instruction.put(R.id.main_button_Paris, "+01");
        buttonsList.add(mainParis);

        for (Button button : buttonsList) {

            button.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        String sdvig = instruction.get(v.getId());
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT" + sdvig));
        outputData.setText(dateFormat.format(new Date()));
    }
}