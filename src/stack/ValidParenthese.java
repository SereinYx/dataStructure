package stack;

import java.util.Stack;

/**
 * @ClassName ValidParenthese
 * @Description leetCode No.20 有效的括号
 * @Author serein
 * @Date 2020-08-09 19:42
 */
public class ValidParenthese {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                char topCharacter = stack.pop();
                if ((topCharacter == '(' && c != ')') || (topCharacter == '[' && c != ']')
                        || (topCharacter == '{' && c != '}'))
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
