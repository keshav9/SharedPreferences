package com.example.SharedPreference;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: ehc
 * Date: 13/6/14
 * Time: 12:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShowActivity extends Activity {

   TextView showDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.show);
        showDetails=(TextView)findViewById(R.id.showDetails);
        StringBuffer buffer=new StringBuffer();
        buffer.append("\n======================================") ;
        buffer.append("\n" +"Name: "+ getIntent().getExtras().getString("name"));
        buffer.append("\n" +"Phone: "+getIntent().getExtras().getString("phone"));
        buffer.append("\n" +"Street: "+getIntent().getExtras().getString("street"));
        buffer.append("\n" +"EmailID: "+getIntent().getExtras().getString("email"));
        buffer.append("\n" +"City: "+getIntent().getExtras().getString("city"));
        buffer.append("\n======================================") ;
        Log.d("Test","Size: "+buffer.length());
        if(buffer.length()==119)
        {
            Toast.makeText(getApplicationContext(),"No Contacts Exist",Toast.LENGTH_LONG).show();
        }
        else
            showDetails.setText(buffer);
    }
}
