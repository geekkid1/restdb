package org.example.restdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.List;

@RestController
public class RestdbController {
    private final AtomicLong counter = new AtomicLong();
    @Autowired FeedbackRepository repo;

    @PostMapping("/submit")
    public void submit(@RequestBody FeedbackData fb) {
        repo.save(fb);
    }

    @GetMapping("/product/{product}")
    public List<FeedbackData> product(@PathVariable String product) {
        return repo.findByProductName(product);
    }

    @GetMapping("/id/{id}")
    public Optional<FeedbackData> id(@PathVariable long id) {
        return repo.findById(id);
    }

    @GetMapping("/all")
    public List<FeedbackData> all() {
        return (List<FeedbackData>) repo.findAll();
    }
}
