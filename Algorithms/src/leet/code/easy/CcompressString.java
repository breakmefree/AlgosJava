package leet.code.easy;
/**
 * 443. String Compression
 * @author knidhi
 *
 */
public class CcompressString {
	public int compress(char[] chars) {
        if(null == chars || chars.length ==0)
            return 0;
        
        if(chars.length == 1)
            return 1;
        
        int j=0;
        char ch = chars[0];
        int count = 1;
        
        for(int i=1; i < chars.length; i++) {
            if(ch == chars[i]) {
                count++;
            } else {
                chars[j++] = ch;
                if(count != 1) {
                    String numStr = "" + count;
                    for(int a = 0; a < numStr.length(); a++) {
                        chars[j++] = numStr.charAt(a);
                    }
                }
                ch = chars[i];
                count = 1;
            }
        }
        chars[j++] = ch;
        if(count != 1) {
            String numStr = "" + count;
            for(int a = 0; a < numStr.length(); a++) {
                chars[j++] = numStr.charAt(a);
            }
        }
        return j;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		args[0].trim()

	}

}
