package org.example.restdb;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface FeedbackRepository extends CrudRepository<FeedbackData, Long> {
    List<FeedbackData> findByProductName(String productName);
    List<FeedbackData> findByContent(String content);

    @Query("select f from FeedbackData f where f.metaData['date'] = :date")
    List<FeedbackData> findByDate(String date);

    @Query("UPDATE FeedbackData SET author=:uid WHERE id=:id")
    void associate(long id, long uid);

    @Transactional
    @Modifying(flushAutomatically = true)
    @Query("UPDATE FeedbackData SET author=:author WHERE id=:id")
    void updateAuthorById(long id, UserData author);

}
