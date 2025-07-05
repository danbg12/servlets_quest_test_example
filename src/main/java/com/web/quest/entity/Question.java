package com.web.quest.entity;

import com.web.quest.repository.DataBase;
import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Question {

    private final Long QUESTION_TEXT_ID;
    @Getter
    private String questionText;
    private final Long ANSWER_TRUE_ID;
    @Getter
    private String answerTrue;
    private final Long ANSWER_FALSE_ID;
    @Getter
    private String answerFalse;
    private static final Logger logger = LoggerFactory.getLogger(Question.class);

    public Question(Long QUESTION_TEXT_ID, Long ANSWER_TRUE_ID, Long ANSWER_FALSE_ID , DataBase data) {

        logger.info("Creating new Question class");

        this.QUESTION_TEXT_ID = QUESTION_TEXT_ID;
        this.ANSWER_TRUE_ID = ANSWER_TRUE_ID;
        this.ANSWER_FALSE_ID = ANSWER_FALSE_ID;

        this.questionText = data.getTextForQuestions(QUESTION_TEXT_ID);
        this.answerTrue = data.getTextForQuestions(ANSWER_TRUE_ID);
        this.answerFalse = data.getTextForQuestions(ANSWER_FALSE_ID);

        logger.info("New Question class created");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;
        return new EqualsBuilder().append(QUESTION_TEXT_ID, question.QUESTION_TEXT_ID)
                .append(questionText, question.questionText)
                .append(ANSWER_TRUE_ID, question.ANSWER_TRUE_ID)
                .append(answerTrue, question.answerTrue)
                .append(ANSWER_FALSE_ID, question.ANSWER_FALSE_ID)
                .append(answerFalse, question.answerFalse)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(QUESTION_TEXT_ID)
                .append(questionText)
                .append(ANSWER_TRUE_ID)
                .append(answerTrue)
                .append(ANSWER_FALSE_ID)
                .append(answerFalse)
                .toHashCode();
    }
}
