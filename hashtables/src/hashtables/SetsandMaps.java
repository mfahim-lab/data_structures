package hashtables;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetsandMaps {

	/*4 set methods from lecture video, can't retrieve info from sets, just see if present 
	addAll,
	removeAll,
	(boolean return, compares two sets)->conatinsAll, 
	(intersection, keep items only in both)->retainAll;
	
	you can iterate through members of a set using the iterator method
	for(String nextItem : setA){//dosomethinghere };
	it works but it will be accessed arbitrarily 
	its the ultimate checklist
	*/
	
	  public static <E> boolean unique(List<E> list){

	        Set<E> checklist = new HashSet<>();
	        for (E item : list) {
	            if(checklist.add(item)){
	            	return true;
	            }
	        }

	        return false;
	    }
	        
	  /*
	   * Maps have two sets, keySet and valueSet 
	   * both are unique, but maps can have many-to-one mapping
	   * so different key values can point to the same value, but not vice versa
	   * 
	   * It has methods in the form, keys are unique IDs and can be assigned like indexes
	   * V.get (Object key)
	   * V.put(K key, V Value);
	   * V.remove(Object key);
	   * boolean isEmpty();
	   * int size();
	   */
	  
	  
	  /*
	   * For hash maps you need put, get, and remove methods
	   * Look at rosen's constructors, theres a good amount
	   * 
	   */
	
	
	public static void main(String[] args) {
		
		
		

	}

}
