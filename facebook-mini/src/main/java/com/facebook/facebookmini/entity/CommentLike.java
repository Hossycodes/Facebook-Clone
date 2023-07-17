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
@Table(name ="commentLike")
public class CommentLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentLikeId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "comment",referencedColumnName = "id",nullable = false)
    private Comment comment;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users",referencedColumnName = "id", nullable = false)
    private AppUser appUser;
}
