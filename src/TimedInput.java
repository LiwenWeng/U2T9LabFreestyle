import java.io.IOException;
import java.util.Scanner;

public class TimedInput {
    private int duration;
    private Scanner scanner;

    public TimedInput(int duration) {
        this.duration = duration * 1000;
        this.scanner = new Scanner(System.in);
    }

    public double start() {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime <= duration) {
            try {
                if (System.in.available() > 0) {
                    return scanner.nextDouble();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return -Integer.MAX_VALUE;
    }
}