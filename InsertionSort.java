import java.io.*;

public class InsertionSort {

	private int numTerms = 500, numComparisons, temp, counter, startNum = -100;
	private double numSwaps = 0;
	int num[] = new int [numTerms];

	public InsertionSort(int numTerms, int startNum){
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

	public void insertion (){
		boolean check = false;
		for (int count = 1; count < numTerms; count ++){
			temp = num[count];
			numSwaps=numSwaps+0.33;
			counter = count;
			check = num[counter-1] > temp;
			while (check){
				numComparisons++;
				num[counter] = num[counter-1];
				numSwaps=numSwaps+0.33;
				counter = counter-1;
				if (counter == 0)
					check = false;
				else
					check = num[counter-1] > temp;
			}
			num[counter] = temp;
			numSwaps=numSwaps+(0.33);
		}
	}

	public void output (){
		System.out.println(numTerms);
		for (int count = 0; count < numTerms; count ++){
			System.out.print (num[count]+"\t");
			if ((count+1)%15 == 0)
				System.out.println();
		}
	}

	public double time (){
		double startTime = System.nanoTime(); 
		insertion();
		double endTime = System.nanoTime();
		return endTime-startTime;
	}

	public String toString(){
		return ("Number of Swaps: "+Math.round(numSwaps)+"\nNumber of Comparisons: "+numComparisons+"\nTime: "+time());
	}
}
