package com.turkcell.flightmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="permission")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    @Id
    @UuidGenerator
    private UUID id;

    private String name;
    private String description;

    @ManyToMany(mappedBy = "permissions")
    @JsonIgnore
    private Set<Role> roles;
}
