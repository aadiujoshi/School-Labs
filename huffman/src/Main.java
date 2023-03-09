import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //----------------------------------------------------------------------------
        Scanner input = new Scanner(System.in);

        String s = input.nextLine();
    
        int[] count = toCharMap(s);

        //----------------------------------------------------------------------------


//         HuffmanTree tree = new HuffmanTree(count, s);
//         tree.encode("out.txt");

        HuffmanTree tree = new HuffmanTree("out.txt");

        System.out.println("\n" + tree.encoded_string + "\n");
        System.out.println(tree.decode(tree.tree, tree.encoded_string));

        input.close();
    }

    public static int[] toCharMap(String s){
        int[] count = new int[256];

        for (int i = 0; i < s.length(); i++) {
            count[((int)s.charAt(i))]++;
        }

        return count;
    }
}
