package com.example.faraz.navigationapp;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by Faraz on 08-04-2017.
 */


public class FeedbackData {
    private String name;
    private String email;
    private String feedback;
    private String type;


    public FeedbackData() {
      /*Blank default constructor essential for Firebase*/
    }

    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getFeedbackType() {
        return type;
    }

    public void setFeedbackType(String fbtype) {
        this.type = fbtype;
    }
}