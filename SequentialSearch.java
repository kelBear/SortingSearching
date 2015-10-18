import java.io.*;

public class SequentialSearch {

	private int numTerms = 500, startNum = -100, key;
	private int num[] = new int [numTerms];

	public SequentialSearch (int startNum, int numTerms){
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
		key = num[numTerms-1];
	}

	public void sequential() { 
		boolean found = false;  
		int n = 0;
		while (!found && n < num.length) {
			if (num[n] == key && n == numTerms-1) {
				found = true;
				break;
			}
			n+=1;
		}
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
		sequential();
		double endTime = System.nanoTime();
		return endTime-startTime;
	}

	public String toString(){
		return ("Time: "+time());
	}

}
