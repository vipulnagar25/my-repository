package com.string;

public class Permutation {
	public static void main(String[] args) {
		String str = "AB";
		int n = str.length();
		Permutation permutation = new Permutation();
		permutation.permute(str, 0, n - 1);
	}

	private void permute(String str, int l, int r) {
		//System.out.println(str+"::"+l+"::"+r);
		if (l == r)
			System.out.println(str);
		else {
			for (int i= l; i <= r; i++) {
				str = swap(str, l, i);
				//System.out.println(str+"  nagar "+"l::"+l+"=="+"i::"+i);
				permute(str, l + 1, r);
			    str = swap(str, l, i);
				//System.out.println(str+"  vipul "+"l::"+l+"=="+"i::"+i);
			}
		}
	}

	public String swap(String a, int l, int i) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[l];
		charArray[l] = charArray[i];
		charArray[i] = temp;
		//System.out.println(String.valueOf(charArray));
		return String.valueOf(charArray);
	}

}