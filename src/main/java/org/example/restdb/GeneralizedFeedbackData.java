package org.example.restdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * Feedback data with Jackson annotations and no ID in order to preserve wanted behavior
 * at each functional layer.
 */
@Getter
@NoArgsConstructor
public class GeneralizedFeedbackData {
    @JsonProperty("product_name")
    public String productName;

    @JsonProperty("content")
    public String content;

    @JsonProperty("metadata")
    public Map<String, String> metaData;

    public GeneralizedFeedbackData(String productName, String content) {
        this.productName = productName;
        this.content = content;
        this.metaData = new HashMap<>();
    }
}
