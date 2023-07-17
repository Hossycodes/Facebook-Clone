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
@Table(name ="postLike")
public class PostLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long postLikeId;
    @ManyToOne
    @JoinColumn(name = "users", referencedColumnName = "id",nullable = false)
private AppUser appUser;
    @ManyToOne
    @JoinColumn(name = "post", referencedColumnName = "postId",nullable = false)
private Post post;

}
