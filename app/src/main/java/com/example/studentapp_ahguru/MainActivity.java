package com.example.studentapp_ahguru;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    public static final String DATABASE_NAME = "studentdata";

    EditText EditTextName,EditTextClass,EditTextDOB,EditTextViewEmail,EditTextViewLocation;
    FloatingActionButton add;
    Button ShowListButton;
    SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditTextName = (EditText) findViewById(R.id.editTextName);
        EditTextClass=(EditText)findViewById(R.id.editTextclass);
        EditTextDOB = (EditText) findViewById(R.id.editTextDOB);
        EditTextViewEmail = (EditText) findViewById(R.id.editTextEmail);
        EditTextViewLocation = (EditText) findViewById(R.id.editTextLocation);
        ShowListButton=(Button) findViewById(R.id.buttonStudentList);
        findViewById(R.id.fab).setOnClickListener((View.OnClickListener) this);
        ShowListButton.setOnClickListener((View.OnClickListener) this);

        //creating a database
        mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        createEmployeeTable();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab:
                addStudent();
                break;
            case R.id.buttonStudentList:

                startActivity(new Intent(this, StudentList.class));

                break;
        }
    }

    private void addStudent() {
        String name = EditTextName.getText().toString().trim();
        String dob = EditTextDOB.getText().toString().trim();
        String email = EditTextViewEmail.getText().toString().trim();
        String location = EditTextViewLocation.getText().toString().trim();
        String classS=EditTextClass.getText().toString().trim();
        //getting the current time for joining date

     String insertSQL = "INSERT INTO studentdata \n" +
                    "(name, email, class, dob,location)\n" +
                    "VALUES \n" +
                    "(?, ?, ?, ?,?);";

            //using the same method execsql for inserting values
            //this time it has two parameters
            //first is the sql string and second is the parameters that is to be binded with the query
            mDatabase.execSQL(insertSQL, new String[]{name, email, classS, dob,location});

            Toast.makeText(this, "Student Added Successfully", Toast.LENGTH_SHORT).show();
        }

    private void createEmployeeTable() {
        mDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS studentdata (\n" +
                        "    name varchar(200) NOT NULL,\n" +
                        "    email varchar(200) NOT NULL,\n" +
                        "    class varchar(200) NOT NULL,\n" +
                        "    dob varchar(200) NOT NULL,\n" +
                        "    location varchar(200) NOT NULL\n" +
                        ");"
        );
    }


}