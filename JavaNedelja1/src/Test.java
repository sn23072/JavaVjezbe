
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		short a = 32767,b = 1, c;
		//pretvaramo izraz u short
		c = (short) (a + b);
		System.out.println(c);
		
		
		int A;
		float B;
		A = 5;
		//pretvaramo izraz u float
		B = (float) 5*A/7;
		System.out.println(B);
		
		
		
		int s1,s2,q = 8;
		s1 = 1;
		//prvo uvecaj s1 za 1 pa koristi (++s1)
		s2 = ++s1 + 5;
		//znaci da se trenutna vrijednost prvo koristi pa se tek onda uveca
		s1 = s2++;
		s2+=(q%3)+q/5+2;
		System.out.println(s1);
		System.out.println(s2);
		

	}

}
