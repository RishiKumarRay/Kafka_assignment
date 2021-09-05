package com.knoldus.model;

public class User_Input {
    // {"id":"1","name":"some_name","age":"24","course":"B.Tech."}

    private int id;
    private String name;
    private int age;
    private String course;

    public User_Input()
    {}

    public User_Input(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    public String toString() {
        return "User{" + "Id='" + id  + ", age=" + age + ", name='" + name + '\'' + ", course='" + course + '\'' + '}';
    }
}