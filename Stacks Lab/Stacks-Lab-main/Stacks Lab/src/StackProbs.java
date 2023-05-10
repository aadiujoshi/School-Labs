import java.util.Stack;

public class StackProbs {
    public Stack<Integer> reverseStack(Stack<Integer> nums) {
        Stack<Integer> reversed = new Stack<>();
        while (!nums.isEmpty()) {
            reversed.push(nums.pop());
        }
        return reversed;
    }

    public Stack<Integer> doubleUp(Stack<Integer> nums) {
        Stack<Integer> doubled = new Stack<>();
        while (!nums.isEmpty()) {
            doubled.push(nums.peek());
            doubled.push(nums.pop());
        }
        return reverseStack(doubled);
    }

    public Stack<Integer> posAndNeg(Stack<Integer> stack) {
        Stack<Integer> positive = new Stack<>();
        Stack<Integer> negative = new Stack<>();

        while (!stack.isEmpty()) {
            if (stack.peek() < 0)
                negative.push(stack.pop());
            else
                positive.push(stack.pop());
        }
        while (!positive.isEmpty()) {
            negative.push(positive.pop());
        }
        return negative;
    }

    public Stack<Integer> shiftByN(Stack<Integer> stack, int n) {
        Stack<Integer> tempStack = new Stack<>();
        Stack<Integer> revAndComp = new Stack<>();
        while (stack.size() != n)
            tempStack.push(stack.pop());

        // reverse temp stack

        while (!tempStack.isEmpty())
            revAndComp.push(tempStack.pop());

        // set up elements you want shifted to top

        while (!stack.isEmpty())
            tempStack.push(stack.pop());

        // reverse top part
        while (!tempStack.isEmpty())
            revAndComp.push(tempStack.pop());

        return revAndComp;
    }

    public String reverseVowels(String str) {
        Stack<Character> vowels = new Stack<>();
        Stack<Character> string = new Stack<>();
        String s = "";
        for (int i = 0; i < str.length(); i++) {
            if (isVowel(str.charAt(i))) {
                vowels.push(str.charAt(i));
            }
            string.push(str.charAt(i));
        }

        // reverse string stack
        Stack<Character> temp = new Stack<>();
        while (!string.isEmpty())
            temp.push(string.pop());

        while (!temp.isEmpty()) {
            if (isVowel(temp.peek())) {
                s += vowels.pop();
                temp.pop();
            } else {
                s += temp.pop();
            }
        }
        return s;
    }
    private boolean isVowel(Character ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') ? true : false;
    }
    public boolean bracketBalance(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            } else if(
                    !stack.isEmpty() &&
                            s.charAt(i) == ')' && stack.peek() == '('||
                            s.charAt(i) == ']' && stack.peek() == '['
            ){
                stack.pop();
            } else return false;
        }
        return stack.isEmpty();
    }
}
