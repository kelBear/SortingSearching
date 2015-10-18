import java.io.*;

public class SelectionSort {
	
	private int numTerms, numSwaps, numComparisons, startNum = -100;
	int num[] = new int [numTerms];
	
	public SelectionSort(int numTerms, int startNum){
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
	}
	
	public void sort(){
		int minIndex;
		for(int index = 0; index < numTerms - 1; index++){
			minIndex = min(num, index);
			swap(num, minIndex, index);
		}
	}
	
	public int min(int[] data, int start){
		int minIndex = start;
		for(int index = start + 1; index < numTerms; index++){
			numComparisons++;
			if( data[index] < data[minIndex] ){
				minIndex = index;
			}
		}
		return minIndex;
	}
	
	public void swap(int[] data, int index1, int index2){
		int temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
		numSwaps++;
	}
	
	public double time (){
		double startTime = System.nanoTime(); 
		sort();
		double endTime = System.nanoTime();
		return endTime-startTime;
	}
	
	public void output (){
		for (int count = 0; count < numTerms; count ++){
			System.out.print (num[count]+"\t");
			if ((count+1)%5 == 0)
				System.out.println();
		}
	}

	public String toString(){
		return ("Number of Swaps: "+numSwaps+"\nNumber of Comparisons: "+numComparisons+"\nTime: "+time());
	}

}
