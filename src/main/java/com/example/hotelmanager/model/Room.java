package com.example.hotelmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Min(0)
    private int quantityOfMembers;

    @Min(0)
    private int quantityOfSingleBed;

    @Min(0)
    private int quantityOfDoubleBed;

    @NotBlank
    private double area;

    private boolean personalBathroom;

    private boolean personalKitchen;

    private boolean airConditioner;

    @NotBlank
    private boolean isAvailable;
}
