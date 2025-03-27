package org.example.restdb;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

@Entity
public class FeedbackData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String productName;
    String content;
    @ElementCollection
    Map<String,String> metaData;

    public FeedbackData() {}
    public FeedbackData(String pn, String c, Map<String,String> md) {
        //this.id = id;
        productName = pn;
        content = c;
        metaData = md;
    }
    public long getId() {
        return id;
    }
    public String getProductName() {
        return productName;
    }
    public String getContent() {
        return content;
    }
    public Map<String,String> getMetaData() {
        return metaData;
    }
}
