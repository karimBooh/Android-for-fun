package ca.ulaval.ima.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("TP1");
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        Date date = new Date();

        try {
            date = format.parse("19/11/1995");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        final Profil me = new Profil("Karim", "Boulaich", date, "111 274 529");


        final String UrlToLoad = "https://evernote.com/intl/fr";

        Button webext = findViewById(R.id.webext);

        webext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openURL = new Intent(Intent.ACTION_VIEW);
                openURL.setData(Uri.parse(UrlToLoad));
                startActivity(openURL);
            }
        });


        Button webwv = findViewById(R.id.webwv);

        webwv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra("UrlToLoad", UrlToLoad);
                startActivity(intent);
            }
        });

        Button ulaval = (Button) findViewById(R.id.ulaval);

        ulaval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ULavalActivity.class);
                startActivity(intent);
            }
        });

        Button profil = (Button) findViewById(R.id.profil);

        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfilActivity.class);
                intent.putExtra("Profile", me);
                startActivity(intent);
            }
        });

    }

}
