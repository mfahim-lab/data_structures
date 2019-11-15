package hashtables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PracticeExam2 {
	
	//part 6 is coding on Pactice Exam
	
	private static class Node<E> {
		E item;
		Node<E> left;
		Node<E> right;
		
		public Node(E item){
			this.item = item;
			
		}
	}
	
	
	
	//you will have two tree coding questions make sure you are ready!
	//the second part will have a bold sentance
	
	//#16 
	public static <E> int sizeTree(Node<E> root) { //this is recursion
		if(root == null){ //basecase
			return 0;
		} 
		//we have root + subtrees
		int left = sizeTree(root.left);
		int right = sizeTree(root.right);
		
		return left + right;
	}
	
	
	
	//#17 
	public static <E> boolean isFull(Node<E> tree) { //this is recursion
		if(tree == null){ //basecase
			return true; //technically full tho
		}
		//a couple basecases here
		if(tree.left == null && tree.right == null){
			return true; //if i have no children then i am a full tree
		} else if(tree.left != null && tree.right == null){
			return false; 
		} else if(tree.left == null && tree.right != null){
			return false; 
		} else {
			return isFull(tree.left) && isFull(tree.right);
		}
			
	}
	
	//#18 extra-practice is a step above, wont be on exam
	
	public static <E> boolean equals(Node<E> treeA, Node<E> treeB) { //this is recursion
	
		if(treeA == null && treeB == null){
			return true;
		} else if(treeA != null && treeB == null){
			return false;
		} else if(treeA == null && treeB != null){
			return false;
		} else {
			if(treeA.item.equals(treeB.item)){
				return equals(treeA.left, treeB.left) && equals(treeA.left, treeB.left);
			}
			
			return false;
		}
	}
	
	
	//#19
	public static Map<Character, Integer> count(String word){
		//dont put the interface use 
		Map<Character, Integer> counts = new HashMap<>(); 
		//hashmaps are constant time data structs
		
		//maptrees are constant times but they use binary trees for sorting as opposed to rando
		
		
		
		//make sure you use .toCharArray()
		for(char letter : word.toCharArray()){
			if(!counts.containsKey(letter)){
				counts.put(letter, 1);
			} else {
				counts.put(letter, counts.get(letter) + 1);
			}
			
		}
		
		
		return counts;
	}
	
	public static Map<Integer, List<Integer>> splitNumbersByFactors(int [] arr){
		
		Map<Integer, List<Integer>> categories = new HashMap<>();
		
		categories.put(2,  new ArrayList<>());
		categories.put(3,  new ArrayList<>());
		categories.put(5,  new ArrayList<>());
		
		
		
		for(int x : arr){
			if(x%2 == 0){
				categories.get(2).add(x);
			} if(x%3 == 0){
				categories.get(3).add(x);
			} if(x%5 == 0){
				categories.get(5).add(x);
			} 
		
		}
		
		
		return categories;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
	}

}
