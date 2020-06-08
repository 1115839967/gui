package com.gui.model;

import java.time.LocalDate;

/**
 * 学生实体
 */
public class Student {
    private int id;
    private String name;
    private double score;
    private LocalDate birth;
    private String city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Student(int id, String name, double score, LocalDate birth, String city) {
        super();
        this.id = id;
        this.name = name;
        this.score = score;
        this.birth = birth;
        this.city = city;
    }

    public Student(String name, double score, LocalDate birth, String city) {
        super();
        this.name = name;
        this.score = score;
        this.birth = birth;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", score=" + score + ", birth=" + birth + ", city=" + city
                + "]";
    }

    public Student() {
        super();
    }

}
