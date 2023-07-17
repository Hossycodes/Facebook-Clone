package com.facebook.facebookmini.entity;


import com.facebook.facebookmini.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


@Entity
@Table(name ="users")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;

//    @Column(name = "phoneNumber", nullable = false, columnDefinition = "varchar(255)")
//    private String phoneNumber;


    @Column(name = "country", nullable = false)
    private String country;


}
