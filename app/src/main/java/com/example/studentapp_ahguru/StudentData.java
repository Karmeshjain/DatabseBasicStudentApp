package com.example.studentapp_ahguru;

public class StudentData
{
    String name;
  String dob;
 String email;
  String location;
  String classI;

    public StudentData(String name, String dob, String email, String location) {

        this.name = name;
        this.dob=dob;
        this.email = email;
        this.location = location;
        this.classI = classI;
    }



    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    public String getDob() {
        return dob;
    }

    public  String getLocation() {
        return location;
    }

    public  String getClassI() {
        return classI;
    }
}
