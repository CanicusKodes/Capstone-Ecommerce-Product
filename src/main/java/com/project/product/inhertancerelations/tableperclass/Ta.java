package com.project.product.inhertancerelations.tableperclass;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "tpc_ta")
@Setter
@Getter
public class Ta extends User {
    private double taRating;
}
