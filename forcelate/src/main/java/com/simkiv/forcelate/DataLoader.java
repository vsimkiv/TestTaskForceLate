package com.simkiv.forcelate;

import com.simkiv.forcelate.repository.ArticleRepo;
import com.simkiv.forcelate.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private UserRepo userRepo;
    private ArticleRepo articleRepo;

    @Autowired
    public DataLoader(UserRepo userRepo, ArticleRepo articleRepo) {
        this.userRepo = userRepo;
        this.articleRepo = articleRepo;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {

        //generate 10 random users
        for (int i = 0; i < 10; i++) {
            userRepo.save(new RandomEntityGenerator(userRepo).generateUser());
        }

        //generate 10 random articles
        for (int i = 0; i < 10; i++) {
            articleRepo.save(new RandomEntityGenerator(userRepo).generateArticle());
        }
    }
}
