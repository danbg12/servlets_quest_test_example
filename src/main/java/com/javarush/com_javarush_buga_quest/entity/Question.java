package com.javarush.com_javarush_buga_quest.entity;

import com.javarush.com_javarush_buga_quest.repository.DataBase;
import lombok.Getter;
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
}
