package org.example.restdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;
import java.util.List;

@RestController
public class RestdbController {
    private final AtomicLong counter = new AtomicLong();
    @Autowired FeedbackRepository repo;

    @PostMapping("/submit")
    public void submit(@RequestParam(value = "product_name", defaultValue = "N/A") String productName, @RequestParam(value = "feedback_content", defaultValue = "") String content) {
        FeedbackData fb = new FeedbackData(counter.incrementAndGet(), productName, content);
        repo.save(fb);
    }

    @GetMapping("/getByProduct")
    public List<FeedbackData> findByProduct(@RequestParam(value = "product_name") String productName) {
        return repo.findByProductName(productName);
    }

    @GetMapping("/all")
    public List<FeedbackData> all() {
        return (List<FeedbackData>) repo.findAll();
    }
}
