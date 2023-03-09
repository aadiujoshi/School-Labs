import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;


public class HuffmanTree {
    
    Node tree;

    String encoded_string;

    String str;

    public HuffmanTree(String filename){
        Scanner file;
        try {
            file = new Scanner(new File(filename));
            
            int treeSize = file.nextInt();
            
            tree = new Node("", -1);

            genTree(tree, file, new int0(0), treeSize);

            assign(tree, "", '0');

            encoded_string = file.nextLine();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String decode(Node treenode, String encoded_str){
        ArrayList<Node> _charMap = new ArrayList<>();
        getLeaves(treenode, _charMap);

        HashMap<String, Character> charmap = new HashMap<>();

        for (Node node : _charMap) {
            charmap.put(node.address.substring(0, node.address.length()-1), node.s.charAt(0));
        }

        System.out.println(charmap);

        String result = "";

        Scanner str = new Scanner(encoded_str);
        
        while(str.hasNext()){
            String _s = str.next();
            // System.out.println(_s);
            result += charmap.get(_s);
        }

        str.close();

        return result;
    }   

    private static class int0{
        int i;
        public int0(int _i) {i = _i;}
    }

    private void genTree(Node node, Scanner file, int0 numlines, int lineLimit){
        if(numlines.i >= lineLimit)
            return;
            
        System.out.print(numlines.i + "  ");

        numlines.i = (int)numlines.i + 1;

        String next = file.nextLine();
        
        System.out.println(next);

        if(!next.equals("")){
            node.s = (char)(Integer.parseInt(next, 2)) + "";
        } else {
            node.s = "";
        }

        // System.out.println(node.s + "   " + next.length());

        if(node.s != "")
            return;
        
        node.left = new Node("", -1);
        node.right = new Node("", -1);

        genTree(node.left, file, numlines, lineLimit);
        genTree(node.right, file, numlines, lineLimit);
    }

    private static final char LEFT = '0';
    private static final char RIGHT = '1';
    private void assign(Node node, String last, char dir){
        if(node == null)
            return;

        node.address = dir + last; 

        assign(node.left, node.address, LEFT);
        assign(node.right, node.address, RIGHT);
        
        node.address = node.address.substring(0, node.address.length()-1);
    }


    public HuffmanTree(int[] counts, String str){
        ArrayList<Node> nodes = new ArrayList<>();

        this.str = str;
        //init nodes in no particular order
        //not using priority queue since queue order can be lost when encoding
        for (int i = 0; i < counts.length; i++) {
            if(counts[i] == 0)
                continue;
                
            nodes.add(new Node(((char)i)+"", counts[i]));
        }

        while(nodes.size() != 1){
            Collections.sort(nodes);
            // System.out.println(nodes);

            //merge first 2 (least priority)
            Node n1 = nodes.get(0);
            Node n2 = nodes.get(1);

            Node n = new Node(n1.s + n2.s, n1.f + n2.f);

            n.left = n1;
            n.right = n2;

            nodes.remove(0);
            nodes.remove(0);

            nodes.add(0, n);
        }

        tree = nodes.get(0);

        assign(tree, "", '0');
    }

    //string wrapper lmao
    private static class String0{
        String s;
        public String0(String _s) {s = _s;}
    }

    public void encode(String filename){
        FileOutputStream out = null;

        /*
        ArrayList<Node> _charMap = new ArrayList<>();
        getLeaves(treenode, _charMap);

        HashMap<String, Character> charmap = new HashMap<>();

        for (Node node : _charMap) {
            charmap.put(node.address.substring(0, node.address.length()-1), node.s.charAt(0));
        }
         */

        try { 
            out = new FileOutputStream(filename); 
            
            String f = treeLength(tree) + "\n";

            //write tree, wrap reference string

            String0 wrap = new String0(f);

            treeToString(tree, wrap);

            f = wrap.s;

            //write encoded word
            ArrayList<Node> _charMap = new ArrayList<>();
            getLeaves(tree, _charMap);

            HashMap<Character, String> charmap = new HashMap<>();

            for (Node node : _charMap) {
                charmap.put(node.s.charAt(0), node.address);
            }
            
            for(int i = 0; i < str.length(); i++){
                System.out.println(charmap.get(str.charAt(i)) + "    sfdfdsa ");
                f += charmap.get(str.charAt(i)) + " ";
            }
            
            out.write(f.getBytes());
            out.close();
        } 
        catch (IOException e) { 
            e.printStackTrace(); 
        }

        // try { 
        //     out = new FileOutputStream(filename); 
            
        //     getLeaves(tree, leafs);
            
        //     String f = treeLength(tree) + "\n";

        //     //write tree, wrap reference string

        //     String0 wrap = new String0(f);

        //     treeToString(tree, wrap);

        //     f = wrap.s;

        //     // System.out.println(f);

        //     //write encoded word
        //     for (var node : leafs) {
        //         for (int i = 0; i < (int)node.f; i++) { 
        //             f += (String)node.address + " ";
        //         }
        //     }
            
        //     out.write(f.getBytes());
        //     out.close();
        // } 
        // catch (IOException e) { 
        //     e.printStackTrace(); 
        // }
    }

    private int treeCount;
    private int treeLength(Node node){
        treeCount = 1;
        treeLength0(node);
        
        int i = treeCount;
        treeCount = 1;

        return i;
    }

    private void treeLength0(Node node){
        if(node == null){
            return;
        }
        treeCount++;
        treeLength0(node.left);
        treeLength0(node.right);
    }

    private void treeToString(Node node, String0 str){
        if(node == null)
            return;

        if(node.s.length() == 1)
            str.s += Integer.toBinaryString((int)(node.s.charAt(0))) + "\n";
        else 
            str.s += "\n";

        // System.out.print("sdafdsa\n"  + str.s);

        treeToString(node.left, str);
        treeToString(node.right, str);
    }

    private void getLeaves(Node node, ArrayList<Node> charMap){
        if(node == null)
            return;

        if(node.s.length() == 1){
            charMap.add(node);
        }
        
        getLeaves(node.left, charMap);
        getLeaves(node.right, charMap);
    }
}
