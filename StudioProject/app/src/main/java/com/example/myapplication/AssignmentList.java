package com.example.myapplication;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({"Assignments"})
public class AssignmentList {
    //@JsonProperty("Assignments")
    public List<Assignment> Assignments = new ArrayList<>();
}
