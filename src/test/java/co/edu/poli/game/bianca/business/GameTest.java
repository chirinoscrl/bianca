package co.edu.poli.game.bianca.business;

import co.edu.poli.game.bianca.model.Answer;
import co.edu.poli.game.bianca.model.Choice;
import co.edu.poli.game.bianca.model.Question;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {

    @Test
    void shouldStartGame() {
        // Act
        Game game = new Game();

        // Assert
        List<Question> questions = game.getQuestions();
        assertEquals(3, questions.size());

        for (Question question : questions) {
            assertNotNull(question.getStatement());
            assertEquals(4, question.getChoices().size());
            int numberCorrectChoices = 0;
            for (Choice choice : question.getChoices()) {
                assertNotNull(choice.getImage());
                if (choice.isCorrect()) {
                    numberCorrectChoices++;
                }
            }
            assertEquals(1, numberCorrectChoices);
        }
    }

    @Test
    void shouldValidateAnswer() {
        // Act
        Game game = new Game();
        Question question = game.nextQuestion();
        Choice choiceCorrect = question.getAnswerCorrect().orElseThrow();

        Optional<Choice> found = Optional.empty();
        for (Choice choice : question.getChoices()) {
            if (choice.getCode() != choiceCorrect.getCode()) {
                found = Optional.of(choice);
                break;
            }
        }
        Choice choiceIncorrect = found.orElseThrow();

        boolean isCorrect = game.validateAnswer(question, choiceCorrect);
        boolean isIncorrect = game.validateAnswer(question, choiceIncorrect);

        // Assert
        assertTrue(isCorrect);
        assertFalse(isIncorrect);
    }

    @Test
    void shouldFollowingQuestion() {
        // Act
        Game game = new Game();
        Question firstQuestion = game.nextQuestion();
        game.nextQuestion();
        game.nextQuestion();
        Question questionNull = game.nextQuestion();

        // Assert
        assertNotNull(firstQuestion);
        assertNull(questionNull);
    }

    @Test
    void shouldGetAllQuestionsAndAnswers() {
        // Act
        Game game = new Game();
        Question first = game.nextQuestion();
        game.validateAnswer(first, first.getChoices().get(1));
        Question second = game.nextQuestion();
        game.validateAnswer(second, second.getChoices().get(1));
        Question third = game.nextQuestion();
        game.validateAnswer(third, third.getChoices().get(1));

        // Assert
        List<Answer> answers = game.getAnswers();
        assertEquals(3, answers.size());
    }
}