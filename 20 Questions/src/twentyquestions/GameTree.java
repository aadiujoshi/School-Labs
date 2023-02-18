package twentyquestions;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * A model for the game of 20 questions
 *
 * @author Rick Mercer
 */
public class GameTree
{
	public class Node{
		Node left, right;
		String inf;
		public Node(String inf) { this.inf = inf; }
	}

	private Node root;
	private Node cur;

	private String fileName;

	private PrintStream print;
	private PrintStream file;

	/**
	 * Constructor needed to create the game.
	 *
	 * @param fileName
	 *          this is the name of the file we need to import the game questions
	 *          and answers from.
	 */
	public GameTree(String fileName) {
		this.fileName = fileName;

		Scanner file = null;

		try { file = new Scanner(new File(fileName)); } 
		catch (FileNotFoundException e) { e.printStackTrace(); }
		
		Queue<String> q = new LinkedList<String>();
		while(file.hasNextLine())
			q.add(file.nextLine());

		this.root = new Node("");

		fill(root, q); 
		
		try {
			this.print = new PrintStream("vis.txt"); 
			print.write(new byte[]{});
			this.file = new PrintStream(fileName); 

		} catch (IOException e) { e.printStackTrace(); }

		print(root, 0, print, " ");

		this.cur = root;
	}
	
	private void print(Node node, int depth, PrintStream print, String split){
		for (int i = 0; i < depth; i++) { print.print(split); }

		print.println(node.inf);

		if(node.left != null){
			print(node.left, depth+1, print, split);
		} 
		if(node.right != null){
			print(node.right, depth+1, print, split);
		}
	}

	private void fill(Node node, Queue<String> file){
		if(file.isEmpty()){
			return;
		}

		String s = file.poll();

		node.inf = s;

		if(s.contains("A:")){
			return;
		}

		node.left = new Node("");
		node.right = new Node("");

		fill(node.left, file);
		fill(node.right, file);
	}

	/*
	 * Add a new question and answer to the currentNode. If the current node has
	 * the answer chicken, theGame.add("Does it swim?", "goose"); should change
	 * that node like this:
	 */
	// -----------Feathers?-----------------Feathers?------
	// -------------/----\------------------/-------\------
	// ------- chicken  horse-----Does it swim?-----horse--
	// -----------------------------/------\---------------
	// --------------------------goose--chicken-----------
	/**
	 * @param newQ
	 *          The question to add where the old answer was.
	 * @param newA
	 *          The new Yes answer for the new question.
	 */
	public void add(String newQ, String newA) {
		String oldInf = cur.inf;
		cur.inf = "Q:" + newQ;
		cur.left = new Node("A:" + newA);
		cur.right = new Node(oldInf);
	}

	/**
	 * True if getCurrent() returns an answer rather than a question.
	 *
	 * @return False if the current node is an internal node rather than an answer
	 *         at a leaf.
	 */
	public boolean foundAnswer() {
		return !getCurrent().contains("?");
	}

	/**
	 * Return the data for the current node, which could be a question or an
	 * answer.  Current will change based on the users progress through the game.
	 *
	 * @return The current question or answer.
	 */
	public String getCurrent(){
		return cur.inf;
	}

	/**
	 * Ask the game to update the current node by going left for Choice.yes or
	 * right for Choice.no Example code: theGame.playerSelected(Choice.Yes); 	
	 *
	 * @param c
	 */
	public void playerSelected(Choice c) {
		if(c == Choice.Yes){
			cur = cur.left;
		} else {
			cur = cur.right;
		}
	}

	/**
	 * Begin a game at the root of the tree. getCurrent should return the question
	 * at the root of this GameTree.
	 */
	public void restart() {
		cur = root;
	}

	@Override
	public String toString() {
		return "";
		// ByteArrayOutputStream ba = new ByteArrayOutputStream();
		// PrintStream out = new PrintStream(ba);
		// print(root, 0, out, "  ");
		// return new String(ba.toByteArray(), StandardCharsets.UTF_8);
	}

	/**
	 * Overwrite the old file for this gameTree with the current state that may
	 * have new questions added since the game started.
	 *
	 */
	public void saveGame() {
		file.writeBytes(new byte[]{});
		print(root, 0, file, "");
	}
}
