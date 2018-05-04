package leet.code.easy;

public class CountAndSay {

	public static String countAndSay(int n) {
		StringBuilder curr = new StringBuilder("1");
		StringBuilder prev;
		int count;
		char say;
		for (int i = 1; i < n; i++) {
			prev = curr;
			curr = new StringBuilder();
			count = 1;
			say = prev.charAt(0);

			for (int j = 1, len = prev.length(); j < len; j++) {
				if (prev.charAt(j) != say) {
					curr.append(count).append(say);
					count = 1;
					say = prev.charAt(j);
				}
				count++;
			}
			curr.append(count).append(say);
		}
		return curr.toString();
	}

	public static void main(String[] args) {

		System.out.println(" 1      " + countAndSay(1));
		System.out.println(" 11     " + countAndSay(2));
		System.out.println(" 21     " + countAndSay(3));
		System.out.println(" 1211   " + countAndSay(4));
		System.out.println(" 111221 " + countAndSay(5));
		System.out.println(" 312211 " + countAndSay(6));

	}

}
