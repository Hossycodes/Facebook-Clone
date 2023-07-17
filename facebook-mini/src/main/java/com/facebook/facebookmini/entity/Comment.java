package com.facebook.facebookmini.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


@Entity
@Table(name ="comment")

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users",referencedColumnName = "id",nullable = false)
    private AppUser appUser;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post", referencedColumnName = "postId",nullable = false)
    private Post post;
    @Column(name = "content", nullable = false, insertable = false, updatable = false, length = 500)
    private String content;
    @Column(name = "timestamp", nullable = false)
    private String timeStamp;
}
