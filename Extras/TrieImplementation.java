/*Prefix Tree: Tries

Implement a Word Dictionary:
add(word) - to add a word to the dictionary
search(word) - To find if given word exists in dictionary
Which data structure can be used to implement efficiently?
What are the time and space complexities for each operation?

To find a word in hash map:
If  N= number of word and L= Length of word
Time complexity is O(L) for searching a word.

We want to implement functionality
startsWith(prefix): To find if there is some which starts with a given prefix.
Also return if prefix itself is word.

Time complexity: O(N*L)
Which makes it a very complex operation!

Trie are extremely special and useful datastructure that are based on the prefix of a string.
Excellent in information reTRIEval or searching.
Trie is similiar to tree data structure . We will use TRIE to store collection of words.

Maximun number of children a node can have? -- 26 Alphabets- 26 nodes
Maximun depth of trie possible?  
*/
class TrieNode{

boolean isEnd;
TrieNode children[];
TrieNode()
{
   children = new TrieNode[26];
   isEnd= false;
 }
 }
 
public class Trie{

private static TrieNode root;
Trie()
{
//Initialise your data structure here
  root = new TrieNode();
}
   public static void insert(String word)
   {
   //inserts a word into the tree
      add(root, word);
	  
	}
	
	public static void add(TrieNode node, String word){
	{
	//base case
	if(word.length() == 0){
	 node.isEnd =true;
	 return;
	}
	
	int index= word.charAt(0)-'a';
	TrieNode child = node.children[index];
	if(child == null)
	    {
		  node.children[index] = new TrieNode();
		  child = node.children[index];
		 }
	//call the next step	 
	add(child , word.substring(1));
}

	public static boolean search(String node, String word){
	
	//base case
	if(word.length() == 0)
	return false;
	
	int index= word.charAt(0)-'a';
	TrieNode child = node.children[index];
	if(child == null)
	    return false;
		
	return search(child , word.substring(1));
	}
	
	public static boolean startsWith(String prefix){
	return startsWith(root , prefix);
	}
	public static boolean startsWith(TrieNode node, String word){
     	
	if(word.length() == 0)
	return true;
	
	int index= word.charAt(0)-'a';
	TrieNode child = node.children[index];
	if(child == null)
	    return false;
	return startsWith(child , word.substring(1));
	}
}
	
 
/*
HashMap VS Tries

>> For add(), search(), remove() the time complexity is same order for both.But in most cases
performance from tries is better in most cases as it reduces the overhead of finding the hash 
as it store repeated characters at same level only once.
>>For finding prefixe -> O(lengthOfPrefix)
>>Most common application of trie is Autocomplete. Some other applications include SpellChecker,
Pattern Matching etc.
>>Compressed tries, Suffix tries, etc
*/

