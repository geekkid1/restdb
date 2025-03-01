package org.example.restdb;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FeedbackData {
    @Id
    long id;
    String productName;
    String content;

    public FeedbackData() {}
    public FeedbackData(long id, String pn, String c) {
        this.id = id;
        productName = pn;
        content = c;
    }
}
