public class Node implements Comparable<Node> {
    Node left, right;
    String s;
    int f;

    public Node(String c, int f) {this.s = c; this.f = f;}

    @Override
    public int compareTo(Node n) {
        if(n.f != f){
            if(n.f > f)
                return -0xBEEF;
            else 
                return 0xBEEF;
        }

        return 0;
    }

    public String toString(){
        return "[" + s + ", " + f + "]";
    }
}
