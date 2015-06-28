package lib;

public class LowLevelLib {

	public String rev(String s){
		return new StringBuilder(s).reverse().toString();
	}
	
    public String replaceChar(String str, int index, int val){
    	StringBuffer sb = new StringBuffer(str);
    	char ch = String.valueOf(val).charAt(0);
    	sb.setCharAt(index, ch);
    	return sb.toString();
    }
    
    public char intToChar(int input){//only one digit, just to memo 48
    	return (char)(input+48);
    }

}
