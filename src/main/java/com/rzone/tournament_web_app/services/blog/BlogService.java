package com.rzone.tournament_web_app.services.blog;

import com.rzone.tournament_web_app.entity.BlogPost;
import com.rzone.tournament_web_app.entity.User;

import java.util.List;

public interface BlogService {
    List<BlogPost> findAll();

    BlogPost findById(int theId);

    void save(BlogPost theBlogPost);

    void deleteById(int theId);

    BlogPost findByTitle(String title);

    BlogPost getLatestBlog();
}
