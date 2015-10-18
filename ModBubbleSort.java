import java.io.*;

public class ModBubbleSort {
	
	private int numTerms = 500, numSwaps, numComparisons, temp, startNum = -100;
	private  int num[] = new int [numTerms];
	
	public ModBubbleSort(int numTerms, int startNum){
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
	
	public void modBubbleSorting (){
		boolean swap = true;
		int count1 = 0;
		while ((swap) && (count1 < numTerms-1)){
			swap = false;
			for (int count2 = 0; count2 < ((numTerms-1)-count1); count2++){
				numComparisons++;
				if (num[count2] > num[count2+1]){
					temp = num[count2];
					num[count2] = num[count2+1];
					num[count2+1] = temp;
					swap = true;
					numSwaps++;
				} // end if
			} // end for
			count1 ++;
		} // end while
	} // end modBubbleSorting

	public void output (){
		for (int count = 0; count < numTerms; count ++){
			System.out.print (num[count]+"\t");
			if ((count+1)%12 == 0)
				System.out.println();
		}
	}
	
	public double time (){
		double startTime = System.nanoTime(); 
		modBubbleSorting();
		double endTime = System.nanoTime();
		return endTime-startTime;
	}
	
	public String toString(){
		return ("Number of Swaps: "+Math.round(numSwaps)+"\nNumber of Comparisons: "+numComparisons+"\nTime: "+time());
	}
}