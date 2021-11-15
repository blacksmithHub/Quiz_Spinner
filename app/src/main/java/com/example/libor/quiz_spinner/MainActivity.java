package com.example.libor.quiz_spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   public ImageButton signup = (ImageButton) findViewById(R.id.imageButton_submit);
   public EditText surname, firstname, mi, birth, address, email, password, confirm;
   public String sn, fn, m ,bd, add, mail, pass, conf, sub, match;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surname = (EditText)findViewById(R.id.editText_surname);
        firstname = (EditText)findViewById(R.id.editText_firstname);
        mi = (EditText)findViewById(R.id.editText_middleinitial);
        birth = (EditText)findViewById(R.id.editText_birthday);
        address = (EditText)findViewById(R.id.editText_address);
        email = (EditText)findViewById(R.id.editText_email);
        password = (EditText)findViewById(R.id.editText_password);
        confirm = (EditText)findViewById(R.id.editText_retypepass);

    }

    public void onButtonClickListener (View v) {
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        signup.startAnimation(myAnim);
        sn = fn = bd = add = mail = pass = conf = sub = match = null;
        if (surname.getText().toString().matches(null)) {
            sn = "Surname \n";
        }
        if (firstname.getText().toString().matches(null)) {
            fn = "First Name \n";
        }
        if (mi.getText().toString().matches(null)) {
            m = "Middle Initial \n";
        }
        if (birth.getText().toString().matches(null)) {
            bd = "Date of Birth \n";
        }
        if (address.getText().toString().matches(null)) {
            add = "Postal Address \n";
        }
        if (email.getText().toString().matches(null)) {
            mail = "E-Mail \n";
        }
        if (password.getText().toString().matches(null)) {
            pass = "Password \n";
        } else if (!password.getText().toString().matches(confirm.getText().toString())) {
            match = "Password is not match \n";
        }
        if (confirm.getText().toString().matches(null)) {
            conf = "Re-Type Password \n";
        } else if (!surname.getText().toString().matches(null) && !firstname.getText().toString().matches(null)
                && !mi.getText().toString().matches(null) && !birth.getText().toString().matches(null)
                && !address.getText().toString().matches(null) && !email.getText().toString().matches(null)
                && password.getText().toString().matches(confirm.getText().toString())) {
            sub = "Signing up... \n";
        }
        Toast.makeText(MainActivity.this, sn + fn + bd + add + mail + pass + conf + sub + match + "ARE REQUIRED!", Toast.LENGTH_LONG).show();

    }
}
