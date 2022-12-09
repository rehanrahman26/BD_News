package com.mahabub.bdnews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class OtherNews extends AppCompatActivity {
    TextView prothomalo,jugantor,dailystar,inkilab,manobjomin,somokal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_news);


        prothomalo = findViewById(R.id.prothomalo);
        jugantor = findViewById(R.id.jugantor);
        dailystar = findViewById(R.id.dailystar);
        inkilab = findViewById(R.id.inkilab);
        manobjomin = findViewById(R.id.manobjomin);
        somokal = findViewById(R.id.somokal);


        prothomalo.setMovementMethod( LinkMovementMethod.getInstance() );
        jugantor.setMovementMethod( LinkMovementMethod.getInstance() );
        dailystar.setMovementMethod( LinkMovementMethod.getInstance() );
        inkilab.setMovementMethod( LinkMovementMethod.getInstance() );
        manobjomin.setMovementMethod( LinkMovementMethod.getInstance() );
        somokal.setMovementMethod( LinkMovementMethod.getInstance() );
    }
}