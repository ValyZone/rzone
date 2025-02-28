package com.rzone.tournament_web_app.services.blog;

import com.rzone.tournament_web_app.dao.BlogRepository;
import com.rzone.tournament_web_app.entity.BlogPost;
import com.rzone.tournament_web_app.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public List<BlogPost> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public BlogPost findById(int theId) {
        Optional<BlogPost> result = blogRepository.findById(theId);

        BlogPost theBlog = null;

        if (result.isPresent()) {
            theBlog = result.get();
        }
        else {
            // we didn't find the User
            throw new RuntimeException("Did not find Blog id - " + theId);
        }

        return theBlog;
    }

    @Override
    public void save(BlogPost theBlogPost) {
        blogRepository.save(theBlogPost);
    }

    @Override
    public void deleteById(int theId) {
        blogRepository.deleteById(theId);
    }

    @Override
    public BlogPost findByTitle(String title) {
        BlogPost theBlog = blogRepository.findByTitle(title);

        if (theBlog != null) {
            return theBlog;
        }

        throw new RuntimeException("Blog not found with title: " + title);
    }

    public BlogPost getLatestBlog() {
        return blogRepository.findLatestBlog();
    }
}
