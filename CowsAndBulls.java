package miniprojects;
import java.util.*;


public class CowsAndBulls {
	static Scanner scanner= new Scanner(System.in);
	static int cows=0, bulls=0, turn=1;
	
	static void game(StringBuilder code,StringBuilder inp, int n) {
		
		for(int i=0;i<code.length();i++) {
			for(int j=0; j<code.length();j++) {
				if(code.charAt(i)==inp.charAt(j)) {
					if(code.charAt(j)==inp.charAt(j)) {
						bulls++;
					}
					else {
						cows++;
					}	
				}
			}
		}
		
		if(bulls==code.length()) {
			System.out.printf("Grade: %d bulls.\n",bulls);
			System.out.println("Congratulations! You guessed the secret code.");
		}
		else if(bulls==1) {
			System.out.printf("Grade: %d bull and %d cow(s).",bulls,cows);
			System.out.println();
			cows=0; bulls=0;
		}
		else if(cows==1) {
			System.out.printf("Grade: %d bull(s) and %d cow.",bulls,cows);
			System.out.println();
			cows=0; bulls=0;
		}
		else {
			System.out.printf("Grade: %d bull(s) and %d cow(s).",bulls,cows);
			System.out.println();
			cows=0; bulls=0;
		}
	}
	
	public static void main(String[] args) {
		int n=0,m=0;
		
		try {
		System.out.println("Input the length of the secret code:");
		n= scanner.nextInt();
		}
		catch(Exception e) {
			System.out.println("Error: abc 0 -7 isn't a valid number.");
			System.exit(0);
		}
		try {
		System.out.println("Input the number of possible symbols in the code:");
		m= scanner.nextInt();
		}
		catch(Exception e) {
			System.out.println("Error: abc 0 -7 isn't a valid number.");
			System.exit(0);
		}
		
		if(m<n) {
			System.out.println("Error: it's not possible to generate a code with a length of "+n+" with "+m+" unique symbols.");
		}
		else if(m>36 || n==0){
			System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
		}
		
		else {
		//to print the corresponding number of stars
		StringBuilder stars= new StringBuilder();
		for(int i=0; i<n; i++) {
			stars.append("*");
		}
		
		StringBuilder alphabet= new StringBuilder("0123456789abcdefghijklmnopqrstuvwxyz");
		
		System.out.printf("The secret is prepared: "+stars +"(0-9, a-%c).\n",alphabet.charAt(m-1));
		System.out.println("Okay, let's start a game!");
		
		Random r= new Random();
		StringBuilder code= new StringBuilder();
		int charRange;
		
		if(n>=10){
			System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits",n);
		}
		else {
			for(int i=0; i<n; i++) {	
			   charRange= r.nextInt(m);
			   code.append(alphabet.charAt(charRange));
			    
			    for(int j=0; j<i;j++) {
			    	if(code.charAt(i)==code.charAt(j)) {
			    		code.deleteCharAt(j);
			    		i--;
			       }
			   }
			}
		}
		String input;

		System.out.println(code);
		while(bulls!=n){
			System.out.println("Turn "+turn+":");	
			input= scanner.next();
			StringBuilder inp= new StringBuilder(input);
			game(code,inp,code.length());
			turn++;
		}
		

		}
	}
}
