package com.example.studentapp_ahguru;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<StudentData> {
    Context mCtx;
    int listLayoutRes;
    List<StudentData> studentDataList;
    SQLiteDatabase mDatabase;

    public StudentAdapter(Context mCtx, int listLayoutRes, List<StudentData> StudentList, SQLiteDatabase mDatabase) {
        super(mCtx, listLayoutRes, StudentList);

        this.mCtx = mCtx;
        this.listLayoutRes = listLayoutRes;
        this.studentDataList = StudentList;
        this.mDatabase = mDatabase;
    }

    public StudentAdapter(StudentList studentList, int activity_student_list, List<StudentData> studentList1) {
        super(studentList,activity_student_list,studentList1);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        StudentData student = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.student_custom_list_view, parent, false);
        }


        //getting views
        TextView textViewName = convertView.findViewById(R.id.textViewName);
        TextView textViewDOB = convertView.findViewById(R.id.textViewDob);
        TextView textViewEmail = convertView.findViewById(R.id.textViewEmail);
        TextView textViewclass = convertView.findViewById(R.id.textViewClass);
        TextView textViewlocation = convertView.findViewById(R.id.textViewlocation);

        //adding data to views
        textViewName.setText(student.getName());
        textViewDOB.setText(student.getDob());
        textViewEmail.setText(student.getEmail());
        textViewclass.setText(student.getClassI());
        textViewlocation.setText(student.getLocation());


        return convertView;
    }
}
