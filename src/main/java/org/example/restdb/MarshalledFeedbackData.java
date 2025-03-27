package org.example.restdb;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * Feedback data with Jackson annotations and no ID in order to preserve wanted behavior
 * at each functional layer.
 */
public class MarshalledFeedbackData {
    @JsonProperty("product_name")
    public String productName;

    @JsonProperty("content")
    public String content;

    @JsonProperty("metadata")
    public Map<String, String> metaData;

    /*@JsonAnySetter
    public void add(String key, String value) {
        metaData.put(key, value);
    }*/

    public MarshalledFeedbackData(String productName, String content) {
        this.productName = productName;
        this.content = content;
        this.metaData = new HashMap<>();
    }

    public String getProductName() {
        return productName;
    }

    public String getContent() {
        return content;
    }
}
