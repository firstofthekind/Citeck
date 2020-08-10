/*
Задача №2
Написать алгоритм проверки корректности регулярного выражения, которое включает [,],(,)
т.е., например ([][[]()]) - правильно, ([][]()]) – неправильно
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Brackets {
    private Stack<Character> stack = new Stack<Character>();

    private boolean isOpeningBracket(char bracket) {
        return "([".indexOf(bracket) != -1;
    }

    private boolean isClosingBracket(char bracket) {
        return ")]".indexOf(bracket) != -1;
    }

    private boolean isPair(char opening, char closing) {
        return opening == '(' && closing == ')' || opening == '['
                && closing == ']';
    }

    public boolean validate(String input) {
        for (char c : input.toCharArray()) {
            if (isClosingBracket(c) && stack.isEmpty()) {
                return false;
            }
            if (isOpeningBracket(c)) {
                stack.push(c);
            }
            if (isClosingBracket(c)) {
                if (isPair(stack.peek(), c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Brackets brVal = new Brackets();
        System.out.println("Скобки расставлены " + (brVal.validate(reader.readLine()) ? "" : "не") + "правильно");
    }
}

