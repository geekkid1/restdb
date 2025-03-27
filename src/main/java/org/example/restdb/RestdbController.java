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

    /*@PostMapping("/submit")
    public void submit(@RequestParam(name = "product_name", defaultValue = "N/A") String pn, @RequestParam(name = "content") String c) {
        fs.save(new FeedbackData(pn, c));
    }*/

    @PostMapping("/jacksubmit")
    public void jackSubmit(@RequestBody MarshalledFeedbackData mfd) {
        for(Map.Entry<String, String> entry : mfd.metaData.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        fs.save(new FeedbackData(mfd.getProductName(), mfd.getContent(), mfd.metaData));
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
