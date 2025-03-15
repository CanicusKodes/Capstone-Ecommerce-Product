package com.project.product.inhertancerelations.mappedsuperclass;


import jakarta.persistence.Entity;

@Entity(name = "ms_student")
public class Student extends User {

    private double pspRating;
}
