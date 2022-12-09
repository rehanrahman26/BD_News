package com.mahabub.bdnews;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NewsDetails extends AppCompatActivity {

    ImageView coverImage;
    TextView tvTitle, tvDes;
    FloatingActionButton fabButton;
    TextToSpeech textToSpeech;

    public static String TITLE = "";
    public static String DESCRIPTION = "";
    public static Bitmap MY_BITMAP = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        coverImage = findViewById(R.id.coverImage);
        tvTitle = findViewById(R.id.tvTitle);
        tvDes = findViewById(R.id.tvDes);
        fabButton = findViewById(R.id.fabButton);

        tvDes.setText(DESCRIPTION);
        tvTitle.setText(TITLE);

        if(MY_BITMAP!=null) coverImage.setImageBitmap(MY_BITMAP);

        textToSpeech = new TextToSpeech(NewsDetails.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

            }
        });

        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = tvDes.getText().toString();
                textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null,null);
            }
        });

    }
}