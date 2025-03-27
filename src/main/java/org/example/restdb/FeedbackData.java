package org.example.restdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

/**
 * "Specified" FeedbackData class that adds an id. Can't extend GeneralizedFeedbackData
 * because I needed to annotate metaData with @ElementCollection to make it work with JPA.
 */
@Entity
public class FeedbackData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @JsonProperty("product_name")
    String productName;
    String content;
    @JsonProperty("metadata")
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
