package org.codegym.demoapp.entities;

public class User {
    private int id;
    private String name;
    private String email;
    public String password;
    public String pathAvatar;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(int id, String name, String email, String password, String pathAvatar) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.pathAvatar = pathAvatar;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
