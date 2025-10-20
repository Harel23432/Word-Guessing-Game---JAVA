package project2;



public class WordNode {

	protected Word data ;
	protected WordNode next ;

	public WordNode(Word data, WordNode next)  {
		this.data = data;
		this.next = next;
	}  // constructor

	public WordNode()  {
		this.data = null;
		this.next = null;
	}  // constructor

	public WordNode(Word data)  {
		this.data = data;
		this.next = null;
	}  // constructor
}


