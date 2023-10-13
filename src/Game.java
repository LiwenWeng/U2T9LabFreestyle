import java.util.Scanner;

public class Game {
    private int difficulty;
    private int score = 0;
    private int timer;
    private int numberOfQuestions;

    public void start() {
        System.out.print("Choose a difficulty(1-3): ");
        Scanner scanner = new Scanner(System.in);
        difficulty = scanner.nextInt();
        numberOfQuestions = difficulty * 5;
        timer = 10 + difficulty * 2;

        for (int i = 0; i < numberOfQuestions; i++) {
            System.out.println();
            Question question = new Question(difficulty);
            System.out.println("Question " + (i + 1) + ": " + question.getQuestion());
            System.out.print("Answer: ");

            TimedInput input = new TimedInput(timer);
            double answer = input.start();

            if (question.checkAnswer(answer).equals("true")) {
                System.out.println("Correct!");
                score++;
            } else if (question.checkAnswer(answer).equals("false")) {
                System.out.println("Wrong! The correct answer is: " + question.getAnswer());
            } else {
                System.out.println("\nTime's up! No input received.");
            }
        }
        System.out.println("Game Over. Your score is: " + score);
    }
}
