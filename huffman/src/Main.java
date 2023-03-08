import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String s = input.next();
    

        int[] count = new int[256];

        for (int i = 0; i < s.length(); i++) {
            count[((int)s.charAt(i))]++;
        }

        HuffmanTree tree = new HuffmanTree(count);

        input.close();
    }
}
