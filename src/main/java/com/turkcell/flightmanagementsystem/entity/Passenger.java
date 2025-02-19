package com.turkcell.flightmanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.validator.constraints.UUID;

@Entity
@Table(name="passengers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

//TODO:EMPLOYEE
//TODO:YÖNETİCİ EKLENEBİLİR TAKIM ÜYELERİ ONLARIN PERMİSSİONLARINA BAK

public class Passenger extends User {
    private int luggage;
    private String passport;



}
