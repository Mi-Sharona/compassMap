package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAndAnswer {

    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name="question_id")
    private Question question;
    @ManyToOne
    @JoinColumn(name="answer_id")
    private Answer answer;
    private Double scoreContribution;
}
