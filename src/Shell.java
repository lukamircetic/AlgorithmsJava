import java.util.Random;

public class Shell {
	public static void sort(Comparable[] a)
	{
		int N = a.length;
		int h = 1;
		while(h<N/3) h = 3*h+1;
		while (h>=1)
		{
			for (int i = h; i<N; i++)
			{
				for (int j=i;  j>=h && less(a[j], a[j-h]); j-=h)
				{
					exch(a,j,j-h);
				}
			}
			h = h/3;
		}
	}
	public static boolean less(Comparable v, Comparable w)
	{ return v.compareTo(w) < 0; }
	
	public static void exch(Comparable[] a, int i, int j)
	{
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	
	public static void show(Comparable[] a)
	{
		for (int i = 0; i <a.length; i++)
		{
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}
	
	public static boolean isSorted(Comparable[] a)
	{
		for (int i=1; i<a.length;i++)
			if (less(a[i],a[i-1])) return false;
		return true;
	}
	
	public static void main(String[] args)
	{
		int SIZE = 100;
		//String [] a = {"S", "O", "R", "T","E","X", "A","M","P","L","E"};
		String [] a = new String [SIZE];
		StdOut.print("Original Array: ");
		StdOut.println();
		for (int i =0; i<SIZE;i++)
		{
//			Random random = new Random();
//			random.ints(65, 90).limit(10).forEach(arg0);
			char randomChar = (char)((int)'A'+Math.random()*((int)'Z'-(int)'A'+1));
			
			a[i] = Character.toString(randomChar);
			StdOut.print(a[i]+ " ");
		}
		StdOut.println();
		StdOut.print("Sorted Array: ");
		
		//a = StdIn.readAllStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
