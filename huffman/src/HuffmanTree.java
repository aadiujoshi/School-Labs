import java.util.ArrayList;
import java.util.Collections;


public class HuffmanTree {
    
    Node tree;

    public HuffmanTree(int[] counts){
        ArrayList<Node> nodes = new ArrayList<>();

        //init nodes in no particular order
        //not using priority queue since queue order can be lost when encoding
        for (int i = 0; i < counts.length; i++) {
            if(counts[i] == 0)
                continue;
                
            nodes.add(new Node(((char)i)+"", counts[i]));
        }
        
        while(nodes.size() != 1){
            Collections.sort(nodes);
            System.out.println(nodes);

            //merge first 2 (least priority)
            Node n1 = nodes.get(0);
            Node n2 = nodes.get(1);

            Node n = new Node(n1.s + n2.s, n1.f + n2.f);

            nodes.remove(0);
            nodes.remove(0);

            nodes.add(0, n);
        }

        System.out.println(nodes);
    }

    public static void encode(BitOutputStream stream, String filename){
        
    }
}
