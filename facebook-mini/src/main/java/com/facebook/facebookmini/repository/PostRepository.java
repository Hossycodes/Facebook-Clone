package com.facebook.facebookmini.repository;

import com.facebook.facebookmini.entity.Post;
import com.facebook.facebookmini.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
