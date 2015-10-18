import java.io.*;
public class Use {

	/**
	 * @param args
	 */

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Use u1 = new Use();
		int selection;
//		u1.fileWriter();
		selection = u1.selection();
		switch(selection){
		case 1:
			u1.modBubbleSort();
			break;
		case 2:
			u1.insertionSort();
			break;
		case 3:
			u1.selectionSort();
			break;
		case 4:
			u1.quickSort();
			break;
		case 5:
			u1.sequentialSearch();
			break;
		case 6:
			u1.binarySearch();
			break;
		}
	}

	public void fileWriter () throws IOException {
		int range = 200, startNum = -100;
		for (int n = 500; n <=5000000; n=n*10){
			int[] num = new int [n];
			for (byte count = 0; count < 2; count ++){
				if (count == 0){
					range = 200;
					startNum = -100;
				}
				else if (count == 1){
					range = 200000;
					startNum = -100000;
				}
				PrintWriter pr = new PrintWriter ("C:/Users/Kelly Guo/Desktop/"+n+"-"+(-startNum)+".txt");
				for (int c = 0; c < n; c ++){
					num[c] = (int) ((Math.random()*range)+startNum);
					pr.println(num[c]);
				}
				pr.close();
			}
		}
	}

	public int selection ()throws IOException{
		int selection = 0;
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		System.out.println("Please select the Sort or Search that you would like to perform: ");
		System.out.println("1. Modified Bubble Sort");
		System.out.println("2. Insertion Sort");
		System.out.println("3. Selection Sort");
		System.out.println("4. Quick Sort");
		System.out.println("5. Sequential Search");
		System.out.println("6. Binary Search");
		selection = Integer.parseInt(br.readLine());
		return selection;
	}

	public void modBubbleSort() throws IOException{
		int range = 200, startNum = -100;
		for (int n = 500; n <=5000000; n=n*10){
			for (byte count = 0; count < 2; count ++){
				if (count == 0){
					range = 200;
					startNum = -100;
				}
				else if (count == 1){
					range = 200000;
					startNum = -100000;
				}
				ModBubbleSort mbs = new ModBubbleSort (n, startNum);
				System.out.println("For "+n+" terms at range from "+startNum+" to "+(startNum+range));
				mbs.input();
				mbs.modBubbleSorting();
				System.out.println(mbs.toString());
			}
		}
	}

	public void insertionSort() throws IOException{
		int range = 200, startNum = -100;
		for (int n = 500; n <=5000000; n=n*10){
			for (byte count = 0; count < 2; count ++){
				if (count == 0){
					range = 200;
					startNum = -100;
				}
				else if (count == 1){
					range = 200000;
					startNum = -100000;
				}
				InsertionSort is = new InsertionSort(n, startNum);
				is.input();
				is.insertion();
				System.out.println("For "+n+" terms at range from "+startNum+" to "+(startNum+range));
				System.out.println(is.toString());
	//			is.output();
			}
		}
	}

	public void selectionSort() throws IOException{
		int range = 200, startNum = -100;
		for (int n = 500; n <=5000000; n=n*10){
			for (byte count = 0; count < 2; count ++){
				if (count == 0){
					range = 200;
					startNum = -100;
				}
				else if (count == 1){
					range = 200000;
					startNum = -100000;
				}
				SelectionSort ss = new SelectionSort(n, startNum);
				ss.input();
				ss.sort();
				System.out.println("For "+n+" terms at range from "+startNum+" to "+(startNum+range));
				System.out.println(ss.toString());
			}
		}
	}

	public void quickSort() throws IOException{
		int range = 200, startNum = -100;
		for (int n = 500; n <=5000000; n=n*10){
			for (byte count = 0; count < 2; count ++){
				if (count == 0){
					range = 200;
					startNum = -100;
				}
				else if (count == 1){
					range = 200000;
					startNum = -100000;
				}
				QuickSort qs = new QuickSort(n, startNum);
				qs.input();
	//			qs.output();
				System.out.println("For "+n+" terms at range from "+startNum+" to "+(startNum+range));
				System.out.println(qs.toString());
			}
		}
	}

	public void sequentialSearch() throws IOException{
		int range = 200, startNum = -100;
		for (int n = 500; n <=5000000; n=n*10){
			for (byte count = 0; count < 2; count ++){
				if (count == 0){
					range = 200;
					startNum = -100;
				}
				else if (count == 1){
					range = 200000;
					startNum = -100000;
				}
				SequentialSearch ss2 = new SequentialSearch(startNum, n);
				ss2.input();
				ss2.sequential();
				//	ss2.output();  
				System.out.println("For "+n+" terms at range from "+startNum+" to "+(startNum+range));
				System.out.println(ss2.toString());
			}
		}
	}

	public void binarySearch() throws IOException{
		int range = 200, startNum = -100;
		for (int n = 500; n <=5000000; n=n*10){
			for (byte count = 0; count < 2; count ++){
				if (count == 0){
					range = 200;
					startNum = -100;
				}
				else if (count == 1){
					range = 200000;
					startNum = -100000;
				}
				BinarySearch bs = new BinarySearch(startNum, n);
				bs.input();
				bs.binary();
	//			bs.output();  
				System.out.println("For "+n+" terms at range from "+startNum+" to "+(startNum+range));
				System.out.println(bs.toString());
			}
		}
	}
}
