package com.turkcell.flightmanagementsystem.service;

import com.turkcell.flightmanagementsystem.entity.DepartureAirport;

import java.util.Optional;
import java.util.UUID;

//TODO:AİRPORTLARI TEK BİR AİRPORTTA BİRLEŞTİR BİR HAVALİMANI İKSİNİ DE EKLENEBİLİR
//TODO:BELİRLİ BİR FORMAT NASIL ATILIR JAVA DA
//TODO:ABSTRACT CLASS OLARAK YAZ MAPPERLAR
//TODO: ENTİTY İSİMLERİNİ CONTROLLER,REPO SERVİCE DE OLUR
public interface DepartureAirportService {
    Optional<DepartureAirport> findById(UUID id);
}
