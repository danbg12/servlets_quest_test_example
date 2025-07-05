package com.web.quest.controller;

import com.web.quest.entity.Question;
import com.web.quest.repository.DataBase;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "questionServlet" , value = "/question-servlet")
public class QuestionServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(QuestionServlet.class);
    public List<Question> questionEntities = List.of(
            new Question(1L , 11L , 12L , DataBase.getInstance()) ,
            new Question(2L , 21L , 22L , DataBase.getInstance()) ,
            new Question(3L , 31L , 32L , DataBase.getInstance())
    );

    @Override
    public void init(ServletConfig config) throws ServletException {
        logger.info(QuestionServlet.class.getSimpleName() + " is successfully initialized.");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        logger.info(QuestionServlet.class.getSimpleName() + " method doGet started");

        String parameter = request.getParameter("id");
        String username = request.getParameter("username");
        int questionIndex = parameter == null ? 0 : Integer.parseInt(parameter);

        try {
            request.getSession().setAttribute("username", username);
            request.setAttribute("question" , questionEntities.get(questionIndex));
            request.setAttribute("nextIndex" , questionIndex < questionEntities.size() - 1 ? questionIndex + 1 : null);
            request.getRequestDispatcher("questionPage.jsp").forward(request , response);

        } catch (ServletException | IOException e) {
            logger.error("Something wrong with " + QuestionServlet.class.getSimpleName() + " servlet.");
            throw new RuntimeException(e);
        }

    }
}
