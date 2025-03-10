package org.example.restdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.List;

@RestController
public class RestdbController {
    private final AtomicLong counter = new AtomicLong();
    @Autowired FeedbackService fs;

    @PostMapping("/submit")
    public void submit(@RequestParam(name = "product_name", defaultValue = "N/A") String pn, @RequestParam(name = "content") String c) {
        fs.save(new FeedbackData(pn, c));
    }

    @GetMapping("/product/{product}")
    public List<FeedbackData> product(@PathVariable String product) {
        return fs.byProduct(product);
    }

    @GetMapping("/id/{id}")
    public Optional<FeedbackData> id(@PathVariable long id) {
        return fs.byId(id);
    }

    @GetMapping("/all")
    public List<FeedbackData> all() {
        return fs.all();
    }
}
