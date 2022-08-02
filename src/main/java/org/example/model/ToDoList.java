package org.example.model;

import lombok.Data;

@Data
public class ToDoList {

    private String title;
    private String description;

    private String stade;

    public ToDoList(String title, String description,String stade) {
        this.title = title;
        this.description = description;
        this.stade=stade;
    }
}
