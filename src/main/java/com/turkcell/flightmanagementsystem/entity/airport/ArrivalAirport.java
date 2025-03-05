package com.turkcell.flightmanagementsystem.entity.airport;

import com.turkcell.flightmanagementsystem.entity.Flight;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;
//TODO:AKTARMALI OLUP OLMADIĞINI İNCELE FLİGHT'A EKLE BUSİNESS RULES(BİLETLERİ KONTROL EDEBİLİRSİN)
//aktarmalı olup olmasığı incelemek istersek bir alanda olmalı onu da uçuşa ekle boolean olarak olsun
//uçuşta aktarma varsa mesela indirim yapılabilir.Kampanya kısmına ekle bir sonraki seyehatinde yüzdesel olarak  indirim ver o kampanya tanımlanır ona göre bilet satışı düzenlenir
//bunun için biletinde
//iyi kod yazımında * importunu kullanmak istenmez büyük projede kasıypr ve performansı azalıyor
@Entity
@Getter
@Setter
@Table(name="arrival_airport")
public class ArrivalAirport extends Airport {


    @OneToMany(mappedBy = "arrivalAirport")
    private Set<Flight> flights;

}
