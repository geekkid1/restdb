package org.example.restdb;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FeedbackData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String productName;
    String content;

    public FeedbackData() {}
    public FeedbackData(String pn, String c) {
        //this.id = id;
        productName = pn;
        content = c;
    }
}
