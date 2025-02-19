package com.turkcell.flightmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;
//TODO:AİRPORT İÇERİSİNDE EXTEND EDİLEBİLİR.
//TODO:AKTARMALI OLUP OLMADIĞINI İNCELE FLİGHT'A EKLE BUSİNESS RULES(BİLETLERİ KONTROL EDEBİLİRSİN)


@Entity
@Getter
@Setter
@Table(name="arrival_airport")
public class ArrivalAirport {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name="airport_name")
    private String name;


    private String location;

    @OneToMany(mappedBy = "arrivalAirport")
    private Set<Flight> flights;

}
