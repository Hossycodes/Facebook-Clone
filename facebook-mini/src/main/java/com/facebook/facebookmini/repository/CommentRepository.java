package com.facebook.facebookmini.repository;

import com.facebook.facebookmini.entity.Comment;
import com.facebook.facebookmini.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
