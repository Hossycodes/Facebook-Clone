package com.facebook.facebookmini.repository;

import com.facebook.facebookmini.entity.CommentLike;
import com.facebook.facebookmini.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentLikeRepository extends JpaRepository<CommentLike, Long> {
}
