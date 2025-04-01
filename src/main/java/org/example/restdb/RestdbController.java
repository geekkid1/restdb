package org.example.restdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> submit(@RequestBody GeneralizedFeedbackData mfd) {
        FeedbackData nfd = new FeedbackData(mfd.getProductName(), mfd.getContent(), mfd.metaData);
        fs.save(nfd);
        return ResponseEntity.status(HttpStatus.CREATED).body(nfd);
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

    @GetMapping("/date")
    public List<FeedbackData> byDate(@RequestParam String date) {
        return fs.getByDate(date);
    }

    @DeleteMapping("/delall")
    public ResponseEntity<?> delAll(@RequestParam String auth) {
        if(auth.equals("tHiSdUmMyAuTh")) {
            fs.deleteAll();
            return ResponseEntity.status(HttpStatus.OK).body("Deleted");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Forbidden");
        }
    }
}
