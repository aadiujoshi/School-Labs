import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueProbs {

    public Queue<Integer> evenFirst(Queue<Integer> nums) {
        Queue<Integer> even = new LinkedList<Integer>();
        Queue<Integer> odd = new LinkedList<Integer>();

        while (!nums.isEmpty()) {
            if (nums.peek() % 2 == 0) {
                even.offer(nums.poll());
            } else {
                odd.offer(nums.poll());
            }
        }
        while (!odd.isEmpty()) {
            even.offer(odd.poll());
        }
        return even;

    }

    public boolean numPalindrome(Queue<Integer> nums) {
        int size = nums.size();
        int i = 0;
        Queue<Integer> first = new LinkedList<Integer>();
        while (i != size / 2) {
            first.offer(nums.poll());
            i++;
        }
        if (size % 2 != 0)
            nums.poll();

        Stack<Integer> stack = new Stack<>();
        while (!nums.isEmpty()) {
            stack.add(nums.peek());
            nums.remove();
        }
        while (!stack.isEmpty()) {
            nums.add(stack.peek());
            stack.pop();
        }

        return first.equals(nums);
    }
    // yesterday today tommorow

    public Stack<Integer> sieveOfEratosthenes(int n) {
        Queue<Integer> fill = new LinkedList<Integer>();
        Stack<Integer> prime = new Stack<>();
        for (int i = 2; i <= n; i++) {
            fill.offer(i);
        }

        while (!fill.isEmpty()){
            prime.push(fill.poll());
            int num = prime.peek();
            Queue<Integer> copy = fill;
            Queue<Integer> temp = new LinkedList<>();
            while(!copy.isEmpty()){
                if(copy.peek() % num == 0) copy.remove();
                else{
                    temp.offer(copy.poll());
                }
                fill = temp;
            }

        }
        return prime; 
            
    }
}