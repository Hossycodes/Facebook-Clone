package com.facebook.facebookmini.service;

import com.facebook.facebookmini.entity.AppUser;
import com.facebook.facebookmini.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    public List<Post> getAllPosts();
    Post createPost( Post post);
    void deletePost(Long postId);

    Post updatePost(Post post);

}
