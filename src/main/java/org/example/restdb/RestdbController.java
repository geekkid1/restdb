package org.example.restdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.List;

@RestController
public class RestdbController {
    private final AtomicLong counter = new AtomicLong();
    @Autowired FeedbackService fs;

    @PostMapping("/submit")
    public void submit(@RequestBody MarshalledFeedbackData mfd) {
        for(Map.Entry<String, String> entry : mfd.metaData.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        fs.save(new FeedbackData(mfd.getProductName(), mfd.getContent(), mfd.metaData));
    }

    @GetMapping("/product")
    public List<FeedbackData> product(@RequestParam String product) {
        return fs.byProduct(product);
    }

    @GetMapping("/id")
    public Optional<FeedbackData> id(@RequestParam long id) {
        return fs.byId(id);
    }

    @GetMapping("/all")
    public List<FeedbackData> all() {
        return fs.all();
    }
}
