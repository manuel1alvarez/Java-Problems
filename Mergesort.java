public class Mergesort {
	
	static void merge(int[] data, int lo, int middle, int hi, int N) {
		int i, j;
		int[] aux = new int[N];
		for (i = middle + 1; i > lo; i--)
			aux[i - 1] = data[i - 1];
		for (j = middle; j < hi; j++)
			aux[hi + middle - j] = data[j + 1];
		for (int k = lo; k <= hi; k++)
			if (aux[j] < aux[i])
				data[k] = aux[j--];
			else
				data[k] = aux[i++];
	}

	static void mergesort(int[] data, int lo, int hi, int N) {
		if (hi <= lo)
			return;
		int middle = (lo + hi) / 2;
		mergesort(data, lo, middle, N);
		mergesort(data, middle + 1, hi, N);
		merge(data, lo, middle, hi, N);
	}

	public static void main(String args[]) {
		int[] data = new int[8]; // N=8
		data[0] = 23;
		data[1] = 17;
		data[2] = 41;
		data[3] = 29;
		data[4] = 13;
		data[5] = 31;
		data[6] = 37;
		data[7] = 11;

		mergesort(data, 0, 7, 8);

		for (int i = 0; i < 8; i++)
			System.out.println(data[i]);
	}

}
