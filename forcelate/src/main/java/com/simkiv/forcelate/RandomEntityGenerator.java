package com.simkiv.forcelate;

import com.simkiv.forcelate.entity.Article;
import com.simkiv.forcelate.entity.Color;
import com.simkiv.forcelate.entity.User;
import com.simkiv.forcelate.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

import static com.simkiv.forcelate.RandomEntityGenerator.RandomFieldValuesGenerator.*;


@Component
public class RandomEntityGenerator {
    private UserRepo userRepo;

    @Autowired
    public RandomEntityGenerator(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User generateUser() {
        User user = new User();

        user.setAge(generateRandomAge());
        user.setName(generateName());
        return user;
    }

    public Article generateArticle() {
        Article article = new Article();
        article.setText(generateText());
        article.setAuthor(generateAuthor(userRepo.findAll()));
        article.setColor(generateColor());
        return article;
    }


    public static class RandomFieldValuesGenerator {
        private RandomFieldValuesGenerator() {
        }

        //methods for generation random values of fields of User objects
        static String generateName() {
            int leftLimit = 97; // letter 'a'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = generateRandomNumberInRange(1, 20);

            StringBuilder buffer = new StringBuilder(targetStringLength);

            for (int i = 0; i < targetStringLength; i++) {
                buffer.append((char) generateRandomNumberInRange(leftLimit, rightLimit));
            }

            return buffer.toString();
        }

        static int generateRandomAge() {
            return generateRandomNumberInRange(0, 125);
        }


        //methods for generation random values of fields of Article objects
        static String generateText() {
            byte[] array = new byte[140]; // length of limited to 140 symbols by analogy with Twitter
            new Random().nextBytes(array);

            return new String(array, Charset.forName("UTF-8"));
        }

        static Color generateColor() {
            return Color.values()[new Random().nextInt(Color.values().length)];
        }

        static User generateAuthor(List<User> users) {
            return users.get(new Random().nextInt(users.size()));
        }


        //helper method for generation age generation and length of name
        private static int generateRandomNumberInRange(int min, int max) {
            if (min >= max) {
                throw new IllegalArgumentException("max must be greater than min");
            }

            return new Random().nextInt((max - min) + 1) + min;
        }
    }

}
