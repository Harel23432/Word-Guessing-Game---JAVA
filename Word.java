package project2;

public class Word {

	    String data;
	    Word (String d){
	        this.data = d;
	    }
	    public int compareTo(Word other){
	        int value = data.compareToIgnoreCase(other.data);
	        return value;
	    }
	}

