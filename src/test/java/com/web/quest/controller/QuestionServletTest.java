package com.web.quest.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import static org.mockito.Mockito.verify;

class QuestionServletTest {

    QuestionServlet questionServlet;
    HttpServletRequest httpServletRequest;
    HttpServletResponse httpServletResponse;
    HttpSession httpSession;
    RequestDispatcher requestDispatcher;
    private static final Logger logger = LoggerFactory.getLogger(QuestionServletTest.class);

    @BeforeEach
    void setUp() {

        logger.info("Setting up question servlet");

        questionServlet = new QuestionServlet();
        httpServletRequest = Mockito.mock(HttpServletRequest.class);
        httpServletResponse = Mockito.mock(HttpServletResponse.class);
        httpSession = Mockito.mock(HttpSession.class);
        requestDispatcher = Mockito.mock(RequestDispatcher.class);

        Mockito.when(httpServletRequest.getSession()).thenReturn(httpSession);
        Mockito.when(httpServletRequest.getRequestDispatcher("questionPage.jsp")).thenReturn(requestDispatcher);
    }

    @Test
    void doGetQuestionTest() throws ServletException, IOException {

        logger.info("Test doGetQuestionTest is started.");

        Mockito.when(httpServletRequest.getParameter("id")).thenReturn(null);
        Mockito.when(httpServletRequest.getParameter("username")).thenReturn("Dan");

        questionServlet.doGet(httpServletRequest, httpServletResponse);

        verify(httpSession).setAttribute("username" , "Dan");
        verify(httpServletRequest).setAttribute("nextIndex" , 1 );
        verify(requestDispatcher).forward(httpServletRequest , httpServletResponse);

    }
}