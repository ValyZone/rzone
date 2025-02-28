package com.rzone.tournament_web_app.dao;

import com.rzone.tournament_web_app.entity.BlogPost;
import com.rzone.tournament_web_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<BlogPost, Integer> {

    BlogPost findByTitle(String title);

    @Query("SELECT b FROM BlogPost b ORDER BY b.createdAt DESC LIMIT 1")
    BlogPost findLatestBlog();
}

