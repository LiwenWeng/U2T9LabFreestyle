public class Question {
    private int num1;
    private int num2;
    private String operator;
    private int answer;

    public Question(int difficulty) {
        num1 = (int) (Math.random() * (difficulty * 10 + 1));
        num2 = (int) (Math.random() * (difficulty * 10 + 1));
        operator = randomOperator();
        calculateAnswer();
    }

    private String randomOperator() {
        String[] operators = {"+", "-", "*"};
        int index = (int) (Math.random() * 3);
        return operators[index];
    }

    private void calculateAnswer() {
        switch (operator) {
            case "+":
                answer = num1 + num2;
                break;
            case "-":
                answer = num1 - num2;
                break;
            case "*":
                answer = num1 * num2;
                break;
        }
    }

    public String getQuestion() {
        return num1 + " " + operator + " " + num2 + " = ?";
    }

    public boolean checkAnswer(int userAnswer) {
        return answer == userAnswer;
    }
}
