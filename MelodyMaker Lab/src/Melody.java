import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class Melody {
    Queue<Note> notes;

    public Melody(Queue<Note> song) {
        notes = new LinkedList<>();
        while (!song.isEmpty()) {
            notes.offer(song.poll());
        }
    }

    public double getTotalDuration() {
        double dub = 0;
        Queue<Note> temp = new LinkedList<>();
        boolean tempbool = false;
        while (!notes.isEmpty()) {
            if (notes.peek().isRepeat())
                tempbool = !tempbool;
            if (tempbool || notes.peek().isRepeat())
                dub += notes.peek().getDuration();
            dub += notes.peek().getDuration();
            temp.offer(notes.poll());
        }
        while (!temp.isEmpty())
            notes.offer(temp.poll());

        return dub;

    }

    public String toString() {
        String ret = "";
        while (!notes.isEmpty()) {
            ret += notes.poll().toString() + "\n";
        }
        return ret;
    }

    public void changeTempo(double tempo) {
        Queue<Note> temp = new LinkedList<>();
        while (!notes.isEmpty()) {
            Note first = notes.poll();
            first.setDuration(first.getDuration() * tempo);
            temp.offer(first);
        }
        notes = temp;
    }

    public void reverse() {
        Stack<Note> temp = new Stack<>();
        while (!notes.isEmpty()) {
            temp.push(notes.poll());
        }
        Queue<Note> temp1 = new LinkedList<>();
        while (!temp.isEmpty()) {
            temp1.offer(temp.pop());
        }
        notes = temp1;

    }

    public void append(Melody other) {
        while (!other.getNotes().isEmpty()) {
            notes.offer(other.getNotes().poll());
        }
    }

    public void play() {
        Queue<Note> played = new LinkedList<>();
        Queue<Note> repeat = new LinkedList<>();
        while (!notes.isEmpty()) {
            notes.peek().play();
            if (notes.peek().isRepeat()) {
                repeat.offer(notes.peek());
                if (repeat.size() > 1) {
                    while (!repeat.isEmpty())
                        repeat.poll().play();

                }
            }
            played.offer(notes.poll());
        }
        while (!played.isEmpty())
            notes.offer(played.poll());

    }

    public Queue<Note> getNotes() {
        return notes;
    }

}