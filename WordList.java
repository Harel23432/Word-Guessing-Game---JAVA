package project2;

public class WordList {

	    protected WordNode first;
	    protected WordNode last;
	    protected int length;

	    public WordList () {
	        WordNode ln = new WordNode();
	        first = ln;
	        last = ln;
	        length = 0;
	    }

	    public void append (Word s) {
	        WordNode n = new WordNode(s);
	        last.next = n;
	        last = n;
	        length++;
	    }
	}
