package com.example.hotelmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private int quantityOfMembers;

    @Min(0)
    private int quantityOfSingleBed;

    @Min(0)
    private int quantityOfDoubleBed;

    @NotBlank
    private double area;

    private boolean personalBathroom;

    private boolean airConditioner;

    private boolean personalKitchen;

    @NotBlank
    private boolean available;

}
