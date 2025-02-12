package com.javarush.com_javarush_buga_quest.repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class DataBase {

    private static DataBase instance;
    private final Map<Long , String> textsForQuestionsAndAnswers = new HashMap<>();
    private final Map<String , String> otherTexts = new HashMap<>();
    private static final Logger log = LoggerFactory.getLogger(DataBase.class);

    private DataBase() {
        log.info("DataBase start maps initialization");

        textsForQuestionsAndAnswers.put(1L, "Ты оказался на звездолете. Готов начать испытание?");
        textsForQuestionsAndAnswers.put(11L , "Начать испытание.");
        textsForQuestionsAndAnswers.put(12L , "Отказаться от испытания.");
        textsForQuestionsAndAnswers.put(2L , "Какого цвета мастер Йода?");
        textsForQuestionsAndAnswers.put(21L , "Он зеленыи.");
        textsForQuestionsAndAnswers.put(22L , "Он цвета баклажана.");
        textsForQuestionsAndAnswers.put(3L , "Чеи отец Дарт Веидер?");
        textsForQuestionsAndAnswers.put(31L , "Люка Скаиуокера");
        textsForQuestionsAndAnswers.put(32L , "Люка от Лада Веста");

        otherTexts.put("win1" , "Поздравляю! Ты настоящий знаток, юный падаван!");
        otherTexts.put("win2" , "Это победа!");
        otherTexts.put("lose1" , "Ты должен был сражаться со злом, а не примкнуть к нему!");
        otherTexts.put("lose2" , "Это фиаско братан!");

        log.info("DataBase maps initialization is finished");
    }

    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
            log.info("DataBase new instance created");
        }
        log.info("DataBase instance returned");
        return instance;
    }

    public String getTextForQuestions(Long id) {
        log.info("DataBase getTextForQuestions method called");
        return textsForQuestionsAndAnswers.get(id);
    }

    public String getOtherText(String text) {
        log.info("DataBase getOtherText method called");
        return otherTexts.get(text);
    }
}
