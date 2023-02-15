import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class BinPacking {
    class Disk implements Comparable<Disk>{
        ArrayList<Integer> files;
        int id;
        int remspace = 1000000;

        public Disk(int id) {this.id = id;}
        
        @Override
        public int compareTo(BinPacking.Disk d) {
            if(d.id == id){ return 0; }
            return this.remspace < d.remspace ? 1 : 2; 
        }
    }

    public static void hello(){
        System.out.println("hello");
    }

    public static void main(String[] args) throws Exception {
        
    }
}
