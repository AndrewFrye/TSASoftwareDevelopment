package com.example.myapplication;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;

import org.json.JSONObject;

public class ReadWrite {

    Assignment content = new Assignment("a", "b", "c", true);
    AssignmentList Assignments = new AssignmentList();
    File Directory;

    public ReadWrite (Context c) throws FileNotFoundException{
        File directory = new File(c.getFilesDir().getAbsolutePath());
        Directory = directory;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void write() throws IOException {
        FileWriter fw = new FileWriter(Directory + "/Assignments.json");
        ObjectMapper om = new ObjectMapper();
        String JSON = om.writer().writeValueAsString(Assignments);

        fw.write(JSON);
        System.out.println(JSON);
        fw.close();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String read() throws IOException {
        FileReader fr = new FileReader(Directory + "/Assignments.json");

        try (BufferedReader br = new BufferedReader(new FileReader(Directory + "/Assignments.json"))){
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        fr.close();
        return new String();
    }

    boolean y = true;
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addToList(Assignment x) throws IOException {
        if(y && read().equals(null)){
            y = false;
            Gson g = new Gson();
            AssignmentList AssignmentTemp = g.fromJson(read(), AssignmentList.class);
            Assignments = AssignmentTemp;
        }

        Assignments.Assignments.add(x);
    }

    int current = 0;
    @RequiresApi(api = Build.VERSION_CODES.O)
    public String cycleAssignments() throws IOException {
        if(y){
            AssignmentList AssignmentTemp = new AssignmentList();
            y = false;
            Gson g = new Gson();
            if(!read().equals(null) && !read().equals("")) {
                 Assignments = g.fromJson(read(), AssignmentList.class);
            }
            if(!AssignmentTemp.equals(null)) {
                Assignments = AssignmentTemp;
            }
        }

        String str = "";
        if(!Assignments.equals(null) && Assignments.Assignments.size()>0)
        {
            if (current == Assignments.Assignments.size()) current = 0;
            else current++;
            str = Assignments.Assignments.get(0).toString();
            System.out.println(current);
        }
        else str = "No Assignments to show";

        //System.out.println(Assignments.Assignments);
        //System.out.println(str);
        return str;
    }

    public void removeFromList(){
        Assignments.Assignments.remove(current);
    }

}



