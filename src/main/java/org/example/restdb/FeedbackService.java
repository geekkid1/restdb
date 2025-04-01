package org.example.restdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {
    @Autowired FeedbackRepository repo;

    public void save(FeedbackData fb) {
        repo.save(fb);
    }
    public List<FeedbackData> byProduct(String product) {
        return repo.findByProductName(product);
    }

    public Optional<FeedbackData> byId(long id) {
        return repo.findById(id);
    }

    public List<FeedbackData> all() {
        return (List<FeedbackData>) repo.findAll();
    }

    public List<FeedbackData> getByDate(String date) { return repo.findByDate(date); }

    // FOR DEBUG PURPOSES ONLY, DO NOT HOOK UP TO PRODUCTION ENDPOINT
    public void deleteAll() { repo.deleteAll(); }
}
