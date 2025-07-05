package com.web.quest.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
class DataBaseTest {

    DataBase instance = DataBase.getInstance();
    private static final Logger log = LoggerFactory.getLogger(DataBaseTest.class);

    @Test
    @Timeout(value = 5 , unit = TimeUnit.MILLISECONDS)
    void getInstanceForDataBase() {
        log.debug("Start getInstanceForDataBase test");
        assertEquals(instance, DataBase.getInstance());
    }

    @Test
    @Timeout(value = 10 , unit = TimeUnit.MILLISECONDS)
    void getTextForQuestions() {
        log.debug("Start getTextForQuestions test");
        String resultOne = instance.getTextForQuestions(11L);
        String resultTwo = instance.getTextForQuestions(21L);
        String resultThree = instance.getTextForQuestions(32L);

        assertEquals("Начать испытание.", resultOne);
        assertEquals("Он зеленыи.", resultTwo);
        assertEquals("Люка от Лада Веста" , resultThree);
    }

    @Test
    @Timeout(value = 10 , unit = TimeUnit.MILLISECONDS)
    void getOtherTextFromMap() {
        log.debug("Start getOtherTextFromMap test");
        String resultOne = instance.getOtherText("win2");
        String resultTwo = instance.getOtherText("lose2");

        assertEquals("Это победа!" , resultOne);
        assertEquals("Это фиаско братан!" , resultTwo);
    }
}