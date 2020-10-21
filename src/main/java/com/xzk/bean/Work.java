package com.xzk.bean;

import java.util.List;

public class Work {

    private int id;
    private String work;

    private List<User> users ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", work='" + work + '\'' +
                ", users=" + users +
                '}';
    }
}
