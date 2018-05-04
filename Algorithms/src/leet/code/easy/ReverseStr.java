package leet.code.easy;

public class ReverseStr {
	
	public void reverseString() {
	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    String reverseAlphabet = reverse(alphabet, alphabet.length()-1);
	}

	String reverse(String stringToReverse, int index){
	    if(index == 0){
	        return stringToReverse.charAt(0) + "";
	    }

	    char letter = stringToReverse.charAt(index);
	    return letter + reverse(stringToReverse, index-1);
	}
	
	public String reverseString(String s) {
		if(s == null || s.length() <= 1) return s;
		
        StringBuilder str = new StringBuilder(s);
        int len = s.length()/2;
        for(int i=0; i<=len; i++)
        {
            String temp = s.charAt(i) + "";
            str.replace(i, i+1, s.charAt(s.length() -1 -i)+"");
            str.replace(s.length() -1 -i,s.length() -i, temp);
            
        }
        
        return str.toString();
    }
	
	public String reverseStringBuilder(String s) {
		if(s == null || s.length() <= 1) return s;
		
        StringBuilder str = new StringBuilder(s);
        
        
        return str.reverse().toString();
    }
	
	public static String reverse(String input) {
		char[] in = input.toCharArray();
		int begin = 0;
		int end = in.length - 1;
		char temp;
		while (end > begin) {
			temp = in[begin];
			in[begin] = in[end];
			in[end] = temp;
			end--;
			begin++;
		}
		return new String(in);
	}

	public static void main(String[] args) {
		ReverseStr reverseStr = new ReverseStr();
		
		long starttime = System.nanoTime();
		System.out.println(ReverseStr.reverse(""));
		System.out.println(ReverseStr.reverse("a"));
		System.out.println(ReverseStr.reverse("ae"));
		
		System.out.println(ReverseStr.reverse("abde"));
		System.out.println(ReverseStr.reverse("abcde"));
		long endtime = System.nanoTime();
		System.out.println(endtime - starttime + " ***************");

		starttime = System.nanoTime();

		System.out.println(reverseStr.reverseString(""));
		System.out.println(reverseStr.reverseString("a"));
		System.out.println(reverseStr.reverseString("ae"));
		
		System.out.println(reverseStr.reverseString("abde"));
		System.out.println(reverseStr.reverseString("abcde"));
		endtime = System.nanoTime();
		System.out.println(endtime - starttime + " ***************");
		
		starttime = System.nanoTime();

	
		System.out.println(reverseStr.reverseStringBuilder(""));
		System.out.println(reverseStr.reverseStringBuilder("a"));
		System.out.println(reverseStr.reverseStringBuilder("ae"));
		
		System.out.println(reverseStr.reverseStringBuilder("abde"));
		System.out.println(reverseStr.reverseStringBuilder("abcde"));
		endtime = System.nanoTime();
		System.out.println(endtime - starttime + " ***************");

	}

}
