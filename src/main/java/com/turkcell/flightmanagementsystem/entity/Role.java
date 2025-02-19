package com.turkcell.flightmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
   @Id
    @UuidGenerator
    private UUID roleId;
   private String name;

    @ManyToMany
    @JoinTable(
            name = "roles_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<Permission> permissions;

    @ManyToMany()
    private Set<User> users;


}
