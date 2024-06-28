package com.carentproject.car_rent.entity;


import com.carentproject.car_rent.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name="users")

public class User {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String name;
     private String email;

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          User user = (User) o;
          return id.equals(user.id) && name.equals(user.name) && email.equals(user.email) && password.equals(user.password) && userRole == user.userRole;
     }

     @Override
     public int hashCode() {
          return Objects.hash(id, name, email, password, userRole);
     }

     private String password;
     private UserRole userRole;



}
