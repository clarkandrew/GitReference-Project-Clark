package com.example.andrewclark.gitreference_project_clark;

/**
 * Created by andrewclark on 2/28/18.
 */

public class GitReference {
    private String section;
    private String command;
    private String explanation;
    private String example;



    public GitReference() {}
    //getters
    public String getSection() {
        return section;
    }
    public String getCommand() {
        return command;
    }
    public String getExample() {
        return example;
    }
    public String getExplanation() {
        return explanation;
    }

    // setters
    public void setSection(String s) {
        section = s;
    }
    public void setCommand(String s) {
        command = s;
    }
    public void setExample(String s) {
        example = s;
    }
    public void setExplanation(String s) {
        explanation = s;
    }

    public String toString() {
        return section;
    }
}