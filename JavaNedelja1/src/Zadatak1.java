
public class Zadatak1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int a = 3, b = 1, c = 11;
		if(a!=b) 
			if(b == c)
				a++;
			else
				b--;
		else
			c++;
		System.out.printf("a = %d, b = %d, c = %d", a, b, c);
		
		
		int i = 2, s = 0;
		do
			s+=i++;
		while(i<2);

		System.out.println(i);
		
	}

}
