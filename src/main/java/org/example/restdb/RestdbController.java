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

    @GetMapping("/ping")
    public ResponseEntity<?> ping() {
        return ResponseEntity.status(HttpStatus.OK).body("Pong");
    }

    // ========================
    // == FEEDBACK ENDPOINTS ==
    // ========================

    @PostMapping("/submit")
    public ResponseEntity<?> submit(@RequestBody GeneralizedFeedbackData mfd) {
        FeedbackData nfd = new FeedbackData(mfd.getProductName(), mfd.getContent(), mfd.metaData);
        fs.save(nfd);
        return ResponseEntity.status(HttpStatus.CREATED).body(nfd);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> edit(@RequestBody FeedbackData fd) {
        fs.save(fd);
        return ResponseEntity.status(HttpStatus.OK).body(fd);
    }

    @GetMapping("/product")
    public List<FeedbackData> product(@RequestParam String product) {
        return fs.byProduct(product);
    }

    @GetMapping("/id")
    public Optional<FeedbackData> id(@RequestParam long id) {
        Optional<FeedbackData> output = fs.byId(id);

        return output;
    }

    @GetMapping("/all")
    public List<FeedbackData> all() {
        return fs.all();
    }

    @GetMapping("/date")
    public List<FeedbackData> byDate(@RequestParam String date) {
        return fs.getByDate(date);
    }

    @DeleteMapping("/del")
    public ResponseEntity<?> delAll(@RequestParam long id) {
        fs.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }

    // ====================
    // == USER ENDPOINTS ==
    // ====================

    @Autowired UserService us;

    @PostMapping("/users/create")
    public UserData createUser(@RequestBody InputUserData ud) {
        return us.createUser(ud.name, ud.email);
    }

    @GetMapping("/users/id")
    public Optional<UserData> getUserById(@RequestParam long id) { return us.getUserById(id);  }

    @GetMapping("/users/all")
    public List<UserData> allUsers() {
        return us.getAll();
    }

    @PutMapping("/users/associate")
    public void associate(@RequestParam long feedback_id, @RequestParam long user_id) {
        fs.associate(feedback_id, user_id);
    }

    // ======================
    // == FILTER ENDPOINTS ==
    // ======================

    @Autowired FilterService fts;

    @GetMapping("/filter/{product}")
    public FilterData getFD(@PathVariable String product) {
        return fts.getForProduct(product);
    }

    @PostMapping("/filter")
    public FilterData upFD(@RequestBody FilterData fd) {
        return fts.updateFilterData(fd);
    }

}
