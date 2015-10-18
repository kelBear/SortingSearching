import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BinarySearch {

	private int numTerms = 500, startNum = -100, key;
	private int num[] = new int [numTerms];

	public BinarySearch (int startNum, int numTerms){
		this.startNum = startNum;
		this.numTerms = numTerms;
	}

	public void input () throws IOException{
		BufferedReader br = new BufferedReader (new FileReader("C:/Users/Kelly Guo/Desktop/"+numTerms+"-"+(-startNum)+".txt"));
		int num[] = new int [numTerms];
		this.num = num;
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
			while (num[i] < pivot) {
				i++;
			}
			while (num[j] > pivot) {
				j--;
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
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	public void binary() { 
		boolean found=false; 
		int low = 0;              // low subscript
		int high = num.length - 1;  // high subscript
		int middle;               // middle subscript
		while (low <= high && found==false) {
			middle = (low + high) / 2;
			while (key == num[middle] && middle == numTerms-1){  // match
				found=true;
				break;
			}
			if (key < num[middle] )
				high = middle - 1;  // search low end of array
			else
				low = middle + 1;   // search high end of array
		}
	}

	public void output (){
		for (int count = 0; count < numTerms; count ++){
			System.out.print (num[count]+"\t");
			if ((count+1)%20 == 0)
				System.out.println();
		}
	}

	public double time (){
		double startTime = System.nanoTime(); 
		binary();
		quick(0, num.length-1);
		double endTime = System.nanoTime();
		return endTime-startTime;
	}

	public String toString(){
		return ("Time: "+time());
	}

}
