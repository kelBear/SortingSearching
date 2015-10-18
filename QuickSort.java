import java.io.*;

public class QuickSort {

	private int numTerms = 500, numComparisons, numSwaps, startNum = -100;
	private int num[] = new int [numTerms];

	public QuickSort(int numTerms, int startNum){
		this.numTerms = numTerms;
		this.startNum = startNum;
	}

	public void input () throws IOException{
		BufferedReader br = new BufferedReader (new FileReader("C:/Users/Kelly Guo/Desktop/"+numTerms+"-"+(-startNum)+".txt"));
		int num[] = new int [numTerms];
		this.num = num;
		numComparisons=0;
		numSwaps=0;
		for (int count = 0; count < numTerms; count ++){
			num[count] = Integer.parseInt(br.readLine());
		}
		br.close();
		quick(0, num.length-1);
	}

	public int[] quick(int low, int high) {
		int i = low, j = high;
		int pivot = num[low + (high-low)/2];
		while (i <= j) {
			numComparisons++;
			while (num[i] < pivot) {
				i++;
				numComparisons++;
			}
			while (num[j] > pivot) {
				j--;
				numComparisons++;
			}
			if (i <= j) {
				swap(i, j);
				i++;
				j--;
			}
		}
		if (low < j)
			quick(low, j);
		if (i < high)
			quick(i, high);
		return num;
	}

	private void swap(int i, int j) {
		numSwaps++;
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	public void output (){
		for (int count = 0; count < numTerms; count ++){
			System.out.print (num[count]+"\t");
			if ((count+1)%5 == 0)
				System.out.println();
		}
	}

	public double time (){
		double startTime = System.nanoTime(); 
		quick(0, num.length-1);
		double endTime = System.nanoTime();
		return endTime-startTime;
	}

	public String toString(){
		return ("Number of Swaps: "+Math.round(numSwaps)+"\nNumber of Comparisons: "+numComparisons+"\nTime: "+time());
	}
}
