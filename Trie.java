
/**
 * Lab 2: Debugging with an IDE and Prefix Tree)
 * The program {@class} TrieNode creates a Trie: Prefix Tree with insert, search, and startsWith
 * Author: Paige Lekach
 * Updates to Comment
 * 
 */

class Trie {
	
	static final int ALPHABET_SIZE = 26;
	
	static class TrieNode {
  
	        TrieNode[] child = new TrieNode[ALPHABET_SIZE];
	        boolean isEndOfWord;
	        
	        TrieNode(){ 
				isEndOfWord = false; 
				for (int i = 0; i < ALPHABET_SIZE; i++) 
					child[i] = null; 
			}
	        
	    }
	
	
    /**
     * Root node of the Prefix Tree
     */	 
	static TrieNode root; 

    /**
	 * Inserts the letters into the Prefix tree from the Trie root node
	 * @param word Word to insert intro the prefix tree
	 */
    public static void insert(String word) {
		// TODO: Insert a new element to the Prefix Tree
		int wordLength = word.length();

		// Instance of the tree root
		TrieNode tempTrie = root;
		for( int i = 0; i < wordLength; i++){
			// Finding the actual indec of a letter in the word
			int charIndex = word.charAt(i) - 'a';
			//If the leaf off the child is null them insert the letter
			if(tempTrie.child[charIndex] == null){
				tempTrie.child[charIndex] = new TrieNode();
			}
			// new node
			tempTrie = tempTrie.child[charIndex];
			
		}
		//child now ends with a null i.e is the end of a word
		tempTrie.isEndOfWord = true;
        
    }
    
    /**
	 * Searches the prefix tree for the input word
	 * @param word The word to search for
	 * @return boolean true if the word exists in the tree
	 */
    public static boolean search(String word) {
		// TODO: Returns if the word is in the Prefix Tree
		int wordLength = word.length();
		TrieNode tempTrieNode = root;

		// Iterating through the tree to see if all the letters occur until a null leaf
		for(int i = 0; i < wordLength; i++){
			int trieIndex = word.charAt(i) - 'a';
			 if(tempTrieNode.child[trieIndex] == null){
				 return false;
			 }

			 tempTrieNode = tempTrieNode.child[trieIndex];
		}
		// If the current node iterated on is not null and is the end of a word then the word exists in the tree (true)
		boolean resultOfSearch = (tempTrieNode != null) && tempTrieNode.isEndOfWord;
		return resultOfSearch;
    }
    
   /**
	* Searches the Prefix Tree for the input characters, does not have to be the full word i.e. does not need to be the end of the word
	* @param prefix the chars to search for from the root node
	* @return
    */
    public static boolean startWith(String prefix) {
		// TODO: Returns if there is any word in the Prefix Tree that starts with the given prefix.
		int prefixLength = prefix.length();
		TrieNode tempTrieNode = root;
		// Iterates the tree and searches, if the iter. node is null then return false, otherwise if the iter node is not a null node then true
		for(int i = 0; i < prefixLength; i++){
			int trieIndex = prefix.charAt(i) - 'a';
			 if(tempTrieNode.child[trieIndex] == null){
				 return false;
			 }

			 tempTrieNode = tempTrieNode.child[trieIndex];
		}
		if(tempTrieNode == null){
			return false;
		}
	
    	return true;
    }

   
    
    
    public static void main(String args[]) 
	{ 
		
		String words[] = {"ece", "lab", "java", "jar", "car", 
						"cat", "care", "laboratory", "ebook"}; 
	
		String output[] = {"is NOT in the prefix tree", "is in the prefix tree"}; 
	
	
		root = new TrieNode(); 
	
		// Construct trie 
		int i; 
		for (i = 0; i < words.length ; i++) 
			insert(words[i]); 
	
		// Search for different keys 
		if(search("lab") == true) 
			System.out.println("lab --- " + output[1]); 
		else System.out.println("lab --- " + output[0]); 
		
		if(search("java") == true) 
			System.out.println("java --- " + output[1]); 
		else System.out.println("java --- " + output[0]); 
		
		if(startWith("eced") == true) 
			System.out.println("eced --- " + output[1]); 
		else System.out.println("eced --- " + output[0]); 
		
		if(startWith("ca") == true) 
			System.out.println("ca --- " + output[1]); 
		else System.out.println("ca --- " + output[0]); 
		
		if(search("book") == true) 
			System.out.println("book --- " + output[1]); 
		else System.out.println("book --- " + output[0]); 
		
	} 


}


