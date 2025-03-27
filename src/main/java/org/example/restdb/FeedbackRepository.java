package org.example.restdb;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FeedbackRepository extends CrudRepository<FeedbackData, Long> {
    List<FeedbackData> findByProductName(String productName);
    List<FeedbackData> findByContent(String content);

    @Query("select f from FeedbackData f where :date member of f.metaData")
    List<FeedbackData> findByDate(String date);
}
