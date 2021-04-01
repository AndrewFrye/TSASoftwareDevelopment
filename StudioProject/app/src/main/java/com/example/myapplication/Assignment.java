package com.example.myapplication;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Assignment {
    public String ClassName;
    public String Name;
    public boolean Completed;
    public String DueDate;

    public Assignment(String className, String name, String dueDate, boolean completed){
        ClassName = className;
        Name = name;
        Completed = completed;
        DueDate = dueDate;
    }

    public String toString(){
        return new String("Class: "+ClassName+" Assignment: "+Name+" Is Completed: "+Completed+" Due Date: "+DueDate);
    }
}
