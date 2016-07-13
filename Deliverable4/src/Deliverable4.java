
public class Deliverable4 {
	public int[] billify (int[] x){
		int [] resultArray = new int[x.length+1];
		int sum = 0;
		for(int i=0; i<x.length; i++){
			resultArray[i] = x[i]*x[i];
			sum += resultArray[i];
		}
		//the last element equates to the sum of squares of previous elements
		resultArray[x.length] = sum;
		return resultArray;			
	}

}
