package com.facebook.facebookmini.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


@Entity
@Table(name ="Posts")

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne
    @JoinColumn(name = "users",referencedColumnName = "id")
    private AppUser appUser;

    @Column(name = "content", nullable = false,  length = 1000)
    private String content;
    @Column(name = "time_stamp")
    private LocalDateTime timeStamp;
}
