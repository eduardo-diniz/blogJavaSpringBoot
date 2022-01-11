package com.spring.codeblog.service;

import com.spring.codeblog.model.Post;

import java.util.List;

public interface Codeblogservice {

    List<Post> findAll();
    Post findById(long id);
    Post save (Post post);

}
