
public class LIS {
	public void Lis(int[] arrRnd) {
		//array to hold 'current count run' and 'longest count run' 
		int[] find = {0,0,0,0};
		//iterate the array to find the longest sequence. O(n)
		//going backwards cuts down on memory, no need to use a 'list of lists' in stack form.
		//tried using divide and conquer to make O(log n). Didn`t work. If you know of a way let me know please.
		for(int u = arrRnd.length - 1; u > 0; u--) {
			//if next is greater than prev and 'current run' greater that 'longest run'
			//i know this is a useless case, but my reason was to allow 'temporal memory access' of my 'find' array for faster conditions checking
			if ((arrRnd[u] > arrRnd[u-1]) && ((find[0] - find[1]) > (find[2] - find[3]))) {
				//Increment 'current run' 
				find[1] = u;
				//TEST:
//				System.out.println("condition 1" + "Find[0]= " + find[0] + "find[1]= " + find[1] + " find[2]= " + find[2] + " find[3]=  " + find[3]);
			}else if(arrRnd[u] > arrRnd[u-1]) {
				//Increment 'current run'
				find[1] = u;
				//TEST:
//				System.out.println("condition 2" + "Find[0]= " + find[0] + "find[1]= " + find[1] + " find[2]= " + find[2] + " find[3]=  " + find[3]);
			//condition for the end of a run longer than the current longest run
			}else if((arrRnd[u] < arrRnd[u-1]) && ((find[0] - find[1]) > (find[2] - find[3]))) {
				//storing the values in the longest run positions in the 'find' array before overwriting them with the current position
				find[3] = find[1];
				find[2] = find[0];
				find[0] = u;
				find[1] = u;
				//TEST:
//				System.out.println("condition 3" + "Find[0]= " + find[0] + "find[1]= " + find[1] + " find[2]= " + find[2] + " find[3]=  " + find[3]);
			//condition for values where next is less than or equal to prev: I`m under the impression to keep duplicate values out of result
			//no 'temporal memory access' because this one condition makes any more arguments a waist
			}else if((arrRnd[u] <= arrRnd[u-1]) ) {
				//Increment 'current run' in both values
				find[0] = u;
				find[1] = u;
				//TEST:
//				System.out.println("condition 4" + "Find[0]= " + find[0] + "find[1]= " + find[1] + " find[2]= " + find[2] + " find[3]=  " + find[3]);
			}
		}//end of for loop
		//print my findings: the values were off by one. This was an easier fix, but I know 'u - 1' in the above assignment is the fix.
		System.out.println("Find : " + (find[2] - find[3] + 1) + " : pos find 2: " + (find[2] - 1) + "  : pos find 3: " + (find[3] - 1));
	}//end of 'Lis' Method
}
