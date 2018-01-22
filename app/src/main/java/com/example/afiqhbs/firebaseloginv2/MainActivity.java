package com.example.afiqhbs.firebaseloginv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView date;
    EditText id,pass;
    Button btn;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = (EditText) findViewById(R.id.edid);
        pass = (EditText) findViewById(R.id.edpass);
        date = (TextView)  findViewById(R.id.dateTime);

        btn = (Button) findViewById(R.id.button);

        Log.d("FirabasePath",myRef.toString());
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

        date.setText(currentDateTimeString);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),myRef.toString(), Toast.LENGTH_SHORT);
                final String idtext = id.getText().toString();
                final String password = pass.getText().toString();
                Log.d("editText","ID: "+idtext+" Password: "+password);

                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Iterable<DataSnapshot> child = dataSnapshot.getChildren();
                        for(DataSnapshot c:child){
                            Log.d("editText",c.toString());
                            String a = c.child("id").getValue(String.class);
                            String b = c.child("password").getValue(String.class);
                            Toast.makeText(getApplicationContext(),a + " " + b, Toast.LENGTH_SHORT);
                            if(idtext.equalsIgnoreCase(a) && password.equalsIgnoreCase(b)){
                                Intent i = new Intent(MainActivity.this,AttendanceActivity.class);
                                //i.putExtra("name",c.child("name").getValue(String.class));
                                finish();
                                startActivity(i);

                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });
    }
}
