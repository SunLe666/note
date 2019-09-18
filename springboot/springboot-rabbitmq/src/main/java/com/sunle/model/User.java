package com.sunle.model;


import java.io.Serializable;

public class User implements Serializable {

    private String name;

    private int age;

    private String email;

   public User(String name,int age){
       this.name = name;
       this.age = age;
   }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
