package com.facebook.facebookmini.service.Implementation;

import com.facebook.facebookmini.entity.Post;
import com.facebook.facebookmini.repository.PostRepository;
import com.facebook.facebookmini.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);

    }

    @Override
    public Post updatePost(Post post) {
        return postRepository.save(post);
    }
}
