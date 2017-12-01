import java.util.ArrayList;
import java.util.Collections;

public class CaptchaChecker {
    private ArrayList<Integer> numbers;

    public CaptchaChecker() {

    }

    public CaptchaChecker(String input) {
        this.setInput(input);
    }

    public void setInput(String input) {
        numbers = new ArrayList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            numbers.add(Character.getNumericValue(input.charAt(i)));
        }
    }

    private ArrayList<Integer> switchList() {
        Collections.rotate(numbers, -1);
        return numbers;
    }

    public int getAnswer() {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            Integer firstDigit = numbers.get(0);
            Integer SecondDigit = numbers.get(1);
            if (firstDigit == SecondDigit) {
                sum += firstDigit;
            }
            numbers = this.switchList();
        }
        return sum;
    }
}
