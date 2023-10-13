public class Question {
    private int num1;
    private int num2;
    private String operator;
    private int answer;

    public Question(int difficulty) {
        num1 = (int) (Math.random() * (Math.pow(10, difficulty) * 2 + 1) - Math.pow(10, difficulty));
        num2 = (int) (Math.random() * (Math.pow(10, difficulty) * 2 + 1) - Math.pow(10, difficulty));
        operator = randomOperator();
        calculateAnswer();
    }

    private String randomOperator() {
        String[] operators = {"+", "-", "*", "| |"};
        int index = (int) (Math.random() * 4);
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
            case "| |":
                answer = Math.abs(num1);
                break;
        }
    }

    public String getQuestion() {
        if (operator.equals("| |")) {
            return "| " + num1 + " |";
        } else {
            return num1 + " " + operator + " " + num2 + " = ?";
        }
    }

    public int getAnswer() {
        return answer;
    }

    public String checkAnswer(double userAnswer) {
        if (userAnswer == -Integer.MAX_VALUE) return "late";
        return answer == userAnswer ? "true" : "false";
    }
}
