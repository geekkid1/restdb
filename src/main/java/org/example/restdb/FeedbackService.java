package org.example.restdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {
    @Autowired FeedbackRepository repo;
    @Autowired UserRepo ur;

    public void save(FeedbackData fb) {
        if(fb.getProductName() == null || fb.getProductName().isEmpty() || fb.getProductName().equalsIgnoreCase("all")) {
            fb.setProductName("all");
        }
        repo.save(fb);
    }

    public List<FeedbackData> byProduct(String product) {
        if(product == null || product.isEmpty() || product.equalsIgnoreCase("all")) {
            return repo.findByProductName("all");
        } else {
            return repo.findByProductName(product);
        }
    }

    public Optional<FeedbackData> byId(long id) {
        return repo.findById(id);
    }

    public List<FeedbackData> all() {
        return (List<FeedbackData>) repo.findAll();
    }

    public List<FeedbackData> getByDate(String date) { return repo.findByDate(date); }

    public void delete(long id) {
        repo.deleteById(id);
    }

    public void associate(long id, long uid) {
        UserData ud = ur.findById(uid).get();
        repo.updateAuthorById(id, ud);
        //repo.associate(id, uid);
    }
}
