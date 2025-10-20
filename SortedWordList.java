package project2;

public class SortedWordList extends WordList {
	public SortedWordList(){
		super();
	}



	public void add(Word w) {
		if (length == 0) {
			append(w);
		}
		WordNode new_node = new WordNode(w);
		WordNode curr = first;
		//while(true){
		while (curr.next != null && new_node.data.data.compareTo(curr.next.data.data) < 0) {
			//new_node.next = curr.next;
			//curr.next = new_node;
			curr = curr.next;

		}
		new_node.next = curr.next;
		curr.next = new_node;
		//else if (curr.next == null){
		//  append(w);
		//}
		//else {
		//  curr = curr.next;
		//}
		if(new_node.next == null){
			last = new_node;
		}
		length++;
	}
}


