package com.example.afiqhbs.firebaseloginv2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.afiqhbs.firebaseloginv2.Class.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by User on 22/1/2018.
 */

public class RemarksActivity extends AppCompatActivity {

    EditText remarksText;
    Button rBtn;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myInfo = database.getReference("info");

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remarks);

        remarksText = (EditText) findViewById(R.id.remarksText);
        rBtn = (Button) findViewById(R.id.sendRemarks);

        rBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                addRemarks();
            }
        });
    }

    private void addRemarks() {
        String remarks = remarksText.getText().toString().trim();
        if (!TextUtils.isEmpty(remarks)) {
            String currDate = DateFormat.getDateTimeInstance().format(new Date());
            String key = myInfo.push().getKey();
            User clkInfo = new User("", currDate, "", "", "", "", remarks);
            myInfo.child(key).setValue(clkInfo);
            Toast.makeText(this, "Remarks added", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "Please enter remarks", Toast.LENGTH_LONG).show();
        }
    }
}
