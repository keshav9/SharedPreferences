package com.example.SharedPreference;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MyActivity extends Activity {
    public final String myPreference = "Myprefer";
    public final String nameKey = "nameKey";
    public final String phoneKey = "phoneKey";
    public final String streetKey = "streetKey";
    public final String emailKey = "emailKey";
    public final String cityKey = "cityKey";
    public String nameView;
    public String phoneView;
    public String streetView;
    public String emailView;
    public String cityView;
    TextView name;
    TextView phone;
    TextView street;
    TextView email;
    TextView city;
    Button button;
    SharedPreferences preference;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        name = (TextView) findViewById(R.id.editTextName);
        phone = (TextView) findViewById(R.id.editTextPhone);
        street = (TextView) findViewById(R.id.editTextStreet);
        email = (TextView) findViewById(R.id.editTextEmail);
        city = (TextView) findViewById(R.id.editTextCity);
        button = (Button) findViewById(R.id.show);
        preference = getSharedPreferences(myPreference, MODE_PRIVATE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //To change body of implemented methods use File | Settings | File Templates.
                Intent intent = new Intent(MyActivity.this, ShowActivity.class);

                if (preference.contains("nameKey")) {
                    nameView = preference.getString("nameKey", "");
                }
                if (preference.contains("phoneKey")) {
                    phoneView = preference.getString("phoneKey", "");
                }
                if (preference.contains("streetKey")) {
                    streetView = preference.getString("streetKey", "");
                }
                if (preference.contains("emailKey")) {
                    emailView = preference.getString("emailKey", "");
                }
                if (preference.contains("cityKey")) {
                    cityView = preference.getString("cityKey", "");
                }
                if (nameView == null)
                    intent.putExtra("name", "");
                else
                    intent.putExtra("name", nameView);
                if (phoneView == null)
                    intent.putExtra("phone", "");
                else
                    intent.putExtra("phone", phoneView);
                if (emailView == null)
                    intent.putExtra("email", "");
                else
                    intent.putExtra("email", emailView);
                if (streetView == null)
                    intent.putExtra("street", "");
                else
                    intent.putExtra("street", streetView);
                if (cityView == null)
                    intent.putExtra("city", "");
                else
                    intent.putExtra("city", cityView);

                startActivity(intent);
            }
        });
    }

    public void run(View view) {
        String n = name.getText().toString();
        String p = phone.getText().toString();
        String s = street.getText().toString();
        String e = email.getText().toString();
        String c = city.getText().toString();
        SharedPreferences.Editor editor = preference.edit();
        if (n.equals(""))
            name.setHint("name required");
        else
            editor.putString("nameKey", n);
        if (p.equals(""))
            phone.setHint("phone required");
        else
            editor.putString("phoneKey", p);
        if (s.equals(""))
            street.setHint("street required");
        else
            editor.putString("streetKey", s);
        if (e.equals(""))
            email.setHint("Email Required");
        else
            editor.putString("emailKey", e);
        if (c.equals(""))
            city.setHint("country required");
        else
            editor.putString("cityKey", c);
        editor.commit();
        if((!n.equals("") && !p.equals("") && !s.equals("") && !e.equals("") && !c.equals("")) )
        Toast.makeText(getApplicationContext(),"added successfully",Toast.LENGTH_SHORT).show();

    }

}
