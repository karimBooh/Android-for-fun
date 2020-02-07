package ca.ulaval.ima.tp1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;

public class ProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        setTitle("ProfilActivity");

        final Profil me = getIntent().getParcelableExtra("Profile");

        if (me != null) {

            TextView firstnameinput = findViewById(R.id.firstnameinput);
            firstnameinput.setText(me.getFirstname());

            TextView lastnameinput = findViewById(R.id.lastnameinput);
            lastnameinput.setText(me.getLastname());

            TextView birthdayinput = findViewById(R.id.birthdayinput);
            birthdayinput.setText(new SimpleDateFormat("dd/mm/yyyy").format(me.getBirthday()));

            TextView idulinput = findViewById(R.id.idulinput);

            idulinput.setText(me.getIdul());
        }
    }
}
