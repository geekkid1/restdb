package org.example.restdb;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    String email;
    @OneToMany(mappedBy = "author")
    List<FeedbackData> feedbackData;

    public UserData(String name, String email) {
        this.name = name;
        this.email = email;
    }

}
