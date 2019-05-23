
public class Rotation {
	
	public void rotate(int[] a,int k) {
		int n = a.length;
		int j,temp,d = -1;
		for(int i = 0; i< gcd(n,k);i++) {
			temp = a[i];
			j = i;
			while(true) {
				d = (k+j) % n;
				if(i==d)
					break;
				
				a[j] = a[d];
				j = d;
			}
			a[j] = temp;
			
		}
	}
	
	public int gcd(int a, int b) {
		if(b == 0)
			return a;
		else
			return gcd(b,a%b);
	}

}